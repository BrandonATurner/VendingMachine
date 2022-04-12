/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import vendingmachine.dto.Change;
import vendingmachine.dto.Item;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author andri
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";

    private Map<String, Item> items = new HashMap<>();
    private VendingMachine vm = new VendingMachine();
    private Change change = new Change();

    @Override
    public List<Item> getAllItems()
            throws VendingMachinePersistenceException {
        loadRoster();
        return new ArrayList<Item>(items.values());
    }

    @Override
    public Item getItem(String itemName) 
        throws VendingMachinePersistenceException {
        loadRoster();
        return items.get(itemName);
    }
    
    @Override
    public void decrementItem(String itemName)
        throws VendingMachinePersistenceException{
        
        //Convert inventory string to int and decrement
        Item decrementedItem = getItem(itemName);
        int invAmount = Integer.parseInt(decrementedItem.getItemInventory());
        invAmount--;
        
        //Return set new inventory amount and return decremented item to items map
        decrementedItem.setItemInventory(Integer.toString(invAmount));
        items.put(itemName, decrementedItem);
        writeRoster();
    
    }
    
    
    @Override
    public BigDecimal getBalance(){
        return vm.getBalance();
    }
    @Override
    public String updateBalance(BigDecimal balance){
        vm.setBalance(balance);
        change.setAmount(balance);
        change.setChange();
        return change.getChange();
    }

    private Item unmarshallItem(String itemAsText) {
        String[] itemTokens = itemAsText.split(DELIMITER);

        // Given the pattern above, the item name is in index 0 of the array.
        String itemName = itemTokens[0];

        // Which we can then use to create a new Item object to satisfy
        // the requirements of the Item constructor.
        Item itemFromFile = new Item(itemName);

        // However, there are 2 remaining tokens that need to be set into the
        // new item object. Do this manually by using the appropriate setters.
        // Index 1 - ItemCost
        itemFromFile.setItemCost(itemTokens[1]);

        // Index 2 - ItemInventory
        itemFromFile.setItemInventory(itemTokens[2]);

        // We have now created a item! Return it!
        return itemFromFile;
    }

    private void loadRoster() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load inventory data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        Item currentItem;
        // Go through INVENTORY_FILE line by line, decoding each line into a 
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentItem = unmarshallItem(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            items.put(currentItem.getItemName(), currentItem);
        }
        // close scanner
        scanner.close();
    }

    private String marshallItem(Item aItem) {
        // We need to turn a Student object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer. 
        // Start with the student id, since that's supposed to be first.
        String itemAsText = aItem.getItemName() + DELIMITER;

        // add the rest of the properties in the correct order:
        // FirstName
        itemAsText += aItem.getItemCost() + DELIMITER;

        // LastName
        itemAsText += aItem.getItemInventory() + DELIMITER;

        // We have now turned a student to text! Return it!
        return itemAsText;
    }

    /**
     * Writes all students in the roster out to a ROSTER_FILE. See loadRoster
     * for file format.
     *
     * @throws ClassRosterDaoException if an error occurs writing to the file
     */
    private void writeRoster() throws VendingMachinePersistenceException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save item data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        String itemAsText;
        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            // turn a Student into a String
            itemAsText = marshallItem(currentItem);
            // write the Student object to the file
            out.println(itemAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
