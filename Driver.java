import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Driver   {

	static String ticker = null;
	static String name = null;
	static double shares;
	static double price;
	static double value;
	
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
       
        UIManager.put("swing.boldMetal", Boolean.FALSE);
       // GUIView view = new GUIView(ticker, name, shares, price, value);
        Frame gui = new Frame();
        gui.createAndShowGUI();
        
      
       
        	
       
  
        
        


       
        
     
       
        
      
            }
        });
    }
}