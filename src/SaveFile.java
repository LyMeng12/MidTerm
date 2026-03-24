//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Customer.Customer;
import Order.Order;
import Product.Product;
import java.io.FileWriter;
import java.util.ArrayList;

public class SaveFile extends Thread {
    private ArrayList<Order> order;
    private ArrayList<Product> products;
    private ArrayList<Customer> customers;

    public SaveFile(ArrayList<Order> order, ArrayList<Product> products, ArrayList<Customer> customers) {
        this.order = order;
        this.products = products;
        this.customers = customers;
    }

    public void run() {
        try {
            FileWriter fOrder = new FileWriter("Orders.txt");
            FileWriter fProduct = new FileWriter("Products.txt");
            FileWriter fCustomer = new FileWriter("Customers.txt");
            String productid = "";

            for(Order orders : this.order) {
                for(Product p : orders.getProducts()) {
                    productid = productid + p.getProductId() + ":" + p.getProductName() + ":" + p.getProductPrice() + ":" + p.getGetProductQty() + "|";
                    orders.setTotalPrice(p.getProductPrice() + (double)p.getGetProductQty());
                }

                int var10001 = orders.getOrderId();
                fOrder.write(var10001 + "," + orders.getCustomer().getCustomerName() + "," + orders.getCustomer().getCustomerGender() + "," + orders.getCustomer().getCustomerNumber() + "," + productid + "," + orders.getTotalPrice() + "," + orders.getPayment() + "," + orders.getPaymentBy() + "," + orders.getStatus() + "\n");
            }

            fOrder.close();

            for(Product p : this.products) {
                int var15 = p.getProductId();
                fProduct.write(var15 + "," + p.getProductName() + "," + p.getProductPrice() + "," + p.getGetProductQty() + "\n");
            }

            fProduct.close();

            for(Customer c : this.customers) {
                int var16 = c.getCustomerId();
                fCustomer.write(var16 + "," + c.getCustomerName() + "," + c.getCustomerGender() + "," + c.getCustomerNumber() + ",\n");
            }

            fCustomer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
