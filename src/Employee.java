import java.util.HashMap;
 import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;


/**
 * @author almahedengren
 */

 public class Employee {

    private String employeeID;
    private String user;
    private static String password;
    private String name;
    private static InfDB idb;
    private static WelcomePageGUI wPage;
    public Employee(WelcomePageGUI wPage){
    this.wPage = wPage;
    }

    public Employee(String user, String pass, String fullName)
    {
      idb = HattmakarnaStudio.getDatabase();
      
      addEmployee(user,pass,fullName);          
    }
    
    //specifik konstruktor för att hämta specifik anställd
    
    public Employee(String user)
    {
        this.user = user;
        
        idb = HattmakarnaStudio.getDatabase();
        
       
    }
    
    private void addEmployee(String user, String pass, String fullName) {
         try {
             idb.insert("insert into Employee values (default,'" + user + "','" + pass + "','" + fullName + "')");
             this.employeeID = (idb.fetchSingle("select employeeID from employee where Username = '" + user + "'"));
             JOptionPane.showMessageDialog(null, "Ny personal registrerad");

         } catch (Exception e) {
             System.out.print(e.getMessage());
             JOptionPane.showMessageDialog(null, "Något gick fel");
         }
     }
    
    public String getEmployeeID(String username) throws InfException
    {
        String idQ = "Select EmployeeID from Employee where Username = '" + username + "'";
        String idA = idb.fetchSingle(idQ);
        return idA;
    }

    public String getPassword(String username) throws InfException
    {
        String passQ = "Select Pass from Employee where Username = '" + username + "'";
        String passA = idb.fetchSingle(passQ);
        return passA;
    }

    public String getName(String username) throws InfException
    {
        String nameQ = "Select FullName from Employee where Username = '" + username + "'";
        String nameA = idb.fetchSingle(nameQ);
        return nameA;
    }
    
       public void setPassword(String newPass, String username) throws InfException
    {
        String passQ = "Update Employee set Pass = '" + newPass + "' where Username = '" + username + "'";
        idb.update(passQ);
    }

    public void setName(String newName, String username) throws InfException
    {
        String nameQ = "Update Employee set FullName = '" + newName + "' where Username = '" + username + "'";
        idb.update(nameQ);
    }
    
        public void setUserName(String newUserName, String username) throws InfException
    {
        String userNameQ = "Update Employee set Username = '" + newUserName + "' where Username = '" + username + "'";
        idb.update(userNameQ);
    }
    
    
    /**
     * Metoden för att logga in som användare.
     *
     * @param userNameBox
     * @param passwordBox
     */
    public static void loginUser(JTextField userNameBox, JPasswordField passwordBox){
        //Skickade ner från konstruktor annars NULL
        idb = HattmakarnaStudio.getDatabase();
        if (Validation.checkEmpty(userNameBox) && Validation.checkEmpty(passwordBox)) {
            try {
                //hämtar användarnamn ifrån loginruta
                String username = userNameBox.getText();

                // hämta lösenordet som matchar angivet användarnamn ifrån databasen
                String password = idb.fetchSingle("SELECT Pass FROM employee WHERE Username='" + username + "'");

                //jämför inskrivet lösen med det som står skrivet i rutan lösenord
                if (Validation.checkIfEmpty(password) && Validation.checkPassword(password, passwordBox)) {

                    //om ovan villkor är true skapas en ny ruta
                    new HomePageGUI(username).setVisible(true);
                    wPage.dispose();
                }

            }catch(Exception e) {
                Logger.getLogger(WelcomePageGUI.class.getName()).log(Level.SEVERE, null, e);
                System.out.println(e.getMessage());
            }
        }
    }

}
