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
        System.out.println("=================================================");
        System.out.println("\t #Order" + this.getOrderId());
        System.out.println("=================================================");
        System.out.println("Customer Name: " + this.getCustomer().getCustomerName() + " Customer Gender: " + this.getCustomer().getCustomerGender());
        System.out.println("Customer PhoneNumber: " + this.getCustomer().getCustomerNumber());
        System.out.println("=================================================");
        System.out.println("------------------ Product List -----------------");
        System.out.println("=================================================");
        System.out.println("ID\t\tName\t\tPrice\t\tQuantity");
        for(Product product : this.getProducts()) {
            System.out.println(product.getProductId() +"\t\t"+ product.getProductName() + "\t\t\ud83d\udcb5" + product.getProductPrice() + "\t\t\ud83d\udce6" + product.getGetProductQty());
        }
        System.out.println("-------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\tTotal Price: \ud83d\udcb5" + this.getTotalPrice());
        System.out.println("\t\t\t\t\t\t\tPayment: \ud83d\udcb5" + this.getPayment());
        System.out.println("\t\t\t\t\t\t\tPaymentBy: " + this.getPaymentBy());
        System.out.println("-------------------------------------------------");
    }
    public void printOrderNotPayment() {
        System.out.println(this.getOrderId()+"\t\t" + this.getCustomer().getCustomerName()+"\t\t" + getCustomer().getCustomerGender() + "\t\t" + getCustomer().getCustomerNumber());
    }
}
