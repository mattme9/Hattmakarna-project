     
/**
 *
 * @author Samuel
 */

import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;

public class HattmakarnaStudio {

    public HattmakarnaStudio(){
 
    }
    
    public static InfDB getDatabase(){
        try{
            InfDB idb = new InfDB("hattdb","3306","hattdb","hattkey");
            return idb;
            }
            catch(InfException e){
                e.getMessage();
                return null;
            }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new WelcomePageGUI().setVisible(true);       
    }
    
}
