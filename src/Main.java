//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Customer.Customer;
import Order.Order;
import Product.Product;
import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        OutputFile outputFile = new OutputFile();
        outputFile.start();
        try {
            outputFile.join(); // wait thread finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        ArrayList<Order> orders = outputFile.getOrders();
        ArrayList<Customer> customers = outputFile.getCustomer();
        ArrayList<Product> products = outputFile.getProducts();
        boolean run = true;

        while(run) {
            System.out.println("--------------- Welcome Shop List\ud83d\udcbb\ud83d\udcbb --------------- ");
            System.out.println("1.Manage Product\ud83d\udcdd");
            System.out.println("2.Manage Customer\ud83e\uddd1\u200d\ud83e\uddb1");
            System.out.println("3.Create Order\ud83d\udcb3");
            System.out.println("4.View Order\ud83d\udccb");
            System.out.println("5.Process Order\ud83d\udd04️");
            System.out.println("6.Exit\ud83c\udd91");
            System.out.print("Pleas choice Option: ");
            int choice = sc.nextInt();

            while(choice < 1 || choice > 6) {
                System.out.println("Invalid choice");
                System.out.print("Enter  choice again: ");
                choice = sc.nextInt();
            }

            switch (choice) {
                case 1: {
                    boolean checkproduct = true;
                    while (checkproduct) {
                        System.out.println("--------------- Manage Product -------------- ");
                        System.out.println("1.Add Product");
                        System.out.println("2.View Product");
                        System.out.println("3.Update Product");
                        System.out.println("4.Delete Product");
                        System.out.println("5.Close Product");
                        System.out.print("Pleas choice Option: ");
                        choice = sc.nextInt();
                        while(choice < 1 || choice > 5) {
                            System.out.println("Invalid choice");
                            System.out.print("Enter  choice again: ");
                            choice = sc.nextInt();
                        }
                        switch (choice) {
                            case 1: {
                                System.out.println("--------------- Add Product ---------------");
                                int productID = 1;
                                for (Product product : products) {
                                    productID++;
                                }
                                System.out.print("Product Name: ");
                                String productName = sc.next();
                                System.out.print("Product Price: ");
                                double productPrice = sc.nextDouble();
                                System.out.print("Product Quantity: ");
                                int productQuantity = sc.nextInt();
                                products.add(new Product(productID, productName, productPrice, productQuantity));
                            }break;
                            case 2: {
                                System.out.println("--------------- Product Low in Stock -------------- ");
                                for(Product product : products) {
                                    if(product.getGetProductQty()<10){
                                        product.PrintProduct();
                                    }
                                }
                                System.out.println("--------------- Product in Stock --------------");
                                for(Product product : products) {
                                    if(product.getGetProductQty()>10){
                                        product.PrintProduct();
                                    }
                                }
                            }break;
                            case 3: {
                                System.out.println("--------------- Update Product -------------- ");
                                System.out.println("1.add More Product Qty");
                                System.out.println("2.Update Product All");
                                System.out.print("Choose : ");
                                choice = sc.nextInt();
                                while(choice < 1 || choice > 2) {
                                    System.out.print("Choose again: ");
                                    choice = sc.nextInt();
                                }
                                switch (choice) {
                                    case 1: {
                                        System.out.println("--------------- Add More Product Qty ---------------");
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
                                                    product.setGetProductQty(product.getGetProductQty()+productQty);
                                                    checkQty = false;
                                                    break;
                                                }
                                            }
                                            if (checkQty) {
                                                System.out.println("Invalid Product ID");
                                            }
                                        }
                                    }break;
                                    case 2: {
                                        for (Product product : products) {
                                            product.PrintProduct();
                                        }
                                        boolean checkupdate = false;
                                        while (checkupdate) {
                                            System.out.print("Enter Product ID: ");
                                            int productID = sc.nextInt();
                                            for (Product product : products) {
                                                if (product.getProductId() == productID) {
                                                    System.out.print("Product Name: ");
                                                    String productName = sc.next();
                                                    System.out.print("Product Price: ");
                                                    double productPrice = sc.nextDouble();
                                                    System.out.print("Product Quantity: ");
                                                    int productQuantity = sc.nextInt();
                                                    product.setProductName(productName);
                                                    product.setProductPrice(productPrice);
                                                    product.setGetProductQty(productQuantity);
                                                    checkupdate = false;
                                                    break;
                                                }
                                            }
                                            System.out.println("Product ID: " + productID+ " Not Found!");
                                        }
                                    }break;
                                }
                            }break;
                            case 4: {
                                System.out.println("--------------- Delete Product -------------- ");
                                ArrayList<Integer> productID = new ArrayList<>();
                                for (Order order : orders) {
                                    for (Product product :order.getProducts()) {
                                        productID.add(product.getProductId());
                                    }
                                }
                                ArrayList<Integer> productIDs = new ArrayList<>(new LinkedHashSet<>(productID));
                                for (Product product : products) {
                                    if(!productIDs.contains(product.getProductId())) {
                                        product.PrintProduct();
                                    }
                                }
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
                                    System.out.println("Product ID: " + deleteProductID + " Not Found!");
                                }
                            }break;
                            case 5: {checkproduct=false;}break;
                        }
                    }
                }break;
                case 2: {
                    boolean customercheck = true;
                    while(customercheck) {
                        System.out.println("--------------- Manage Customer -------------- ");
                        System.out.println("1.view Customer");
                        System.out.println("2.Register Customer");
                        System.out.println("3.Update Customer");
                        System.out.println("4.Delete Customer");
                        System.out.println("5.Close Customer");
                        System.out.print("Choose : ");
                        choice = sc.nextInt();
                        while(choice < 1 || choice >5) {
                            System.out.print("Choose again: ");
                            choice = sc.nextInt();
                        }
                        switch (choice) {
                            case 1: {
                                System.out.println("--------------- Customer -------------- ");
                                for (Customer customer : customers) {
                                    customer.displayCustomerDetails();
                                }
                            }break;
                            case 2: {
                                System.out.println("-------------- Register Customer ---------------");
                                int customerID = 1;

                                for (Customer customer : customers) {
                                    ++customerID;
                                }

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
                            }break;
                            case 3: {
                                System.out.println("--------------- Update Customer -------------- ");
                                boolean checkupdateID = true;
                                while (checkupdateID) {
                                    System.out.print("Enter Customer ID: ");
                                    int customerID = sc.nextInt();
                                    for (Customer customer : customers) {
                                        if (customer.getCustomerId() == customerID) {
                                            System.out.print("Customer Name: ");
                                            String customerName = sc.next();
                                            customer.setCustomerName(customerName);
                                            System.out.print("Enter Customer Gender(Male/Female): ");
                                            String customerGender = sc.next();
                                            while ( !customerGender.equals("Male") && !customerGender.equals("Female")) {
                                                System.out.print("Enter Customer Gender Again: ");
                                                customerGender = sc.next();
                                            }
                                            customer.setCustomerGender(customerGender);
                                            System.out.print("Customer PhoneNumber: ");
                                            String customerPhoneNumber = sc.next();
                                            customer.setCustomerNumber(customerPhoneNumber);
                                            checkupdateID = false;
                                            break;

                                        }
                                        for (Order order : orders) {
                                            if(order.getCustomer().getCustomerId() == customerID) {
                                                order.setCustomer(customer);
                                            }
                                        }
                                    }
                                    if (checkupdateID) {
                                        System.out.println("Customer ID: " + customerID + " Not Found!");
                                    }
                                }
                            }break;
                            case 4:{
                                ArrayList<Integer> CustomerIDs = new ArrayList<>();
                                for (Order order : orders) {
                                    CustomerIDs.add(order.getCustomer().getCustomerId());
                                }
                                ArrayList<Integer> list = new ArrayList<>(new LinkedHashSet<>(CustomerIDs));
                                System.out.println("--------------- Delete Customer -------------- ");
                                for (Customer customer : customers) {
                                    if (!list.contains(customer.getCustomerId())) {
                                        customer.displayCustomerDetails();
                                    }
                                }
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
                            }break;
                            case 5: {customercheck=false;}break;
                        }
                    }

                }break;
                case 3:{
                    System.out.println("--------------- Customer 🧑‍🦱 ---------------");
                    String customerName="" ;
                    String customerGender="" ;
                    String customerNumber="" ;
                    for (Customer customer : customers) {
                        customer.displayCustomerDetails();
                    }
                    System.out.println("-------------------------------------------");
                    boolean check = true;
                    int cusID = 0;
                    while (check) {
                        System.out.print("Enter Customer ID: ");
                         cusID= sc.nextInt();
                        for (Customer customer : customers) {

                            if (cusID == customer.getCustomerId()) {
                                customerName = customer.getCustomerName();
                                customerGender = customer.getCustomerGender();
                                customerNumber = customer.getCustomerNumber();
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            System.out.println("Customer ID: " + cusID + "Mot Found");
                        }
                    }
                    Customer customer = new Customer(cusID,customerName,customerGender,customerNumber);
                    System.out.println("-------------------------------------------");
                    System.out.println("Welcome to "+ customerName +" Order Product!");
                    System.out.println("--------------- Product ---------------");
                    boolean buy = true ;
                    ArrayList<Product> productOrder = new ArrayList<Product>();
                    double totalPrice = 0 ;
                    while (buy) {
                        for (Product product : products) {
                            product.PrintProduct();
                        }
                        System.out.println("-------------------------------------------");
                        System.out.print("Your Order Product: ");
                        for (Product product : productOrder) {
                            System.out.println(product.getProductId()+":"+product.getGetProductQty()+"|");
                        }
                        System.out.println("-------------------------------------------");
                        boolean checkProduct = true;
                        while (checkProduct){
                            System.out.print("Enter Product ID: ");
                            int productID = sc.nextInt();
                            for (Product product : products) {
                                if(product.getProductId() == productID){
                                    System.out.print("Enter Qty Again(1-"+product.getGetProductQty()+")):");
                                    int qty = sc.nextInt();
                                    while (qty<0 || qty >= product.getGetProductQty()){
                                        System.out.print("Enter Qty Again(1-"+product.getGetProductQty()+")):");
                                        qty = sc.nextInt();
                                    }

                                    product.setGetProductQty(product.getGetProductQty()-qty);
                                    productOrder.add(new Product(productID,product.getProductName(),product.getProductPrice(),qty));
                                    totalPrice += product.getProductPrice()*qty;
                                    checkProduct = false;
                                    break;
                                }
                            }
                            if(checkProduct){
                                System.out.println("Product ID: " + productID + "Not Found");
                            }
                        }
                        System.out.print("Buy More Product !(y/n): ");
                        String input = sc.next().toLowerCase();
                        while (!input.equals("y") && !input.equals("n")) {
                            System.out.print("Enter again (y/n): ");
                            input = sc.next().toLowerCase();
                        }
                        if (input.equals("y")) {
                            buy = true ;
                        }else if (input.equals("n")) {
                            buy = false ;
                        }
                    }
                    System.out.println("-------------------------------------------");
                    System.out.print("Payment now or not(y/n)");
                    String inp = sc.next().toLowerCase();
                    while (!inp.equals("y") && !inp.equals("n")) {
                        System.out.print("Enter again (y/n): ");
                        inp = sc.next().toLowerCase();
                    }
                    if (inp.equals("y")) {
                        System.out.println("PaymentBy");
                        System.out.println("1.ABA Bank");
                        System.out.println("2.Acleda Bank");
                        System.out.println("3.Mobile Bank");
                        System.out.println("4.Close");
                        System.out.print("Choose Bank: ");
                        int PaymentPayment = sc.nextInt();
                        while (PaymentPayment<0 || PaymentPayment>5){}
                        switch (PaymentPayment){
                            case 1:{
                                String Bank = "ABA Bank";
                                String Status="Payment Successful!🎊🎉";
                                System.out.println("Your TotalPrice: "+totalPrice);
                                System.out.print("Enter TotalPayment: ");
                                double totalPayment = sc.nextDouble();
                                while (totalPayment != totalPrice){
                                    System.out.print("Enter Total Payment again: ");
                                    totalPayment = sc.nextDouble();
                                }
                                int id=1;
                                for(Order order : orders){
                                    id+=1;
                                }
                                orders.add(new Order(id,customer,productOrder,totalPrice,totalPayment,Status,Bank));

                            }break;
                            case 2:{
                                String Bank = "ABA Bank";
                                String Status="Acleda Successful!🎊🎉";
                                System.out.println("Your TotalPrice: "+totalPrice);
                                System.out.print("Enter TotalPayment: ");
                                double totalPayment = sc.nextDouble();
                                while (totalPayment != totalPrice){
                                    System.out.print("Enter Total Payment again: ");
                                    totalPayment = sc.nextDouble();
                                }
                                int id=1;
                                for(Order order : orders){
                                    id+=1;
                                }
                                orders.add(new Order(id,customer,productOrder,totalPrice,totalPayment,Status,Bank));
                            }break;
                            case 3:{
                                String Bank = "Mobile Bank";
                                String Status="Payment Successful!🎊🎉";
                                System.out.println("Your TotalPrice: "+totalPrice);
                                System.out.print("Enter TotalPayment: ");
                                double totalPayment = sc.nextDouble();
                                while (totalPayment != totalPrice){
                                    System.out.print("Enter Total Payment again: ");
                                    totalPayment = sc.nextDouble();
                                }
                                int id=1;
                                for(Order order : orders){
                                    id+=1;
                                }
                                orders.add(new Order(id,customer,productOrder,totalPrice,totalPayment,Status,Bank));
                            }break;
                            case 4:{
                                int id=1;
                                for(Order order : orders){
                                    id+=1;
                                }
                                orders.add(new Order(id,customer,productOrder,totalPrice,0,"Order Already!✍️",""));
                            }break;
                        }
                    }else {
                        int id=1;
                        for(Order order : orders){
                            id+=1;
                        }
                        orders.add(new Order(id,customer,productOrder,totalPrice,0,"Order Already!✍️","Not Payment"));
                    }
                }break;
                case 4: {
                    System.out.println("--------------- Payment Already ---------------");
                    for (Order order : orders) {
                        if (order.getPayment() == order.getTotalPrice()) {
                            order.printOrderPayment();
                        }
                    }

                    System.out.println("--------------- Payment Not Ready ---------------");

                    for (Order order : orders) {
                        if (order.getPayment() < order.getTotalPrice()) {
                            order.printOrderPayment();
                        }
                    }
                }break ;
                case 5: {
                    System.out.println("--------------- Payment Not Ready ---------------");

                    for (Order order : orders) {
                        if (order.getPayment() < order.getTotalPrice()) {
                            order.printOrderPayment();
                        }
                    }

                    System.out.println("--------------------------------------------------");
                    boolean checkorder = true;

                    while (checkorder) {
                        System.out.print("Choose OrderID Payment: ");
                        int orderid = sc.nextInt();

                        for (Order order : orders) {
                            if (order.getPayment() == (double) orderid) {
                                System.out.println("PaymentBy");
                                System.out.println("1.ABA Bank");
                                System.out.println("2.Acleda Bank");
                                System.out.println("3.Mobile Bank");
                                System.out.println("4.Close");
                                System.out.print("Choose Bank: ");
                                int PaymentPayment = sc.nextInt();

                                do {
                                    while (PaymentPayment < 0) {
                                    }
                                } while (PaymentPayment > 5);

                                switch (PaymentPayment) {
                                    case 1: {
                                        String Bank = "ABA Bank";
                                        String Status = "Payment Successful!\ud83c\udf8a\ud83c\udf89";
                                        System.out.println("Your TotalPrice: " + order.getTotalPrice());
                                        System.out.print("Enter TotalPayment: ");

                                        double totalPayment;
                                        for (totalPayment = sc.nextDouble(); totalPayment != order.getTotalPrice(); totalPayment = sc.nextDouble()) {
                                            System.out.print("Enter Total Payment again: ");
                                        }

                                        order.setPayment(totalPayment);
                                        order.setPaymentBy(Bank);
                                        order.setStatus(Status);
                                    }
                                    break;
                                    case 2: {
                                        String Bank = "ABA Bank";
                                        String Status = "Acleda Successful!\ud83c\udf8a\ud83c\udf89";
                                        System.out.println("Your TotalPrice: " + order.getTotalPrice());
                                        System.out.print("Enter TotalPayment: ");

                                        double totalPayment;
                                        for (totalPayment = sc.nextDouble(); totalPayment != order.getTotalPrice(); totalPayment = sc.nextDouble()) {
                                            System.out.print("Enter Total Payment again: ");
                                        }

                                        order.setPayment(totalPayment);
                                        order.setPaymentBy(Bank);
                                        order.setStatus(Status);
                                    }
                                    break;
                                    case 3: {
                                        String Bank = "Mobile Bank";
                                        String Status = "Payment Successful!\ud83c\udf8a\ud83c\udf89";
                                        System.out.println("Your TotalPrice: " + order.getTotalPrice());
                                        System.out.print("Enter TotalPayment: ");

                                        double totalPayment;
                                        for (totalPayment = sc.nextDouble(); totalPayment != order.getTotalPrice(); totalPayment = sc.nextDouble()) {
                                            System.out.print("Enter Total Payment again: ");
                                        }

                                        order.setPayment(totalPayment);
                                        order.setPaymentBy(Bank);
                                        order.setStatus(Status);
                                    }
                                    break;
                                    case 4:
                                        System.out.println("Close!");
                                }

                                checkorder = false;
                                break;
                            }
                        }

                        if (checkorder) {
                            System.out.println("Order ID: " + orderid + "Not Found!");
                        }
                    }
                }break;
                case 6:{run = false;}break;
            }
        }

        SaveFile saveFile = new SaveFile(orders, products, customers);
        saveFile.start();
        System.out.println("System end Goodbye!\ud83e\udda6");
    }
}
