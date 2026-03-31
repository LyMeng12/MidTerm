//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Customer.Customer;
import Order.Order;
import Product.Product;

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SaveFile saveFile = new SaveFile();
        OutputFile outputFile = new OutputFile();
        outputFile.start();
        try {
            outputFile.join();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        Scanner sc = new Scanner(System.in);
        ArrayList<Order> orders = outputFile.getOrders();
        ArrayList<Customer> customers = outputFile.getCustomer();
        ArrayList<Product> products = outputFile.getProducts();
        boolean run = true;
        int id=0;
        while(run) {
            System.out.println("=================================================");
            System.out.println("\t\t\tWelcome Shop List\ud83d\udcbb\ud83d\udcbb");
            System.out.println("=================================================");
            System.out.println("1.Manage Product\ud83d\udcdd");
            System.out.println("2.Manage Customer\ud83e\uddd1\u200d\ud83e\uddb1");
            System.out.println("3.Create Order\ud83d\udcb3");
            System.out.println("4.View Order\ud83d\udccb");
            System.out.println("5.Process Order\ud83d\udd04️");
            System.out.println("6.Exit\ud83c\udd91");
            int choice=0;
            while (true) {
                System.out.print("Pleas choice Option: ");
                try{
                    choice = sc.nextInt();
                    if (choice >=1 && choice <=6){
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid number");
                    sc.next();
                }
            }
            switch (choice) {
                case 1: {
                    boolean checkproduct = true;
                    while (checkproduct) {
                        System.out.println("=================================================");
                        System.out.println("\t\t\tManage Product \ud83d\udcdd");
                        System.out.println("=================================================");
                        System.out.println("1.View Product");
                        System.out.println("2.Add Product");
                        System.out.println("3.Update Product");
                        System.out.println("4.Delete Product");
                        System.out.println("5.Close Product");
                        while (true){
                            System.out.print("Pleas choice Option: ");
                            try{
                                choice = sc.nextInt();
                                if (choice >=1 && choice <=5){
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid number");
                                sc.next();
                            }
                        }
                        switch (choice) {
                            case 1: {
                                System.out.println("=================================================");
                                System.out.println("\t\t\tProduct Low in Stock");
                                System.out.println("=================================================");
                                ArrayList<Product> lowproducts = new ArrayList<Product>();

                                for(Product product : products) {
                                    if(product.getGetProductQty()<10){
                                        lowproducts.add(product);
                                    }
                                }
                                if (lowproducts.isEmpty()) {
                                    System.out.println("Not Product Have");
                                }else {
                                    System.out.println("ID\t\tName\t\tPrice\tQuantity");
                                    for (Product product : lowproducts) {
                                        product.PrintProduct();
                                    }
                                }
                                System.out.println("-------------------------------------------------");
                                System.out.println("=================================================");
                                System.out.println("\t\t\tProduct in Stock");
                                System.out.println("=================================================");
                                if(products.isEmpty()) {
                                    System.out.println("Not Product Have");
                                    System.out.println("-------------------------------------------------");

                                }else {
                                    System.out.println("ID\t\tName\t\tPrice\tQuantity");
                                    for(Product product : products) {
                                        if(product.getGetProductQty()>10){
                                            product.PrintProduct();
                                        }
                                    }
                                    System.out.println("-------------------------------------------------");
                                }

                            }break;
                            case 2: {
                                System.out.println("=================================================");
                                System.out.println("\t\t\tAdd Product");
                                System.out.println("=================================================");
                                int productID = 0;
                                for (Product product : products) {
                                    productID=product.getProductId();
                                }
                                productID+=1;
                                sc.nextLine();
                                System.out.print("Product Name: ");
                                String productName = sc.nextLine();
                                System.out.print("Product Price: ");
                                double productPrice = sc.nextDouble();
                                while (productPrice <0){
                                    System.out.print("Product Price Again: ");
                                    productPrice = sc.nextDouble();
                                }
                                System.out.print("Product Quantity: ");
                                int productQuantity = sc.nextInt();
                                while (productQuantity < 0) {
                                    System.out.print("Product Quantity Again: ");
                                    productQuantity = sc.nextInt();
                                }
                                products.add(new Product(productID, productName, productPrice, productQuantity));
                                try {
                                    saveFile.SaveProduct(products);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }break;
                            case 3: {
                                System.out.println("=================================================");
                                System.out.println("\t\t\tUpdate Product");
                                System.out.println("=================================================");
                                System.out.println("1.Add More Product Qty");
                                System.out.println("2.Update Product (Name and Price)");
                                while (true){
                                    System.out.print("Pleas choice Option: ");
                                    try{
                                        choice = sc.nextInt();
                                        if (choice <=1 || choice >=2){
                                            break;
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Invalid number");
                                        sc.next();
                                    }
                                }
                                switch (choice) {
                                    case 1: {
                                        System.out.println("=================================================");
                                        System.out.println("------------- Add More Product Qty --------------");
                                        System.out.println("=================================================");
                                        for (Product product : products) {
                                            product.PrintProduct();
                                        }
                                        boolean  checkQty = true;
                                        while (checkQty) {
                                            System.out.print("Enter Product ID: ");
                                            int productID = sc.nextInt();
                                            for (Product product : products) {
                                                if (product.getProductId() == productID) {
                                                    System.out.print("Enter Product Qty: ");
                                                    int productQty = sc.nextInt();
                                                    while (productQty<0 ){
                                                        System.out.print("Enter Product Qty Again: ");
                                                        productQty = sc.nextInt();
                                                    }
                                                    product.setGetProductQty(product.getGetProductQty()+productQty);
                                                    checkQty = false;
                                                    break;
                                                }
                                            }
                                            if (checkQty) {
                                                System.out.println("Invalid Product ID");
                                            }
                                        }
                                        try {
                                            saveFile.SaveProduct(products);
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }break;
                                    case 2: {
                                        System.out.println("=================================================");
                                        System.out.println("-------- Update Product(Name and Price) ---------");
                                        System.out.println("=================================================");
                                        System.out.println("ID\t\tName\t\tPrice\tQuantity");
                                        for (Product product : products) {
                                            product.PrintProduct();
                                        }
                                        boolean checkupdate = true;
                                        while (checkupdate) {
                                            System.out.print("Enter Product ID: ");
                                            int productID = sc.nextInt();
                                            for (Product product : products) {
                                                if (product.getProductId() == productID) {
                                                    System.out.print("Product Name: ");
                                                    String productName = sc.next();
                                                    System.out.print("Product Price: ");
                                                    double productPrice = sc.nextDouble();
                                                    product.setProductName(productName);
                                                    product.setProductPrice(productPrice);
                                                    for(Order order : orders) {
                                                        if(order.getTotalPrice()>order.getPayment()){
                                                            for(Product productupdate : order.getProducts()) {
                                                                if(productID==productupdate.getProductId()){
                                                                    productupdate.setProductName(productName);
                                                                    productupdate.setProductPrice(productPrice);
                                                                }
                                                            }
                                                        }

                                                    }
                                                    checkupdate = false;
                                                    break;
                                                }

                                            }
                                            if (checkupdate) {
                                                System.out.println("Product ID: " + productID+ " Not Found!");
                                            }
                                        }

                                        try {
                                            saveFile.SaveProduct(products);
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                        try {
                                            saveFile.SaveOrder(orders);
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }break;
                                }
                            }break;
                            case 4: {
                                System.out.println("=================================================");
                                System.out.println("\t\t\tDelete Product");
                                System.out.println("=================================================");
                                ArrayList<Integer> productID = new ArrayList<>();
                                for (Order order : orders) {
                                    for (Product product :order.getProducts()) {
                                        productID.add(product.getProductId());
                                    }
                                }

                                ArrayList<Integer> productIDs = new ArrayList<>(new LinkedHashSet<>(productID));
                                ArrayList<Integer> IDS = new ArrayList<>();
                                for (Product product : products) {
                                    if(!productIDs.contains(product.getProductId())) {
                                        IDS.add(product.getProductId());
                                    }
                                }
                                if(IDS.isEmpty()){
                                    System.out.println("Not Found!");
                                    System.out.println("-------------------------------------------------");
                                }else {
                                    System.out.println("ID\t\tName\t\tPrice\tQuantity");
                                    for (Product product : products) {
                                        if(!productIDs.contains(product.getProductId())) {
                                            product.PrintProduct();
                                        }
                                    }
                                    System.out.println("-------------------------------------------------");
                                    boolean delete = true;
                                    while (delete) {
                                        System.out.print("Enter Product ID: ");
                                        int deleteProductID = sc.nextInt();
                                        for (Product product : products) {
                                            if (!productIDs.contains(product.getProductId()))
                                                if (product.getProductId() == deleteProductID) {
                                                    products.remove(product);
                                                    delete = false;
                                                    break;
                                                }
                                        }
                                        if (delete) {
                                            System.out.println("Product ID: " + deleteProductID + " Not Found!");
                                        }
                                    }
                                    try {
                                        saveFile.SaveProduct(products);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }

                            }break;
                            case 5: {checkproduct=false;}break;
                        }
                    }
                }break;
                case 2: {
                    boolean customercheck = true;
                    while(customercheck) {
                        System.out.println("=================================================");
                        System.out.println("\t\t\tManage Customer\ud83d\udcbb\ud83d\udcbb");
                        System.out.println("=================================================");
                        System.out.println("1.view Customer");
                        System.out.println("2.Register Customer");
                        System.out.println("3.Update Customer");
                        System.out.println("4.Delete Customer");
                        System.out.println("5.Close Customer");
                        while (true){
                            System.out.print("Pleas choice Option: ");
                            try{
                                choice = sc.nextInt();
                                if (choice >=1 && choice <=5){
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid number");
                                sc.next();
                            }
                        }
                        switch (choice) {
                            case 1: {
                                System.out.println("=================================================");
                                System.out.println("--------------------- Customer ----------------- ");
                                System.out.println("=================================================");
                                if(customers.isEmpty()) {
                                    System.out.println("Not View Customer");
                                }else {
                                    System.out.println("ID\t\tName\t\tGender\t\tPhone_number");
                                    for (Customer customer : customers) {
                                        customer.displayCustomerDetails();
                                    }
                                }
                                System.out.println("-------------------------------------------------");
                            }break;
                            case 2: {
                                System.out.println("=================================================");
                                System.out.println("--------------- Register Customer ---------------");
                                System.out.println("=================================================");
                                int customerID = 0;
//                                System.out.println("ID\t\tName\t\tGender\t\tPhone_number");
                                for (Customer customer : customers) {
                                    customerID=customer.getCustomerId();
                                }
                                customerID+=1;
                                System.out.print("Customer Name: ");
                                String customerName = sc.next();
                                System.out.print("Customer Gender(Male/Female): ");
                                String customerGender = sc.next();
                                while ( !customerGender.equals("Male") && !customerGender.equals("Female")) {
                                    System.out.print("Enter Customer Gender Again: ");
                                    customerGender = sc.next();
                                }

                                System.out.print("Customer PhoneNumber: ");
                                String customerPhoneNumber = sc.next();
                                customers.add(new Customer(customerID, customerName, customerGender, customerPhoneNumber));
                                try {
                                    saveFile.SaveCustomer(customers);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }break;
                            case 3: {
                                System.out.println("=================================================");
                                System.out.println("---------------- Update Customer --------------- ");
                                System.out.println("=================================================");
                                System.out.println("ID\t\tName\t\tGender\t\tPhone_number");
                                for(Customer customer : customers) {
                                    customer.displayCustomerDetails();
                                }
                                System.out.println("-------------------------------------------------");
                                boolean checkupdateID = true;
                                String customerName="";
                                String customerGender="";
                                String customerPhoneNumber="";
                                int customerID=0;

                                while (checkupdateID) {
                                    System.out.print("Enter Customer ID: ");
                                    customerID = sc.nextInt();
                                    for (Customer customer : customers) {
                                        if (customer.getCustomerId() == customerID) {
                                            System.out.print("Customer Name: ");
                                            customerName = sc.next();
                                            customer.setCustomerName(customerName);
                                            System.out.print("Enter Customer Gender(Male/Female): ");
                                            customerGender = sc.next();
                                            while ( !customerGender.equals("Male") && !customerGender.equals("Female")) {
                                                System.out.print("Enter Customer Gender Again: ");
                                                customerGender = sc.next();
                                            }
                                            customer.setCustomerGender(customerGender);
                                            System.out.print("Customer PhoneNumber: ");
                                            customerPhoneNumber = sc.next();
                                            customer.setCustomerNumber(customerPhoneNumber);
                                            checkupdateID = false;
                                            break;

                                        }
                                    }
                                    if (checkupdateID) {
                                        System.out.println("Customer ID: " + customerID + " Not Found!");
                                    }
                                }
                                Customer customerupdate = new Customer(customerID, customerName, customerGender, customerPhoneNumber);
                                for(Order order : orders) {
                                    if (order.getCustomer().getCustomerId() == customerID) {
                                        order.setCustomer(customerupdate);
                                        break;
                                    }
                                }
                                try {
                                    saveFile.SaveCustomer(customers);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                try {
                                    saveFile.SaveOrder(orders);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }break;
                            case 4:{
                                ArrayList<Integer> Find = new ArrayList<>();
                                ArrayList<Integer> CustomerIDs = new ArrayList<>();
                                for (Order order : orders) {
                                    CustomerIDs.add(order.getCustomer().getCustomerId());
                                }
                                ArrayList<Integer> list = new ArrayList<>(new LinkedHashSet<>(CustomerIDs));
                                System.out.println("=================================================");
                                System.out.println("---------------- Delete Customer --------------- ");
                                System.out.println("=================================================");
                                for (Customer customer : customers) {
                                    if (!list.contains(customer.getCustomerId())) {
                                        customer.displayCustomerDetails();
                                        Find.add(customer.getCustomerId());
                                    }
                                }
                                if (Find.isEmpty()) {
                                    System.out.println("Not Delete Customer");
                                    System.out.println("-------------------------------------------------");
                                }else{
                                    boolean delete = true;
                                    while (delete) {
                                        System.out.print("Enter Customer ID: ");
                                        int customerID = sc.nextInt();
                                        for (Customer customer : customers) {
                                            if (!list.contains(customer.getCustomerId())) {
                                                if (customer.getCustomerId() == customerID) {
                                                    customers.remove(customer);

                                                    delete = false;
                                                    break;
                                                }
                                            }
                                        }
                                        if (delete) {
                                            System.out.println("Customer ID: " + customerID + " Not Found!");
                                        }
                                    }
                                }
                                try {
                                    saveFile.SaveCustomer(customers);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }break;
                            case 5: {customercheck=false;}break;
                        }
                    }

                }break;
                case 3:{
                    System.out.println("=================================================");
                    System.out.println("\t\t\tCreate Order");
                    System.out.println("=================================================");
                    int orderID = 1;
                    int customerID =1;
                    double totalAmount = 0;
                    String cusName = "";
                    String cusGender = "";
                    String cusPhoneNumber = "";

                    for (Order order : orders) {
                        orderID = order.getOrderId();
                    }
                    orderID += 1;
                    if(customers.isEmpty()) {
                        System.out.println("Not have Customer");
                        System.out.println("Please Register Customer");
                        System.out.println("-------------------------------------------------");
                    }else {
                        if (products.isEmpty()) {
                            System.out.println("Not have Product");
                            System.out.println("Please Add Product");
                            System.out.println("-------------------------------------------------");
                        }else {
                            for (Customer customer : customers) {
                                customer.displayCustomerDetails();
                            }
                            System.out.println("-------------------------------------------------");
                            boolean check = true;
                            while (check) {
                                System.out.print("Enter Customer ID: ");
                                customerID = sc.nextInt();
                                for (Customer customer : customers) {
                                    if (customer.getCustomerId() == customerID) {
                                        cusName = customer.getCustomerName();
                                        cusGender = customer.getCustomerGender();
                                        cusPhoneNumber = customer.getCustomerNumber();
                                        check = false;
                                        break;
                                    }
                                }
                                if (check) {
                                    check = false;
                                }
                            }
                            Customer customer = new Customer(customerID, cusName, cusGender, cusPhoneNumber);
                            ArrayList<Product> productOrder = new ArrayList<Product>();
                            int ProductID = 1;
                            boolean addproduct = true;
                            boolean buymore = true;
                            while (buymore) {
                                while (addproduct) {
                                    System.out.println("=================================================");
                                    System.out.println("\t\t\tProduct List");
                                    System.out.println("=================================================");
                                    System.out.println("ID\t\tName\t\tPrice\t\tQuantity");
                                    for(Product product : products) {
                                        product.PrintProduct();
                                    }
                                    System.out.println("=================================================");
                                    System.out.println("Product Your Order:");
                                    System.out.println("-------------------------------------------------");
                                    for (Product product : productOrder) {
                                        System.out.println("ID:"+product.getProductId()+" Name:" + product.getProductName() + " Qty:" + product.getGetProductQty());
                                    }
                                    System.out.println("=================================================");
                                    System.out.print("Enter Product ID: ");
                                    ProductID = sc.nextInt();
                                    if(!productOrder.isEmpty()) {
                                        boolean found = false;
                                        for (Product product : products){
                                            for (Product productOrders : productOrder) {
                                                if (productOrders.getProductId() == ProductID) {
                                                    System.out.print("Change Qty: ");
                                                    int qty = sc.nextInt();
                                                    while (qty > product.getGetProductQty()) {
                                                        System.out.print("Enter Qty ("+product.getGetProductQty()+"): ");
                                                        qty = sc.nextInt();
                                                    }
                                                    productOrders.setGetProductQty(qty);
                                                    addproduct = false;
                                                    found = true;
                                                    break;
                                                }
                                            }
                                        }

                                        if (!found) {
                                            for (Product productlist : products) {
                                                if (productlist.getProductId() == ProductID) {
                                                    System.out.print("Enter Qty: ");
                                                    int qty = sc.nextInt();
                                                    while (qty > productlist.getGetProductQty()) {
                                                        System.out.print("Enter Qty ("+productlist.getGetProductQty()+"): ");
                                                        qty = sc.nextInt();
                                                    }
                                                    productOrder.add(new Product(productlist.getProductId(),productlist.getProductName(),productlist.getProductPrice(),qty));
                                                    addproduct = false;
                                                    break;
                                                }
                                            }
                                        }

                                    }else {
                                        for (Product product : products) {
                                            if (product.getProductId() == ProductID) {
                                                System.out.print("Enter Qty: ");
                                                int qty = sc.nextInt();
                                                while (qty > product.getGetProductQty()) {
                                                    System.out.print("Enter Qty ("+product.getGetProductQty()+"): ");
                                                    qty = sc.nextInt();
                                                }
                                                productOrder.add(new Product(product.getProductId(),product.getProductName(),product.getProductPrice(),qty));
                                                addproduct = false;
                                                break;
                                            }
                                        }
                                    }
                                    if (addproduct) {
                                        System.out.println("Product ID: " + ProductID + " Not Found!");
                                    }
                                }
                                System.out.println("-------------------------------------------------");
                                System.out.print("Buy More Products(y/n): ");
                                String moreProducts = sc.next().toLowerCase();
                                while (!moreProducts.equals("y") && !moreProducts.equals("n")) {
                                    System.out.print("Choose again(y/n): ");
                                    moreProducts = sc.next().toLowerCase();
                                }
                                if (moreProducts.equals("n")) {
                                    buymore = false;
                                }else {
                                    addproduct = true;
                                }
                            }
                            System.out.println("Payment Order Product.");
                            System.out.println("1.PaymentByBank");
                            System.out.println("2.Cash");
                            System.out.println("3.save Order");
                            System.out.print("Enter Order: ");
                            int payment = sc.nextInt();
                            while (payment < 1 || payment > 3) {
                                System.out.println("Please enter a valid option!");
                                System.out.println("Choose again: ");
                                payment = sc.nextInt();
                            }
                            switch (payment) {
                                case 1:{
                                    String byBank ="";
                                    System.out.println("Payment By Bank");
                                    System.out.println("1.ABA Bank");
                                    System.out.println("2.ACLEDA Bank");
                                    System.out.println("3.WING Bank");
                                    System.out.print("Choose your Bank: ");
                                    int bank = sc.nextInt();
                                    while (bank < 1 || bank > 3) {
                                        System.out.print("Choose again: ");
                                        bank = sc.nextInt();
                                    }
                                    switch (bank) {
                                        case 1:byBank="ABA Bank";break;
                                        case 2:byBank="ACLEDA Bank";break;
                                        case 3:byBank="WING Bank";break;
                                    }
                                    for (Product product : productOrder) {
                                        for (Product productOders : products) {
                                            if (productOders.getProductId() == product.getProductId()) {
                                                product.setGetProductQty(product.getGetProductQty()-productOders.getGetProductQty());
                                                totalAmount += productOders.getGetProductQty()*productOders.getProductPrice();
                                            }
                                        }
                                    }
                                    try {
                                        saveFile.SaveProduct(products);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    System.out.println("Total Payment: " + totalAmount);
                                    System.out.print("Enter TotalPayment: ");
                                    double totalPayment = sc.nextDouble();
                                    while (totalPayment != totalAmount) {
                                        System.out.println("please Enter TotalPayment again: ");
                                        totalPayment = sc.nextDouble();
                                    }
                                    orders.add(new Order(orderID,customer,new ArrayList<>(productOrder),totalAmount,totalPayment,"Payment Already",byBank));
                                    try {
                                        saveFile.SaveOrder(orders);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    System.out.println("Thank you for your order!");

                                }break;
                                case 2:{
                                    for (Product product : products) {
                                        for (Product productOders : productOrder) {
                                            if (productOders.getProductId() == product.getProductId()) {
                                                product.setGetProductQty(product.getGetProductQty()-productOders.getGetProductQty());
                                                totalAmount += productOders.getGetProductQty()*productOders.getProductPrice();
                                            }
                                        }
                                    }
                                    System.out.println("Total Payment: " + totalAmount);
                                    System.out.print("Enter TotalPayment: ");
                                    double totalPayment = sc.nextDouble();
                                    while (totalPayment != totalAmount) {
                                        System.out.println("please Enter TotalPayment again: ");
                                        totalPayment = sc.nextDouble();
                                    }
                                    orders.add(new Order(orderID,customer,new ArrayList<>(productOrder),totalAmount,totalPayment,"Payment Already","Cash"));
                                    try {
                                        saveFile.SaveProduct(products);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    try {
                                        saveFile.SaveOrder(orders);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    System.out.println("Thank you for your order!");
                                }break;
                                case 3:{
                                    System.out.println("Save Order!");
                                    for (Product productOders : productOrder) {
                                        totalAmount += productOders.getGetProductQty()*productOders.getProductPrice();
                                    }
                                    orders.add(new Order(orderID,customer,new ArrayList<>(productOrder),totalAmount,0,"Not Payment","Not"));
                                    try {
                                        saveFile.SaveOrder(orders);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }

                                }break;
                            }
                        }
                    }
                }break;
                case 4: {
                    ArrayList<Order> alradyOrders = new ArrayList<>();
                    ArrayList<Order> notAlreadyOrders = new ArrayList<>();
                    for(Order order : orders) {
                        if (order.getPayment() == order.getTotalPrice()){
                            alradyOrders.add(order);
                        }else if (order.getPayment() < order.getTotalPrice()){
                            notAlreadyOrders.add(order);
                        }
                    }
                    boolean Find = true;
                    while (Find){
                        System.out.println("=================================================");
                        System.out.println("---------------- Payment Already ----------------");
                        System.out.println("=================================================");
                        if (alradyOrders.isEmpty()){
                            System.out.println("Not Have Payment Already");
                        }else {
                            System.out.println("ID\t\tName\t\tGender\t\tPhone-Number");
                            for (Order order : alradyOrders) {
                                order.printOrderNotPayment();

                            }
                        }
                        System.out.println("-------------------------------------------------");
                        System.out.println("=================================================");
                        System.out.println("--------------- Payment Not Ready ---------------");
                        System.out.println("=================================================");
                        if (notAlreadyOrders.isEmpty()){
                            System.out.println("Not Have Payment Not Ready");
                        }else {
                            System.out.println("ID\t\tName\t\tGender\t\tPhone-Number");
                            for (Order order : notAlreadyOrders) {
                                order.printOrderNotPayment();
                            }
                        }
                        System.out.println("---------------------------------------------------");
                        System.out.println("Close or See Order.");
                        System.out.println("1.Find by Id.");
                        System.out.println("2.Close Order.");
                        while (true){
                            System.out.print("Pleas choice Option: ");
                            try{
                                choice = sc.nextInt();
                                if (choice >=1 && choice <=2){
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid number");
                                sc.next();
                            }
                        }
                        switch (choice) {
                            case 1:{
                                boolean findOrderId=true;
                                while (findOrderId){
                                    System.out.print("Enter ID: ");
                                    id = sc.nextInt();
                                    for (Order order : orders) {
                                        if (order.getOrderId() == id) {
                                            order.printOrderPayment();
                                            findOrderId=false;
                                            break;
                                        }
                                    }
                                    if (findOrderId) {
                                        System.out.println("Order Id Not Found");
                                    }
                                }
                            }break;
                            case 2:{
                                Find = false;
                            }break;
                        }
                    }
                    System.out.println("-------------------------------------------------");
                    sc.nextLine();
                }break;
                case 5: {
                   boolean findOrderId=true;
                   while (findOrderId){
                       System.out.println("=================================================");
                       System.out.println("\t\t\tManager Process Order\ud83d\udd04");
                       System.out.println("=================================================");
                       System.out.println("1.Delete Order🗑️");
                       System.out.println("2.Payment Order\ud83d\udd04");
                       System.out.println("3.Close Order");
                       while (true) {
                           System.out.print("Pleas choice Option: ");
                           try{
                               choice = sc.nextInt();
                               if (choice >=1 && choice <=3){
                                   break;
                               }
                           } catch (Exception e) {
                               System.out.println("Invalid number");
                               sc.next();
                           }
                       }
                       switch (choice) {
                           case 1:{
                               System.out.println("=================================================");
                               System.out.println("\t\t\tDelete Process Order");
                               System.out.println("=================================================");
                               ArrayList<Order> notAlreadyOrders = new ArrayList<>();
                               ArrayList<Integer> orderIds = new ArrayList<>();
                               for(Order order : orders) {
                                   if (order.getPayment() < order.getTotalPrice()){
                                       notAlreadyOrders.add(order);
                                   }
                               }
                               if (!notAlreadyOrders.isEmpty()) {
                                   System.out.println("ID\t\tName\t\tGender\tPhone-Number");
                                   for (Order order : notAlreadyOrders) {
                                       order.printOrderNotPayment();
                                       orderIds.add(order.getOrderId());
                                   }
                                   System.out.println("----------------------------------------------");
                                   boolean checkOrderId = true;
                                   boolean Payment = true;
                                   while (checkOrderId){
                                       System.out.print("Enter ID: ");
                                       id = sc.nextInt();
                                       for (Integer orderId : orderIds) {
                                           if (orderId == id) {
                                               checkOrderId=false;
                                               Payment = false;
                                               break;
                                           }
                                       }
                                       if (checkOrderId) {
                                           System.out.println("Order Id Not Found");
                                       }
                                       if (!Payment) {
                                           ArrayList<Order> deleteOrder = new ArrayList<>();
                                           for (Order order : orders) {
                                               if(order.getOrderId() == id){
                                                   deleteOrder.add(order);
                                               }
                                           }
                                           orders.removeAll(deleteOrder);
                                       }
                                   }
                               }else {
                                   System.out.println("\t\t\t\tNot Found");
                                   System.out.println("-------------------------------------------------");
                               }
                               try {
                                   saveFile.SaveOrder(orders);
                               } catch (IOException e) {
                                   throw new RuntimeException(e);
                               }

                           }break;
                           case 2:{
                               System.out.println("=================================================");
                               System.out.println("\t\t\t\tLow Product Order");
                               System.out.println("=================================================");
                               ArrayList<Order> lowProductOrders = new ArrayList<>();
                               for(Order order : orders) {
                                   if(order.getPayment() != order.getTotalPrice()){
                                       for (Product productOder : order.getProducts()) {
                                           for (Product product : products) {
                                               if (productOder.getProductId() == product.getProductId()) {
                                                   if (productOder.getGetProductQty() > product.getGetProductQty()) {
                                                       lowProductOrders.add(order);
                                                   }
                                               }
                                           }
                                       }
                                   }
                               }
                               if (!lowProductOrders.isEmpty()) {
                                   System.out.println("ID\t\tName\t\tGender\t\tPhone-Number");
                                   for (Order order : lowProductOrders) {
                                       order.printOrderNotPayment();
                                   }
                               }else {
                                   System.out.println("\t\tLow Product Order Not Found");
                               }
                               System.out.println("-------------------------------------------------");
                               System.out.println("=================================================");
                               System.out.println("\t\t\t\tPayment Not Ready");
                               System.out.println("=================================================");
                               ArrayList<Order> ProductOrders = new ArrayList<>();
                               ArrayList<Integer> orderIds = new ArrayList<>();
                               for(Order order : orders) {
                                   if(order.getPayment() != order.getTotalPrice()){
                                       for (Product productOder : order.getProducts()) {
                                           for (Product product : products) {
                                               if (productOder.getProductId() == product.getProductId()) {
                                                   if (productOder.getGetProductQty() < product.getGetProductQty()) {
                                                       ProductOrders.add(order);
                                                       orderIds.add(order.getOrderId());
                                                   }
                                               }
                                           }
                                       }
                                   }
                               }
                               if (!ProductOrders.isEmpty()) {
                                   System.out.println("ID\t\tName\t\tGender\t\tPhone-Number");
                                   for (Order order : ProductOrders) {
                                       order.printOrderNotPayment();
                                   }
                               }else {
                                   System.out.println("\t\t\tNot Found");
                               }

                               if(!ProductOrders.isEmpty()){
                                   boolean checkOrderId = true;
                                   boolean Payment = true;
                                   while (checkOrderId){
                                       System.out.println("Enter ID: ");
                                       id = sc.nextInt();
                                       for (Integer orderId : orderIds) {
                                           if (orderId == id) {
                                               checkOrderId=false;
                                               Payment = false;
                                               break;
                                           }
                                       }
                                       if (checkOrderId) {
                                           System.out.println("Order Id Not Found");
                                       }
                                       if (!Payment) {
                                           for (Order order : orders) {
                                               if(order.getOrderId() == id){
                                                   System.out.println("Payment Order Product.");
                                                   System.out.println("1.PaymentByBank");
                                                   System.out.println("2.checkout");
                                                   while (true){
                                                       System.out.print("Pleas choice Option: ");
                                                       try{
                                                           choice = sc.nextInt();
                                                           if (choice >=1 && choice >=2){
                                                               break;
                                                           }
                                                       } catch (Exception e) {
                                                           System.out.println("Invalid number");
                                                           sc.next();
                                                       }
                                                   }
                                                   switch (choice) {
                                                       case 1:{
                                                           String byBank ="";
                                                           System.out.println("Payment By Bank");
                                                           System.out.println("1.ABA Bank");
                                                           System.out.println("2.ACLEDA Bank");
                                                           System.out.println("3.WING Bank");
                                                           System.out.print("Choose your Bank: ");
                                                           int bank = sc.nextInt();
                                                           while (bank < 1 || bank > 3) {
                                                               System.out.print("Choose again: ");
                                                               bank = sc.nextInt();
                                                           }
                                                           switch (bank) {
                                                               case 1:byBank="ABA Bank";break;
                                                               case 2:byBank="ACLEDA Bank";break;
                                                               case 3:byBank="WING Bank";break;
                                                           }
                                                           for (Product product : products) {
                                                               for (Product productOders : order.getProducts()) {
                                                                   if (productOders.getProductId() == product.getProductId()) {
                                                                       product.setGetProductQty(product.getGetProductQty()-productOders.getGetProductQty());
                                                                   }
                                                               }
                                                           }
                                                           try {
                                                               saveFile.SaveProduct(products);
                                                           } catch (IOException e) {
                                                               throw new RuntimeException(e);
                                                           }
                                                           System.out.println("Total Payment: " + order.getTotalPrice());
                                                           System.out.print("Enter TotalPayment: ");
                                                           double totalPayment = sc.nextDouble();
                                                           while (totalPayment != order.getTotalPrice()) {
                                                               System.out.println("please Enter TotalPayment again: ");
                                                               totalPayment = sc.nextDouble();
                                                           }
                                                           order.setStatus("Payment Already");
                                                           order.setPaymentBy(byBank);
                                                           order.setPayment(totalPayment);
                                                           try {
                                                               saveFile.SaveOrder(orders);
                                                           } catch (IOException e) {
                                                               throw new RuntimeException(e);
                                                           }
                                                           System.out.println("Thank you for your order!");

                                                       }break;
                                                       case 2:{
                                                           for (Product product : products) {
                                                               for (Product productOders : order.getProducts()) {
                                                                   if (productOders.getProductId() == product.getProductId()) {
                                                                       product.setGetProductQty(product.getGetProductQty()-productOders.getGetProductQty());
                                                                   }
                                                               }
                                                           }
                                                           System.out.println("Total Payment: " + order.getTotalPrice());
                                                           System.out.print("Enter TotalPayment: ");
                                                           double totalPayment = sc.nextDouble();
                                                           while (totalPayment != order.getTotalPrice()) {
                                                               System.out.println("please Enter TotalPayment again: ");
                                                               totalPayment = sc.nextDouble();
                                                           }
                                                           order.setStatus("Payment Already");
                                                           order.setPaymentBy("Checkout");
                                                           order.setPayment(totalPayment);
                                                           try {
                                                               saveFile.SaveProduct(products);
                                                           } catch (IOException e) {
                                                               throw new RuntimeException(e);
                                                           }
                                                           try {
                                                               saveFile.SaveOrder(orders);
                                                           } catch (IOException e) {
                                                               throw new RuntimeException(e);
                                                           }
                                                           System.out.println("Thank you for your order!");
                                                       }break;
                                                   }
                                               }
                                           }
                                       }
                                   }

                               }
                               System.out.println("-------------------------------------------------");
                           }break;
                           case 3:{
                            findOrderId = false;
                           }break;
                       }
                   }

                }break;
                case 6:{run = false;}break;
            }
        }
        System.out.println("System end Goodbye!\ud83e\udda6");
    }
}
