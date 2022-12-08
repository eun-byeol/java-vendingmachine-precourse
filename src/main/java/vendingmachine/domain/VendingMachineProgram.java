package vendingmachine.domain;

import static vendingmachine.utils.ErrorMassage.*;

public class VendingMachineProgram {
    private MachineMoney machineMoney;
    private MachineCoins machineCoins;
    private SaleProducts saleProducts;
    private CustomerMoney customerMoney;

    public VendingMachineProgram(String money) {
        machineMoney = new MachineMoney(money);
        machineCoins = new MachineCoins(machineMoney.getMachineMoney());
    }

    public void fillUpSaleProducts(String productInformation) {
        saleProducts = new SaleProducts(productInformation);
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

    private Product validateCorrectProductName(String productName) {
        for (Product product : saleProducts.getProducts()) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        throw new IllegalArgumentException(PRODUCT_NAME_IS_NOT_VALID);
    }
}
