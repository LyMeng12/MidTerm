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
                        System.out.println("1.View Product");
                        System.out.println("2.Add Product");
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
                                System.out.println("--------------- Product Low in Stock -------------- ");
                                boolean checkProduct = false;
                                for(Product product : products) {
                                    if(product.getGetProductQty()<10){
                                        checkProduct = true;
                                        product.PrintProduct();

                                    }
                                }
                                if (!checkProduct) {
                                    System.out.println("Not Product Have");
                                }
                                System.out.println("--------------- Product in Stock --------------");
                                if(products.isEmpty()) {
                                    System.out.println("Not Product Have");
                                }else {
                                    for(Product product : products) {
                                        if(product.getGetProductQty()>10){
                                            product.PrintProduct();
                                        }
                                    }
                                }
                            }break;
                            case 2: {
                                System.out.println("--------------- Add Product ---------------");
                                int productID = 0;
                                for (Product product : products) {
                                    productID=product.getProductId();
                                }
                                productID+=1;
                                System.out.print("Product Name: ");
                                String productName = sc.next();
                                System.out.print("Product Price: ");
                                double productPrice = sc.nextDouble();
                                System.out.print("Product Quantity: ");
                                int productQuantity = sc.nextInt();
                                products.add(new Product(productID, productName, productPrice, productQuantity));
                                try {
                                    saveFile.SaveProduct(products);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }break;
                            case 3: {
                                System.out.println("--------------- Update Product -------------- ");
                                System.out.println("1.Add More Product Qty");
                                System.out.println("2.Update Product (Name and Price)");
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
                                        try {
                                            saveFile.SaveProduct(products);
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }break;
//                                    update more
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
                                                    product.setProductName(productName);
                                                    product.setProductPrice(productPrice);
                                                    for(Order order : orders) {
                                                        double totalPrice=0;
                                                        boolean checkQty = false;
                                                        for(Product product1 : order.getProducts()) {
                                                            product1.setProductName(productName);
                                                            product1.setProductPrice(productPrice);
                                                            totalPrice+=product1.getProductPrice()*product1.getGetProductQty();
                                                            checkQty=true;
                                                            break;
                                                        }
                                                        if(checkQty) {
                                                            order.setTotalPrice(totalPrice);
                                                        }
                                                    }
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
                                    if (delete) {
                                        System.out.println("Product ID: " + deleteProductID + " Not Found!");
                                    }
                                }
                                try {
                                    saveFile.SaveProduct(products);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
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
                                if(customers.isEmpty()) {
                                    System.out.println("Not View Customer");
                                }else {
                                    for (Customer customer : customers) {
                                        customer.displayCustomerDetails();
                                    }
                                }
                            }break;
                            case 2: {
                                System.out.println("-------------- Register Customer ---------------");
                                int customerID = 0;

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
                                System.out.println("--------------- Update Customer -------------- ");
                                boolean checkupdateID = true;
                                String customerName="";
                                String customerGender="";
                                String customerPhoneNumber="";
                                while (checkupdateID) {
                                    System.out.print("Enter Customer ID: ");
                                    int customerID = sc.nextInt();
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
                                        for (Order order : orders) {
                                            if(order.getCustomer().getCustomerId() == customerID) {
                                                order.getCustomer().setCustomerName(customerName);
                                                order.getCustomer().setCustomerGender(customerGender);
                                                order.getCustomer().setCustomerNumber(customerPhoneNumber);
                                                break;
                                            }
                                        }
                                    }
                                    if (checkupdateID) {
                                        System.out.println("Customer ID: " + customerID + " Not Found!");
                                    }
                                }
                                try {
                                    saveFile.SaveCustomer(customers);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
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
                    System.out.println("--------------- Create Order -------------- ");
                    int orderID = 1;
                    int customerID =1;
                    double totalAmount = 0;
                    String cusName = "";
                    String cusGender = "";
                    String cusPhoneNumber = "";
                    ArrayList<Product> productOrder = new ArrayList<>();
                    for (Order order : orders) {
                        orderID++;
                    }
                    if(customers.isEmpty()) {
                        System.out.println("Not have Customer");
                        System.out.println("Please Register Customer");
                    }else {
                        if (products.isEmpty()) {
                            System.out.println("Not have Product");
                            System.out.println("Please Add Product");
                        }else {
                            for (Customer customer : customers) {
                                customer.displayCustomerDetails();
                            }
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
                            int ProductID = 1;
                            boolean addproduct = true;
                            boolean buymore = true;
                            while (buymore) {
                                while (addproduct) {
                                    for(Product product : products) {
                                        product.PrintProduct();
                                    }
                                    System.out.println("Product Your Order:");
                                    for (Product product : productOrder) {
                                        System.out.println("ID:"+product.getProductId()+"Name:" + product.getProductName() + " Qty:" + product.getGetProductQty());
                                    }
                                    System.out.print("Enter Product ID: ");
                                    ProductID = sc.nextInt();
                                    if(!productOrder.isEmpty()) {
                                        boolean found = false;
                                        for (Product product : productOrder) {
                                            if (product.getProductId() == ProductID) {
                                                System.out.print("Change Qty: ");
                                                int qty = sc.nextInt();
                                                product.setGetProductQty(qty);
                                                addproduct = false;
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (!found) {
                                            for (Product productlist : products) {
                                                if (productlist.getProductId() == ProductID) {
                                                    System.out.print("Enter Qty: ");
                                                    int qty = sc.nextInt();
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
                                System.out.println("---------------------------------------------- ");
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
                            System.out.println("2.checkout");
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
                                    for (Product product : products) {
                                        for (Product productOders : productOrder) {
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
                                    orders.add(new Order(orderID,customer,productOrder,totalAmount,totalPayment,"Payment Already",byBank));
                                    productOrder.clear();
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
                                    orders.add(new Order(orderID,customer,productOrder,totalAmount,totalPayment,"Payment Already","checkout"));
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
                                    orders.add(new Order(orderID,customer,productOrder,totalAmount,0,"Not Payment","Not"));
                                    try {
                                        saveFile.SaveOrder(orders);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }

                                }break;

                            }

                        }

                    }
                    productOrder.clear();
                }break;
                case 4: {
                    System.out.println("--------------- Payment Already ---------------");
                    for (Order order : orders) {
                        if (order.getPayment() == order.getTotalPrice()) {
                            order.printOrderNotPayment();
                        }
                    }
                    System.out.println("--------------- Payment Not Ready ---------------");

                    for (Order order : orders) {
                        if (order.getPayment() < order.getTotalPrice()) {
                            order.printOrderNotPayment();
                        }
                    }
                }break ;
                case 5: {
                    System.out.println("--------------- Payment Not Ready ---------------");
                    ArrayList<Order> orders1=new ArrayList<>();
                    for (Order order : orders) {
                        if (order.getPayment() != order.getTotalPrice()) {
                            order.printOrderNotPayment();
                            orders1.add(order);
                        }
                    }
                    if (!orders1.isEmpty()){
                        System.out.println("--------------------------------------------------");
                        boolean checkorder = true;

                        int orderid =0;
                        while (checkorder) {
                            System.out.print("Choose OrderID Payment: ");
                            orderid = sc.nextInt();
                            for (Order order : orders1) {
                                if (order.getOrderId() == orderid) {
                                    checkorder = false;
                                    break;
                                }
                            }
                            if (checkorder) {
                                System.out.println("Order ID: " + orderid + "Not Found!");
                            }
                        }
                        for (Order order : orders) {
                            if (order.getOrderId() == orderid) {
                                double totalAmount=1;
                                ArrayList<Product> productOrder = order.getProducts();
                                System.out.println("Payment Order Product.");
                                System.out.println("1.PaymentByBank");
                                System.out.println("2.checkout");
                                System.out.print("Enter Payment: ");
                                int payment = sc.nextInt();
                                while (payment < 1 || payment > 2) {
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
                                        for (Product product : products) {
                                            for (Product productOders : productOrder) {
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
                                        try {
                                            saveFile.SaveProduct(products);
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                        order.setPaymentBy(byBank);
                                        order.setPayment(totalPayment);
                                        order.setStatus("Payment Already");
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
                                        order.setPaymentBy("Checkout");
                                        order.setPayment(totalPayment);
                                        order.setStatus("Payment Already");
                                        try {
                                            saveFile.SaveProduct(products);
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                        System.out.println("Thank you for your order!");
                                    }break;
                                }
                                break;
                            }
                        }
                        try {
                            saveFile.SaveOrder(orders);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("--------------- Payment Not Have Order ----------------");
                }break;
                case 6:{run = false;}break;
            }
        }
        System.out.println("System end Goodbye!\ud83e\udda6");
    }
}
