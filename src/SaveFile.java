//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Customer.Customer;
import Order.Order;
import Product.Product;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveFile  {
    private ArrayList<Order> order;
    private ArrayList<Product> products;
    private ArrayList<Customer> customers;

    public void SaveOrder(ArrayList<Order> order) throws IOException {
        this.order = order;
        FileWriter fOrder = new FileWriter("Orders.txt");
        String productid = "";

        for(Order orders : this.order) {
            for(Product p : orders.getProducts()) {
                productid += p.getProductId() + ":" + p.getProductName() + ":" + p.getProductPrice() + ":" + p.getGetProductQty() + "|";
            }
            Customer customer = orders.getCustomer();
            String cus =customer.getCustomerId() + "," + customer.getCustomerName()+ "," +customer.getCustomerGender()+ "," +customer.getCustomerNumber();

            fOrder.write(orders.getOrderId() + "," +cus+ "," + productid + "," + orders.getTotalPrice() + "," + orders.getPayment() +  "," + orders.getStatus() +"," + orders.getPaymentBy() + "\n");
        }

        fOrder.close();
    }
    public void SaveProduct(ArrayList<Product> products) throws IOException {
        this.products = products;
        FileWriter fProduct = new FileWriter("Products.txt");
        for(Product p : this.products) {
            fProduct.write(p.getProductId() + "," + p.getProductName() + "," + p.getProductPrice() + "," + p.getGetProductQty() + "\n");
        }

        fProduct.close();
    }
    public void SaveCustomer(ArrayList<Customer> customers) throws IOException {
        this.customers = customers;
        FileWriter fCustomer = new FileWriter("Customers.txt");
        for(Customer c : this.customers) {
            fCustomer.write(c.getCustomerId() + "," + c.getCustomerName() + "," + c.getCustomerGender() + "," + c.getCustomerNumber() + ",\n");
        }

        fCustomer.close();
    }
//    public void run() {
//        try {
//            FileWriter fOrder = new FileWriter("Orders.txt");
//            FileWriter fProduct = new FileWriter("Products.txt");
//            FileWriter fCustomer = new FileWriter("Customers.txt");
//            String productid = "";
//
//            for(Order orders : this.order) {
//                for(Product p : orders.getProducts()) {
//                    productid += p.getProductId() + ":" + p.getProductName() + ":" + p.getProductPrice() + ":" + p.getGetProductQty() + "|";
//                }
//                Customer customer = orders.getCustomer();
//                String cus =customer.getCustomerId() + "," + customer.getCustomerName()+ "," +customer.getCustomerGender()+ "," +customer.getCustomerNumber();
//
//                fOrder.write(orders.getOrderId() + "," +cus+ "," + productid + "," + orders.getTotalPrice() + "," + orders.getPayment() +  "," + orders.getStatus() +"," + orders.getPaymentBy() + "\n");
//            }
//
//            fOrder.close();
//
//            for(Product p : this.products) {
//                fProduct.write(p.getProductId() + "," + p.getProductName() + "," + p.getProductPrice() + "," + p.getGetProductQty() + "\n");
//            }
//
//            fProduct.close();
//
//            for(Customer c : this.customers) {
//                fCustomer.write(c.getCustomerId() + "," + c.getCustomerName() + "," + c.getCustomerGender() + "," + c.getCustomerNumber() + ",\n");
//            }
//
//            fCustomer.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
}
