
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class GUIView extends JPanel {
	
	String ticker;
	String name;
	double shares;
	double price;
	double value;
	JTable table;
	DefaultTableModel  model;
	
	


	
		 public GUIView() {
		        super(new GridLayout(1, 1));
		    
				
				
				if(ticker==null ) {
				 model = new DefaultTableModel(stockData(),names());
				
				
				table = new JTable(model);
			
				
				
		        JTabbedPane tabbedPane = new JTabbedPane();
		         
		        JComponent panel1 = makeInfoPanel("Panel #1");
		        tabbedPane.addTab("Tab 1", panel1);
		         

		        //Add the tabbed pane to this panel.
		        add(tabbedPane);
		        
		         
		        //The following line enables to use scrolling tabs.
		        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
				}
		       
		    }
		 
		 protected void model(Stock stock) {
			 
			 ticker = stock.getTicker();
			 name = stock.getName();
			 shares = stock.getShares();
			 price = stock.getPrice();
			 value = stock.getValue();
			 model.addRow(new Object[]{ticker, name, shares, price, value});
			 model.fireTableDataChanged();
		 }
		 
		 protected void updateTable(Stock stock, int index) {
			 shares = stock.getShares();
			 price = stock.getPrice();
			 value = stock.getValue();
			 model.setValueAt(shares, index, 2);
			 model.setValueAt(price, index, 3);
			 model.setValueAt(value, index, 4);
			 model.fireTableDataChanged();
		 }
		 
		 protected void getTicker() {
			 for(int i=0; i<model.getRowCount(); i++) {
				 System.out.println(model.getValueAt(i, 0));
			 }
			 
		 }
		
		

		protected String[] names(){
				String[] columnNames = {"Ticker Symbol",
			            "Stock Name",
			            "Number of Shares",
			            "Price per Share",
			            "Value of Holding"};
				return columnNames;
			}
			
			protected Object[][] stockData(){
				
				Object[][] data = {
						
						{},
						
					};
				return data;
				
			}
		    
		    public JComponent makeInfoPanel(String text) {
		    		 
		    	
		       	
		    	
		    
		    	
		    	
		    	
		    	
		    	table.setPreferredScrollableViewportSize(new Dimension(725, 200));
		    	table.setFillsViewportHeight(true);
		    	
		    
		    	//Create the scroll pane and add the table to it.
		    	JScrollPane scrollPane = new JScrollPane(table);
		        JPanel panel = new JPanel(false);
		        panel.setLayout(new GridLayout(1, 1));
		        panel.add(scrollPane);
		    	
		        return panel;
		    	
		    	
		    }
		    
		    public JComponent text(){
		       	//Labels to identify the fields
		    	JLabel tickerSymbol;
		    	JLabel noOfShares;

		    	//Strings for the labels
		    	String tickerSym = "Ticker symbol: ";
		    	String shares= "shares: ";

		    	//Fields for data entry
		    	JFormattedTextField tickerField;
		    	JFormattedTextField sharesField;

		    	//Create the labels.
		    	tickerSymbol = new JLabel(tickerSym);
		    	noOfShares = new JLabel(shares);

		    	//Create the text fields and set them up.
		    	tickerField = new JFormattedTextField();
		    	tickerField.setColumns(5);

		    	sharesField = new JFormattedTextField();
		    	sharesField.setColumns(5);

		    	//Tell accessibility tools about label/textfield pairs.
		    	tickerSymbol.setLabelFor(tickerField);
		    	noOfShares.setLabelFor(sharesField);

		    	//Lay out the labels in a panel.
		    	JPanel labelPane = new JPanel(new GridLayout(0,1));
		    	labelPane.add(tickerSymbol);
		    	labelPane.add(noOfShares);
		    	tickerSymbol.setPreferredSize( new Dimension( 150, 24 ) );

		    	////Layout the text fields in a panel.
		    	JPanel fieldPane = new JPanel(new GridLayout(0,1));
		    	fieldPane.add(tickerField);
		    	fieldPane.add(sharesField);

		    	//Put the panels in this panel, labels on left,
		    	//text fields on right.
		    	setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		    	add(labelPane, BorderLayout.CENTER);
		    	add(fieldPane, BorderLayout.LINE_END);
				return fieldPane;
		    }
	


		    
		    
					
		        
	}
