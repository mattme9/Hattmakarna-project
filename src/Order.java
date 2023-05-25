/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
/**
 *
 * @author almahedengren
 */
public class Order {
    
    private String orderID;
    private String customerID;
    private String shipmentAddress;
    private String postalNr;
    private String city;    
    private String orderDate; 
    private boolean isFinished; 
    private double totalPrice;
    private String isExpress; 
    private String note;
    private Boolean materialIsOrdered;
    private ArrayList<Hat> basicSpecialHatList;
    private ArrayList<String> customHatList;
    private ArrayList<Hat> finishedBasicSpecial;
    private ArrayList<String> finishedCustom;
    private InfDB idb;
    
    //Konstruktor för att registrera en order och instansiera ett Orderobjekt
    //Samtliga värden i parametern finns med i PlaceOrder-klassen och instansieras där
    public Order(String customerID, String shipmentAdress, String PostalNr, String city, String orderDate, double totalPrice, String note, 
            boolean isExpress, ArrayList<Hat> basicSpecialHats, ArrayList<String> customHats){
        
     
        this.customerID = customerID;
        this.shipmentAddress = shipmentAdress;
        this.postalNr = PostalNr;
        this.city = city;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.note = note;
        
        if (isExpress) {
            this.isExpress = "1";          
        }
        else{ 
            this.isExpress = "0";
        }

        this.basicSpecialHatList = basicSpecialHats;
        this.customHatList = customHats;
        
        idb = HattmakarnaStudio.getDatabase();
        
        addOrderToDB();
        addBasicSpecialHatsToDB();
        addCustomHatsToDB();
    }
    
    //Konstruktor för att hämta en specifik order
    public Order(String orderID)
    {
        this.orderID = orderID;
        
        idb = HattmakarnaStudio.getDatabase();

        try {
            HashMap<String, String> orderInfo = idb.fetchRow("select * from orders where OrderID = " + orderID);
             
            for(String key : orderInfo.keySet()){
                                        
                System.out.print(orderInfo.get(key) + " ");
                
                switch(key){
                    case "ShipmentAddress":
                        this.shipmentAddress = orderInfo.get(key);
                        break;
                    
                    case "Price":
                        this.totalPrice = Integer.parseInt(orderInfo.get(key));
                        break;
                    
                    case "Note":
                        this.note = orderInfo.get(key);
                        break;
                    
                    case "isFinished":
                        if (orderInfo.get(key) == "0") {
                            this.isFinished = false;
                        } else {
                            this.isFinished = true;
                        }
                        break;
                    
                    case "Orderdate":
                        this.orderDate = orderInfo.get(key);
                        break;
                    
                    case "isExpress": // Kontrollerar om sant eller falskt
                        if (orderInfo.get(key) == "0") {
                            this.isExpress = "0";
                        } else {
                            this.isExpress = "1";
                        }
                        break;
                        
                    case "MaterialOrdered":
                        if (orderInfo.get(key) == "0") {
                            this.materialIsOrdered = false;
                        } else {
                            this.materialIsOrdered = true;
                        }
                        break;
                        
                    case "Customer":
                        this.customerID = orderInfo.get(key);
                        break;                   
                }               
            }

            getBasicSpecialHats(this.orderID); 
            getFinishedBasicSpecialHats(this.orderID);
            getCustomHats(this.orderID); 
            getFinishedCustomHats(this.orderID); 
            
        } catch (Exception e) {
            System.out.print(e.getMessage()); 
        }
    }
    
