/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoFileImpl;
import vendingmachine.service.VendingMachineServiceLayer;
import vendingmachine.service.VendingMachineServiceLayerImpl;
import vendingmachine.ui.UserIO;
import vendingmachine.ui.UserIOConsoleImpl;
import vendingmachine.ui.VendingMachineView;

/**
 *
 * @author andri
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        VendingMachineView myView = new VendingMachineView(myIo);
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
        VendingMachineController controller = new VendingMachineController(myService, myView);
        controller.run();
    }
}
