package vendingmachine.domain;

import vendingmachine.enums.Coin;

import java.util.LinkedHashMap;
import java.util.Map;

import static vendingmachine.utils.ErrorMassage.*;

public class VendingMachineProgram {
    private MachineMoney machineMoney;
    private MachineCoins machineCoins;
    private SalesProducts saleProducts;
    private CustomerMoney customerMoney;

    public VendingMachineProgram(String money) {
        machineMoney = new MachineMoney(money);
        machineCoins = new MachineCoins(machineMoney.getMachineMoney());
    }

    public void fillUpSaleProducts(String productInformation) {
        saleProducts = new SalesProducts(productInformation);
    }

    public void putCustomerMoney(String customerMoney) {
        this.customerMoney = new CustomerMoney(customerMoney);
    }

    public void pushButtonOfProductToBuy(String productName) {
        Product productToBuy = validateCorrectProductName(productName.trim());
        if (productToBuy.isOutOfStock()) {
            throw new IllegalArgumentException(PRODUCT_IS_OUT_OF_STOCK);
        }
        if (productToBuy.isNotEnoughMoney(customerMoney.getCustomerMoney())) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
        }
        productToBuy.subOneFromQuantity();
        customerMoney.subPriceFromCustomerMoney(productToBuy.getPrice());
    }

    public LinkedHashMap<Coin, Integer> returnChanges() {
        return machineCoins.giveChange(customerMoney.getCustomerMoney());
    }

    public boolean isAllSoldOut() {
        return saleProducts.isAllSoldOut();
    }

    public boolean isNotEnoughCustomerMoney() {
        return customerMoney.getCustomerMoney() < saleProducts.returnPriceOfCheapestProduct();
    }

    private Product validateCorrectProductName(String productName) {
        for (Product product : saleProducts.getProducts()) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        throw new IllegalArgumentException(PRODUCT_NAME_IS_NOT_VALID);
    }

    public Map<Coin, Integer> getMachineCoins() {
        return machineCoins.getCoins();
    }

    public int getCustomerMoney() {
        return customerMoney.getCustomerMoney();
    }
}
