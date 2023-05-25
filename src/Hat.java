

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author almahedengren
 */
public class Hat {

    private int hatID;
    private String productName;
    private double price;
    private String note;
    private String isSpecial;
    private String material;
    private ArrayList<String> colours;
    private ArrayList<String> materials;
    private InfDB idb;
    private byte[] picture;
    
    public Hat(String name)
   {          
       this.idb = HattmakarnaStudio.getDatabase();
       getOldHat(name);      
   }
   
    public Hat(String name, double price, String note, byte[] pic, String isSpecial, ArrayList<String> color, ArrayList<String> material)
    {
        materials = new ArrayList();
        colours = new ArrayList();
        this.productName = name;
        this.price = price;
        this.note = note;
        this.picture = pic;
        this.isSpecial = isSpecial;
        this.colours = color;
        this.materials = material;
        
        regNewHat(name, price, note, isSpecial);
        regNewHatColours(colours);
        regNewHatMaterials(materials);
    }

    public static ArrayList<Hat> getAllHats() 
    {
        ArrayList<Hat> allHats = new ArrayList<>();

        try {
            InfDB idb = HattmakarnaStudio.getDatabase();
            ArrayList<HashMap<String, String>> allRows = idb.fetchRows("select * from hat");

            for (HashMap<String, String> row : allRows) {
                String hatName = "";
                
                for (String key : row.keySet()) {
                    if (key.equals("HatName")) {
                        hatName = row.get(key);
                    }
  
                }
                Hat aHat = new Hat(hatName);
                allHats.add(aHat);
            }

            
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        
        return allHats;
    }
    
    private void regNewHatMaterials(ArrayList<String> materials)
    {
            this.idb = HattmakarnaStudio.getDatabase();
            
            try{
                for(String oneMaterial : materials){
                    int materialid = Integer.parseInt(idb.fetchSingle("SELECT MaterialID FROM Material WHERE Material ='" + oneMaterial + "'"));
                    int hattid = Integer.parseInt(idb.fetchSingle("SELECT HatID FROM Hat WHERE Hatname = '" + productName + "'"));
                    
                    idb.insert("INSERT INTO IsOfMaterial (MaterialID, HatID) VALUES(" + materialid + "," + hattid +")");
                }
            }catch(InfException e){
                System.out.println(e.getMessage());
            }
    }
    
    private void regNewHatColours(ArrayList<String> colours)
    {
            this.idb = HattmakarnaStudio.getDatabase();
            try{
                for(String oneColour : colours){
                int colorid = Integer.parseInt(idb.fetchSingle("SELECT ColourID FROM HatColour WHERE Colour='" + oneColour + "'"));
                int hattid = Integer.parseInt(idb.fetchSingle("SELECT HatID FROM Hat WHERE HatName = '" + productName + "'"));
                
                idb.insert("INSERT INTO is_of_colour (HatID, ColourID) VALUES (" + hattid + "," + colorid + ")");
                
                }
                
            }catch(InfException e){
                System.out.println(e.getMessage());
            }
    }
    
    
    private void regNewHat(String name, double price, String note, String isSpecial) {
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HattDB", "hattdb", "hattkey");
            PreparedStatement stmt = conn.prepareStatement("insert into hat (HatName, Price, Note, Picture, isSpecial) values (?, ?, ?, ?, ?)");

            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.setString(3, note);
            stmt.setBytes(4, picture);
            stmt.setString(5, isSpecial);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "En ny hatt har registrerats!");
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Något gick fel. Har du fyllt i all information?");
        }
    }
    
    private void getOldHat(String name){
    
        this.productName = name;
        
        idb = HattmakarnaStudio.getDatabase();

        try {
            HashMap<String, String> hatInfo = idb.fetchRow("select * from hat where HatName = '" + name + "'");
             
            for(String key : hatInfo.keySet()){              
                               
                switch(key){
                    case "HatID":
                        this.hatID = Integer.parseInt(hatInfo.get(key));
                        break;
                    case "Price":
                        this.price = Double.parseDouble(hatInfo.get(key));
                        break;
                    case "Note":
                        this.note = hatInfo.get(key);
                        break;
                    case "isSpecial":
                        this.isSpecial = hatInfo.get(key);
                        break;
                    case "Picture":
                        fetchPicture(this.hatID);
                        break;
               
                }               
            }


        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    public ArrayList<String> getColours(){
        return colours;
    }
    
    public ArrayList<String> getMaterials(){
        return materials;
    }
    
    public int getHatID ()
    {
        return hatID;
    }
    
    public String getProductName ()
    {
        return productName;
    }
    
    public Double getPrice ()
    {
        return price;
    }
    
    public String getNote ()
    {
        return note;
    }
    
    public String getIsSpecial()
    {
        return isSpecial;
    }
    
    public String getMaterial()
    {
        return material; 
    }
   
    public void setProductName(String name) {
        
        try {
            idb.update("update hat set HatName = " + name + " where HatID = " + this.hatID);
        } 
        
        catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
   
    public void setPrice(Double price)
    {
        try {
            idb.update("update hat set Price = " + price + " where HatID = " + this.hatID);
        } 
        
        catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void setNote(String note)
    {
         try {
            idb.update("update hat set Note = '" + note + "' where HatID = " + this.hatID);
        } 
        
        catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void setIsSpecial(String status)
    {
        try {
            idb.update("update hat set isSpecial = " + status + " where HatID = " + this.hatID);
        } 
        
        catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void setPicture(byte[] image) {
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HattDB", "hattdb", "hattkey");
            PreparedStatement stmt = conn.prepareStatement("update hat set Picture = ? where HatID = ?");
           
            stmt.setBytes(1, image);
            stmt.setInt(2, this.hatID);
            stmt.executeUpdate();

        }
        catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void setMaterial(String aTextField)
    {
        
    }
    
    private void fetchPicture(int ID)
    {
        try{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HattDB", "hattdb", "hattkey");
    
        String query = "SELECT picture FROM hat WHERE hatID= " + ID;
        PreparedStatement stmtt = conn.prepareStatement(query);
        ResultSet rs = stmtt.executeQuery();
        byte[] image = null;
        
        if (rs.next()) {
            image = rs.getBytes("Picture");
        }
               
        this.picture =  image;
        }
        catch(Exception e){
            System.out.print(e.getMessage());           
        }
    }
}
