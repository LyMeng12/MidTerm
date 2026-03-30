//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Product;

import java.io.PrintStream;

public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private int ProductQty;

    public Product(int productId, String productName, double productPrice, int getProductQty) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.ProductQty = getProductQty;
    }

    public int getGetProductQty() {
        return this.ProductQty;
    }

    public void setGetProductQty(int getProductQty) {
        this.ProductQty = getProductQty;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice =productPrice;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void PrintProduct() {
        System.out.println("Product Id: " + getProductId() + "|\tName : " + this.getProductName() + "|\tPrice : " + this.getProductPrice() + "|\tQuantity : " + this.getGetProductQty());
    }
}
