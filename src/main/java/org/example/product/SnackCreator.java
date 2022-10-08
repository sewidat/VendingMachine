package org.example.product;

public class SnackCreator implements Product {
    private String snackName = "snack";
    private double productPrice = 59.9;

    @Override
    public String getProductName() {
        return snackName;
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean setProductBarCode(String barcode) {
        return false;
    }
}
