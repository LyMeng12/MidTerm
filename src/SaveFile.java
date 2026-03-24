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
                    productid = p.getProductId() + ":" + p.getProductName() + ":" + p.getProductPrice() + ":" + p.getGetProductQty() + "|";
                    orders.setTotalPrice(p.getProductPrice() + p.getGetProductQty());
                }
                Customer customer = orders.getCustomer();
                String cus =customer.getCustomerId() + "," + customer.getCustomerName()+ "," +customer.getCustomerGender()+ "," +customer.getCustomerNumber();

                fOrder.write(orders.getOrderId() + "," +cus+ "," + productid + "," + orders.getTotalPrice() + "," + orders.getPayment() +  "," + orders.getStatus() +"," + orders.getPaymentBy() + "\n");
            }

            fOrder.close();

            for(Product p : this.products) {
                fProduct.write(p.getProductId() + "," + p.getProductName() + "," + p.getProductPrice() + "," + p.getGetProductQty() + "\n");
            }

            fProduct.close();

            for(Customer c : this.customers) {
                fCustomer.write(c.getCustomerId() + "," + c.getCustomerName() + "," + c.getCustomerGender() + "," + c.getCustomerNumber() + ",\n");
            }

            fCustomer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
