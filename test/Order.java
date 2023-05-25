/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import oru.inf.InfDB;
/**
 *
 * @author almahedengren
 */
public class Order {
    
    private String orderID;
    private String ShipmentAddress;
    private String customerID;
    private Date orderDate; 
    private boolean isFinished; 
    private Double totalPrice;
    private Boolean isExpress; 
    private String note;
    private Boolean materialIsOrdered;
    private ArrayList<Hat> basicHatList;
    private ArrayList<String> customHatList;
    private ArrayList<Hat> finishedBasicSpecial;
    private ArrayList<String> finishedCustom;
    private InfDB idb;
    
    public Order(String orderID)
    {
    
        idb = HattmakarnaStudio.getDatabase();

        try {
            HashMap<String, String> orderInfo = idb.fetchRow("select * from orders where OrderID = " + orderID + "");
             
            for(String key : orderInfo.keySet()){
              
               
                
                switch(key){
                    case "ShipmentAddress":
                        this.ShipmentAddress = orderInfo.get(key);
                        break;
                    
                    case "Price":
                        this.totalPrice = Double.parseDouble(orderInfo.get(key));
                        break;
                    
                    case "Note":
                        this.note = orderInfo.get(key);
                        break;
                    
                    case "isFinished":
                        if (orderInfo.get(key).equals("0")) {
                            this.isFinished = false;
                        } else {
                            this.isFinished = true;
                        }
                        break;
                    
                    case "Orderdate":
                        this.orderDate = new Date(orderInfo.get(key));
                        break;
                    
                    case "isExpress":
                        if (orderInfo.get(key).equals("0")) {
                            this.isExpress = false;
                        } else {
                            this.isExpress = true;
                        }
                        break;
                        
                    case "MaterialOrdered":
                        if (orderInfo.get(key).equals("0")) {
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

            getBasicSpecialHats(orderID);
            getFinishedBasicSpecialHats(orderID);
            getCustomHats(orderID);
            getFinishedCustomHats(orderID);
            
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
       
    
    private void getBasicSpecialHats(String orderID)
    {
        try {
            ArrayList<HashMap<String, String>> allHats = idb.fetchRows("select * from hatinorder where AnOrder = " + orderID);

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
                    
                    basicHatList.add(aHat);                    
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    private void getFinishedBasicSpecialHats(String orderID)
    {
        try {
            ArrayList<HashMap<String, String>> allHats = idb.fetchRows("select * from finishedhatinorder where AnOrder = " + orderID);

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
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    private void getCustomHats(String orderID)
    {
        try {
            ArrayList<HashMap<String, String>> allHats = idb.fetchRows("select * from customhatinorder where AnOrder = " + orderID);

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
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    private void getFinishedCustomHats(String orderID)
    {
        try {
            ArrayList<HashMap<String, String>> allHats = idb.fetchRows("select * from finishedcustomhatinorder where AnOrder = " + orderID);

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
    
    public Date getOrderDate()
    {
        return orderDate;
    }
    
    public boolean isFinished()
    {
        return isFinished;
    }
    
    public Double getPrice()
    {
        return totalPrice;
    }
       
    public Boolean getExpress()
    {
        return isExpress; 
    }
    
    public String getNote()
    {
        return note;
    }
    
    public Boolean getMaterialIsOrdered()
    {
        return materialIsOrdered;
    }
    
    public String getShipmentAddress()
    {
        return ShipmentAddress;
    }
    
    public ArrayList<Hat> getUnfinishedHats()
    {
        return basicHatList;
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
}