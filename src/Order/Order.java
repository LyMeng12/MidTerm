//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Order;

import Customer.Customer;
import Product.Product;
import java.io.PrintStream;
import java.util.ArrayList;

public class Order {
    private int orderId;
    private Customer customer;
    private ArrayList<Product> products;
    private double totalPrice;
    private double payment;
    private String paymentBy;
    private String status;

    public Order(int orderId, Customer customer, ArrayList<Product> products, double totalPrice, double payment, String status, String paymentBy) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
        this.totalPrice = totalPrice;
        this.payment = payment;
        this.status = status;
        this.paymentBy = paymentBy;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaymentBy(String paymentBy) {
        this.paymentBy = paymentBy;
    }

    public String getPaymentBy() {
        return this.paymentBy;
    }

    public String getStatus() {
        return this.status;
    }

    public double getPayment() {
        return this.payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice += totalPrice;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void printOrderPayment() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("Order ID: " + this.getOrderId());
        System.out.println("Customer Name: " + this.getCustomer().getCustomerName() + "| Customer Gender: " + this.getCustomer().getCustomerGender());
        System.out.println("Customer PhoneNumber: " + this.getCustomer().getCustomerNumber());
        System.out.println("-------------- Product List --------------");

        for(Product product : this.getProducts()) {
            System.out.println("| Product ID:" + product.getProductId() + "| Product Name: " + product.getProductName() + "| Product Price: \ud83d\udcb5" + product.getProductPrice() + "| Product Qty: \ud83d\udce6" + product.getGetProductQty());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("Total Price: \ud83d\udcb5" + this.getTotalPrice());
        System.out.println("Payment: \ud83d\udcb5" + this.getPayment());
        System.out.println("PaymentBy: " + this.getPaymentBy());
        System.out.println("Status: " + this.getStatus());
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
    }
    public void printOrderNotPayment() {
        System.out.println("Order ID: " + this.getOrderId()+"| Customer Name: " + this.getCustomer().getCustomerName()+"| Customer Gender: " + getCustomer().getCustomerGender() + "| Customer PhoneNumber: " + getCustomer().getCustomerNumber());
    }
}
