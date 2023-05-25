
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author almahedengren
 */
public class Customer {

    private String customerID;
    private String firstName;
    private String lastName;
    private int phone; //kolla så inget blir fel
    private String email;
    private double hatSize; // -"-
    private String address;
    private String postalNr;
    private String city;
    private InfDB idb;

    public static ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> allCustomers = new ArrayList<>();

        try {
            InfDB idb = HattmakarnaStudio.getDatabase();
            ArrayList<HashMap<String, String>> allRows = idb.fetchRows("select * from customer");
            
            
            for (HashMap<String, String> row : allRows) {
                String firstName = "";
                String lastName = "";

                for (String key : row.keySet()) {
                    if (key.equals("FirstName")) {
                        firstName = row.get(key);
                    }

                    if (key.equals( "LastName")) {
                        lastName = row.get(key);
                    }
                }

                Customer aCustomer = new Customer(firstName, lastName);
                allCustomers.add(aCustomer);
            }

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        return allCustomers;
    }

    public Customer (){
        
    }
    
    
    
    
    public Customer(String firstName, String lastName) {
        this.idb = HattmakarnaStudio.getDatabase();
        getOldCustomer(firstName, lastName);
    }
    

    public Customer(String firstName, String lastName, int phone, String email, double hatSize, String address, String postalNr, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.hatSize = hatSize;
        this.address = address;
        this.postalNr = postalNr;
        this.city = city;

        regNewCustomer(firstName, lastName, phone, email, hatSize, address, postalNr, city);
    }

    private void regNewCustomer(String firstName, String lastName, int phone, String email, double hatSize, String address, String postalNr, String city) {
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hattdb", "hattdb", "hattkey");
            PreparedStatement stmt = conn.prepareStatement("insert into customer (firstName, lastName, phone, email, hatSize, address, postalNr, city) values (?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setInt(3, phone);
            stmt.setString(4, email);
            stmt.setDouble(5, hatSize);
            stmt.setString(6, address);
            stmt.setString(7, postalNr);
            stmt.setString(8, city);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "En ny kund har registrerats!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Något gick fel. Har du fyllt i all information?");
        }
    }

    private void getOldCustomer(String firstName, String lastName) {

        idb = HattmakarnaStudio.getDatabase();

        try {
            HashMap<String, String> customerInfo = idb.fetchRow("select * from customer where FirstName = '" + firstName + "'" + "and LastName = '" + lastName + "'");

            for (String key : customerInfo.keySet()) {

                switch (key) {
                    case "CustomerID":
                        this.customerID = customerInfo.get(key);
                        break;
                    case "Phone":
                        this.phone = Integer.parseInt(customerInfo.get(key));
                        break;
                    case "Email":
                        this.email = customerInfo.get(key);
                        break;
                    case "HatSize":
                        this.hatSize = Double.parseDouble(customerInfo.get(key));
                        break;
                    case "Address":
                        this.address = (customerInfo.get(key));
                        break;
                    case "PostalNr":
                        this.postalNr = (customerInfo.get(key));
                        break;
                    case "City":
                        this.city = (customerInfo.get(key));
                        break;
                    case "FirstName" :
                        this.firstName = customerInfo.get(key);
                        break;
                    case "LastName" :
                        this.lastName = customerInfo.get(key);

                }
            }

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public String getCustomerID()
    {
        return this.customerID;
    }

    public String getCustomerID(String Phone) throws InfException  {
          String q = "SELECT CustomerID FROM Customer WHERE Phone = '"+ Phone + "'";
          String a = idb.fetchSingle(q);
        
        return a;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Integer getPhone() {
        return phone;
    }

    public Double getHatSize() {
        return hatSize;
    }

    public String toString() {
        return firstName + ", " + lastName + " epost: " + email;
    }

    public void setName(String aTextField) {

    }

    public void setEmail(String aTextField) {

    }

    public void setAddress(String aTextField) {

    }

    public void setPhone(Integer aTextField) {

    }

    public void setSize(Double aTextField) {

    }
}
