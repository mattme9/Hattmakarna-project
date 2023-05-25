

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * @author Linda
 */
public class Validation {
    public static InfDB idb;
    /**
     * Creates new form RegHatGUI
     */
    public Validation() {
        idb = HattmakarnaStudio.getDatabase();
        
    }
    /**
     *
     * @param oneField
     * @return 
     * Metod för att kolla om rutan för användarnamn är tom. Ifall rutan
     * är tom skrivs ett felmeddelande ut som beskriver problemet.
     */
    
    public static boolean checkEmpty(JTextField oneField) {
        boolean result = true;
        if (oneField.getText().isEmpty()) {
            result = false;
            JOptionPane.showMessageDialog(null, "Du har inte fyllt i alla nödvändiga uppgifter");
            oneField.requestFocus();
        }
        return result;
     
    }
    
    public static boolean checkEmptyArea (JTextArea oneArea){
        boolean result = true;
        if (oneArea.getText().isEmpty()) {
            result = false;
            JOptionPane.showMessageDialog(null, "Fyll i anteckningar.");
            oneArea.requestFocus();
        }
        return result;
    }
    
    public static boolean checkComboBox(JComboBox x) {
        boolean filledComboBox= true;
        if (x.getSelectedIndex() == 0) {
            filledComboBox = false;
            JOptionPane.showMessageDialog(null, "Vänligen välj ett alternativ i listan");
        }
        return filledComboBox;
    }
    /**
     *
     * @param oneString
     * @param passwordField
     * @return 
     * Kontrollerar så att lösenordet som skrivs in och som finns i
     * databasen stämmer överens. Om det inte stämmer skrivs ett felmeddelande
     * ut.
     */
    public static boolean checkPassword(String oneString, JPasswordField passwordField) {
        boolean result = true;
        if (!oneString.equals(passwordField.getText())) {
            result = false;
            JOptionPane.showMessageDialog(null, "Felaktigt lösenord");
            passwordField.requestFocus();
        }
        return result;
    }
    
     /**
     *
     * @param variableToCheck
     * @return 
     * Kontrollerar om en viss variabel innehåller ett nullvärde.
     * Används vid inloggning och kollar om det finns ett lösenord till vald
     * namn. Om valt namn inte har något lösenord kommer felmeddelande upp.
     */
    public static boolean checkIfEmpty(String variableToCheck) {
        boolean result = true;
        if (variableToCheck == null) {
            result = false;
            JOptionPane.showMessageDialog(null, "Felaktigt användarnamn");
        }
        return result;
    }
    
    public static boolean chechIfHatDoesNotExist(JTextField HatNamn) throws InfException{
        idb = HattmakarnaStudio.getDatabase();
        ArrayList<String> names = idb.fetchColumn("SELECT HatName FROM Hat");
        
        for(String oneName : names){
            if(oneName.equals(HatNamn.getText())){
                JOptionPane.showMessageDialog(null, "Hattnamnet finns redan.");
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkIfUserDoesNotExist(JTextField user) throws InfException{
        idb = HattmakarnaStudio.getDatabase();
        ArrayList<String> users = idb.fetchColumn("SELECT Username FROM Employee");
        
        for(String oneUser : users){
            if(oneUser.equals(user.getText())){
                JOptionPane.showMessageDialog(null, "Användarnamnet finns redan.");
                return false;
            }
        }
        return true;
    }
            
    public static boolean onlyNumbers (JTextField phone)
    {
        boolean result = false;
        if(phone.getText().matches("[0-9]")){
        result = true;
        }
        else {
                JOptionPane.showMessageDialog(null, "Endast siffror tillåtna i telefonnummer");
           }
        return result;
    }
    
        public static boolean validEmail (JTextField email)
    {
        boolean result = true;
        if(!email.getText().contains("@")){
        JOptionPane.showMessageDialog(null, "Email måste innehålla @!");
        result = false;
    }
        return result;
    }
        
}
