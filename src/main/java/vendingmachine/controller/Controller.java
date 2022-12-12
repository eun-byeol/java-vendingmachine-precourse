package vendingmachine.controller;

import vendingmachine.domain.VendingMachineProgram;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

public class Controller {
    public void run() {
        VendingMachineProgram vendingMachine = createVendingMachineProgram();
        printVendingMachineCoins(vendingMachine.getMachineCoins());

        inputSaleProducts(vendingMachine);
        inputCustomerMoney(vendingMachine);

        order(vendingMachine);

        printChanges(vendingMachine.returnChanges());
    }

    private void order(VendingMachineProgram vendingMachine) {
        while(true) {
            printCustomerMoney(vendingMachine.getCustomerMoney());
            if (vendingMachine.isNotEnoughCustomerMoney()) {
                return;
            }
            if (vendingMachine.isAllSoldOut()) {
                return;
            }
            inputProductToBuy(vendingMachine);
        }
    }

    private VendingMachineProgram createVendingMachineProgram() {
        while (true) {
            try {
                return new VendingMachineProgram(readVendingMachineMoney());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputSaleProducts(VendingMachineProgram vendingMachine) {
        while (true) {
            try {
                vendingMachine.fillUpSaleProducts(readProductInformation());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputCustomerMoney(VendingMachineProgram vendingMachine) {
        while (true) {
            try {
                vendingMachine.putCustomerMoney(readCustomerMoney());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void inputProductToBuy(VendingMachineProgram vendingMachine) {
        while (true) {
            try {
                vendingMachine.pushButtonOfProductToBuy(readProductNameToBuy());
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}