    public Order(){
    this.idb = HattmakarnaStudio.getDatabase();
    }
    
       
    public static ArrayList<Order> getAllOrders() {
        
        ArrayList<Order> allOrders = new ArrayList<>();

        try {
            InfDB idb = HattmakarnaStudio.getDatabase();
            ArrayList<HashMap<String, String>> allRows = idb.fetchRows("select * from orders");

            for (HashMap<String, String> row : allRows) {
                String orderID = "";
                
                for (String key : row.keySet()) {
                    if (key.equals("OrderID")) {
                        orderID = row.get(key);
                    }

                    Order anOrder = new Order(orderID);
                    allOrders.add(anOrder);
                    System.out.println(allOrders.size());
                    return allOrders;
                }
            }
            
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        return allOrders;
    }
    
    private void getBasicSpecialHats(String orderID)
    {
        
        basicSpecialHatList = new ArrayList<>();

        try {

            ArrayList<HashMap<String, String>> allHats = new ArrayList<>();            
            allHats = idb.fetchRows("select * from hatinorder where AnOrder = " + orderID);
            
            System.out.print(allHats.size() + "");
            
            if (allHats.isEmpty()) {
            } 
            
            else {

                for (var rows : allHats) {

                    String hatID = "";
                    int amount = 0;

                    for (String key : rows.keySet()) {
                        
                        switch (key) {
                            case "Hat":
                                hatID = rows.get(key);
                                break;
                            case "Amount":
                                amount = Integer.parseInt(rows.get(key));
                                break;
                            case "Employee" :
                                break;
                            case "AnOrder" :
                                break;    
                        }
                    }

                    String hatName = idb.fetchSingle("select HatName from Hat where HatID = " + hatID);
                    Hat aHat = new Hat(hatName);
                    
                    System.out.print(aHat.getProductName());

                    for (int i = 0; i < amount; i++) {

                        basicSpecialHatList.add(aHat);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
        }
        
    }
    
    private void getFinishedBasicSpecialHats(String orderID)
    {
        
         finishedBasicSpecial = new ArrayList<>();
         
        try {
            ArrayList<HashMap<String, String>> allHats = idb.fetchRows("select * from finishedhatinorder where AnOrder = " + orderID);
             
            if (allHats.isEmpty()) {
            } 
            
            else {

            for (var rows : allHats) {

                String hatID = "";
                int amount = 0;

                for (String key : rows.keySet()) {
                  
                    switch (key) {
                        case "Hat":
                            hatID = rows.get(key);
                            break;
                        case "Amount":
                            amount = Integer.parseInt(rows.get(key));
                            break;
                    }
                }

                  String hatName = idb.fetchSingle("select HatName from Hat where HatID = " + hatID);
                  Hat aHat = new Hat(hatName);
                  
                for (int i = 0; i < amount; i++) {
                    
                    finishedBasicSpecial.add(aHat);                    
                }
            }
             }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    private void getCustomHats(String orderID)
    {
         customHatList = new ArrayList<>();
        
        try {
            ArrayList<HashMap<String, String>> allHats = idb.fetchRows("select * from customhatinorder where AnOrder = " + orderID);

             
            if (allHats.isEmpty()) {
            } 
            
            else {
            for (var rows : allHats) {

                String hatID = "";
                int amount = 0;

                for (String key : rows.keySet()) {
                
                    switch (key) {
                        case "CustomHat":
                            hatID = rows.get(key);
                            break;
                        case "Amount":
                            amount = Integer.parseInt(rows.get(key));
                            break;
                    }
                }

                for (int i = 0; i < amount; i++) {
                    
                    customHatList.add(hatID);                    
                }
            }
             }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    private void getFinishedCustomHats(String orderID)
    {
         finishedCustom = new ArrayList<>();
        
        try {
            ArrayList<HashMap<String, String>> allHats = idb.fetchRows("select * from finishedcustomhatinorder where AnOrder = " + orderID);

             
            if (allHats.isEmpty()) {
            } 
            
            else {
            for (var rows : allHats) {

                String hatID = "";
                int amount = 0;

                for (String key : rows.keySet()) {
                    

                    switch (key) {
                        case "Hat":
                            hatID = rows.get(key);
                            break;
                        case "Amount":
                            amount = Integer.parseInt(rows.get(key));
                            break;
                    }
                }

                for (int i = 0; i < amount; i++) {
                    
                    finishedCustom.add(hatID);                    
                }
            }
             }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public String getOrderID()
    {
        return orderID;
    }
   
    public String getCustomerID()
    {
        return customerID;
    }
    
    public String getOrderDate(String orderID) throws InfException
    {
        String query = "Select orderdate from orders where orderid = '" + orderID + "'";
        String a = idb.fetchSingle(query);
        return a; 
    }
    
    public boolean isFinished()
    {
        return isFinished;
    }
    
    public String getPrice(String orderID) throws InfException
    {
        String price = "Select price from Orders where orderId = '" + orderID + "'";
        String price1 = idb.fetchSingle(price);
        return price1; 
    }
       
    public Boolean getExpress()
    {
        if(this.isExpress.equals("1"))
        {
            return true;
        }
        else
        {
            return false;
        }         
    }
    
    public String getNote(String orderID) throws InfException
    {
        String notes = "Select note from Orders where orderId = '" + orderID + "'";
        String note1 = idb.fetchSingle(notes);
        return note1; 
    }
    
    public Boolean getMaterialIsOrdered()
    {
        return materialIsOrdered;
    }
    
    public String getShipmentAddress(String orderID) throws InfException
    {
        String id = "Select shipmentAddress from Orders where orderId = '" + orderID + "'";
        String address = idb.fetchSingle(id);
        return address; 
    }
    
    public String getPostalNr(String orderID) throws InfException
    {
        String id = "Select postalNr from Orders where orderId = '" + orderID + "'";
        String postNr = idb.fetchSingle(id);
        return postNr; 
    }

 public String getCity(String orderID) throws InfException
    {
        String cityQ = "Select city from Orders where orderId = '" + orderID + "'";
        String cityA = idb.fetchSingle(cityQ);
        return cityA; 
    }
    
    public ArrayList<Hat> getUnfinishedHats()
    {
        return basicSpecialHatList;
    }
    
    public ArrayList<String> getUnfinishedCustomHat()
    {
        return customHatList;
    }
    
    public ArrayList<Hat> getFinishedHats()
    {
        return finishedBasicSpecial;
    }
    
    public ArrayList<String> getFinishedCustom()
    {
           return finishedCustom;     
    }
    
    private void addOrderToDB() {
        String query = "insert into orders values (default,'" + this.shipmentAddress + "','" + this.orderDate + "',0," + this.totalPrice + ",'" + this.note + "'," + this.isExpress + ", 0," + this.customerID + ",'" + this.postalNr + "','" + this.city + "')";
        
        try {            
            idb.insert(query); 
            //Fixa ett last_insert_ID här om vi hinner
            this.orderID = idb.fetchSingle("select orderID from orders where Orderdate = '" + this.orderDate + "' and Price = " + this.totalPrice + " and Customer = " + this.customerID);                   
           
            JOptionPane.showMessageDialog(null,"Din order är inlagd i databasen");
            
        } 
        catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    private void addBasicSpecialHatsToDB(){
        
        HashMap<Integer, Integer> amountOfHatsList = new HashMap<Integer,Integer>();
        
        for(Hat aHat : basicSpecialHatList){
            
            int hatID = aHat.getHatID();
            
            if(amountOfHatsList.containsKey(hatID)){
                int amount = amountOfHatsList.get(hatID) + 1;
                amountOfHatsList.put(hatID,amount);
            }
            
            else{
                amountOfHatsList.put(hatID,1);
            }
        } 
        
        for(Integer aHatID : amountOfHatsList.keySet())
            
            try{
                String query = "insert into hatinorder values(" + aHatID + ", null," + this.orderID + "," + amountOfHatsList.get(aHatID) + ")";                
                idb.insert(query);
                
            }
            catch(Exception e)
            {
                System.out.print(e.getMessage());
            }
    }
    
    
    private void addCustomHatsToDB(){
        
        HashMap<Integer, Integer> amountOfCustomHatsList = new HashMap<Integer,Integer>();
        
        for(String aHatID : customHatList){
            
            int hatID = Integer.parseInt(aHatID);
            
            if(amountOfCustomHatsList.containsKey(hatID)){
                int amount = amountOfCustomHatsList.get(hatID) + 1;
                amountOfCustomHatsList.put(hatID,amount);
            }
            
            else{
                amountOfCustomHatsList.put(hatID,1);
            }
        } 
        
        for(Integer aHatID : amountOfCustomHatsList.keySet())
            
            try{
                String query = "insert into customhatinorder values(" + aHatID + "," + amountOfCustomHatsList.get(aHatID) + "," + this.orderID + ")";               
                idb.insert(query);
                
            }
            catch(Exception e)
            {
                System.out.print(e.getMessage());
            }
    }
    
    public void deleteOrder(String orderID){
        
        String findID = "SELECT OrderID from Orders WHERE OrderID = '" + orderID + "'";
        
        try{
            String removeOrder = "DELETE FROM Orders WHERE OrderID ='" + orderID + "'";
            int result = JOptionPane.showConfirmDialog(null, "Vill du verkligen ta bort ordern?", "Bekräfta", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION){
                String id = idb.fetchSingle(findID);
                idb.delete("DELETE FROM FinishedCustomHatInOrder WHERE AnOrder =" + id);
                idb.delete("DELETE FROM customhatinorder WHERE AnOrder =" + id);
                idb.delete("DELETE FROM hatinorder WHERE AnOrder =" + id);
                idb.delete(removeOrder);
                
                
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
}
