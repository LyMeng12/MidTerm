//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Customer.Customer;
import Order.Order;
import Product.Product;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class OutputFile extends Thread {
    private ArrayList<Customer> customer = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Customer> getCustomer() {
        return this.customer;
    }

    public void setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void run(){
        try {
            File fileOrder = new File("Orders.txt");
            File fileCustomer = new File("Customers.txt");
            File fileProduct = new File("Products.txt");

            if (!fileOrder.exists()) fileOrder.createNewFile();
            if (!fileCustomer.exists()) fileCustomer.createNewFile();
            if (!fileProduct.exists()) fileProduct.createNewFile();

            Scanner sc = new Scanner(fileOrder);
            Scanner sc1 = new Scanner(fileCustomer);
            Scanner sc2 = new Scanner(fileProduct);
            ArrayList<Customer> customerslist = new ArrayList();
            ArrayList<Product> productlist = new ArrayList();
            ArrayList<Order> ordersArrayList = new ArrayList();

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if (!line.trim().isEmpty()) {
                    String[] data = line.split(",");
                    Customer customer = new Customer(Integer.parseInt(data[1]), data[2], data[3], data[4]);
                    ArrayList<Product> products = new ArrayList();
                    String[] productArr = data[5].split("\\|");

                    for(String p : productArr) {
                        String[] pData = p.split(":");
                        Product product = new Product(Integer.parseInt(pData[0]), pData[1], Double.parseDouble(pData[2]), Integer.parseInt(pData[3]));
                        products.add(product);
                    }
                    Order order = new Order(Integer.parseInt(data[0]), customer, products, Double.parseDouble(data[6]), Double.parseDouble(data[7]), data[8], data[9]);
                    ordersArrayList.add(order);
                }
            }

            setOrders(ordersArrayList);

            while(sc1.hasNextLine()) {
                String line2 = sc1.nextLine();
                if (!line2.trim().isEmpty()) {
                    String[] data = line2.split(",");
                    customerslist.add(new Customer(Integer.parseInt(data[0]), data[1], data[2], data[3]));
                }
            }
            setCustomer(customerslist);

            while(sc2.hasNextLine()) {
                String line1 = sc2.nextLine();
                if (!line1.trim().isEmpty()) {
                    String[] data = line1.split(",");
                    productlist.add(new Product(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3])));
                }
            }

            setProducts(productlist);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
