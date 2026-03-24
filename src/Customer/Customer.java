//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Customer;

import java.io.PrintStream;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerGender;
    private String customerNumber;

    public Customer(int customerId, String customerName, String customerGender, String customerNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerGender = customerGender;
        this.customerNumber = customerNumber;
    }

    public String getCustomerNumber() {
        return this.customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerGender() {
        return this.customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void displayCustomerDetails() {
        System.out.println("Customer ID: " + getCustomerId() + "\tCustomer Name: " + getCustomerName() + "\tCustomer Gender: " +getCustomerGender());
    }
}
