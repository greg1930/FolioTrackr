import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Frame extends GUIView   {
	
	String ticker;
	String name;
	double shares;
	double price;
	double value;
	
	Stock stock;
	int count;
	
	
	public Frame() {
		
	}

	
	  public void createAndShowGUI() {
	        //Create and set up the window.
		 
	    	
	        final JFrame frame = new JFrame("Folio Tracker");
	        final Folio folio = new Folio();
	        JMenuBar menuBar = new JMenuBar();
	        JMenu menu, submenu;
	        JMenuItem create, buy, sell, refresh, fill, open, save, exit;
	    
	        final GUIView view = new GUIView();
	        frame.setJMenuBar(menuBar);
	        menu = new JMenu("Folio");
	        
	        create = new JMenuItem("Create");
	        buy = new JMenuItem("Buy");
	        sell = new JMenuItem("Sell");
	        refresh = new JMenuItem("Refresh");
	        fill = new JMenuItem("fill");
	        
	        open = new JMenuItem("Edit");
	        open.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0){
					String tick = "MSFT";
					folio.findTicker(tick);
					/*String temp = JOptionPane.showInputDialog(frame, "Number of Shares");
					shares = Double.parseDouble(temp);
					view.update(shares); */
					
					
				}	
	        });
	        
	        save = new JMenuItem("Save");
	        exit = new JMenuItem("Exit");
	        exit.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
					
				}
	        });
	        
	        menuBar.add(menu);
	        menu.add(create);
	        menu.add(buy);
	        menu.add(sell);
	        menu.add(refresh);
	        menu.add(fill);
	        menu.add(open);
	        menu.add(save);
	        menu.add(exit);
	        
	        
	        
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         
	        //Add content to the window.
	        //frame.add(new GUIView(ticker, name, shares, price, value), BorderLayout.CENTER);
	        
	        //Display the window.
	       
	        frame.add(view, BorderLayout.CENTER);
	        frame.pack();
	        frame.setVisible(true);
	        
	        create.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					ticker = JOptionPane.showInputDialog(frame, "Enter a ticker symbol");
					
					name = JOptionPane.showInputDialog(frame, "Enter stock name");
					String temp = JOptionPane.showInputDialog(frame, "Enter number of shares");
					shares = Double.parseDouble(temp);
					if(shares>0) {
					if(folio.checkIfEntered(ticker)==false) {
						try {
							Stock stock = new Stock(ticker, name, shares);
							folio.add(stock);
							view.model(stock);
					
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (WebsiteDataException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchTickerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (MethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					else {
				
						JOptionPane.showMessageDialog(frame, "Ticker already exists");
					}
					}
					else {
						JOptionPane.showMessageDialog(frame, "Number of shares must be greater than 0");
					}
			      
				}
	        });
	        
	        
	       
	        buy.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					ticker = JOptionPane.showInputDialog(frame, "Enter a ticker symbol");
					
					name = JOptionPane.showInputDialog(frame, "Enter stock name");
					String temp = JOptionPane.showInputDialog(frame, "Enter the additonal shares you want to buy");
					shares = Double.parseDouble(temp);
					if(shares>0) {
					if(folio.checkIfEntered(ticker)==true) {
						try {
							Stock newStock = (folio.updateBuy(folio.findTicker(ticker), shares));
							
						
							view.updateTable(newStock, folio.findTicker(ticker)+1);
					
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (WebsiteDataException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchTickerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (MethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					else {
				
						JOptionPane.showMessageDialog(frame, "Ticker doesn't exist");
					}
					}
					else {
						JOptionPane.showMessageDialog(frame, "You must enter a positive number");
					}
					
			      
				}
	        });
	        
	        
	        
	        sell.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					ticker = JOptionPane.showInputDialog(frame, "Enter a ticker symbol");
					
					name = JOptionPane.showInputDialog(frame, "Enter stock name");
					String temp = JOptionPane.showInputDialog(frame, "Enter the number of shares you want to sell");
					shares = Double.parseDouble(temp);
					if(folio.checkIfEntered(ticker)==true) {
						try {
							Stock newStock = (folio.updateSell(folio.findTicker(ticker), shares));
							if(newStock==null) {
								JOptionPane.showMessageDialog(frame, "You can't have a negative number of shares");
							}
							else {
						
							view.updateTable(newStock, folio.findTicker(ticker)+1);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (WebsiteDataException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NoSuchTickerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (MethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					else {
				
						JOptionPane.showMessageDialog(frame, "Ticker doesn't exist");
					}
					
			      
				}
	        });
	        
	        
	        refresh.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					for(int i=0; i<folio.size(); i++) {
					try {
						view.updateTable(folio.refresh(i), i+1);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WebsiteDataException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchTickerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
			      
				}
	        });
	        
	        fill.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						Stock stock1 = new Stock("AAPL", "apple", 2);
						folio.add(stock1);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WebsiteDataException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchTickerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						Stock stock2 = new Stock("MSFT", "microsoft", 4);
						folio.add(stock2);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (WebsiteDataException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchTickerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for(int i=0; i<folio.size(); i++) {
						view.model(folio.fill(i));
					}
					
			      
				}
	        });
	        
	        
	        
	        
	        
	        
	        
	    }
	  
	  
	  
	  


	
	
	
	
		
	
	
					
					
					
					/*Object[][] length = stockData();
					for(int i = 0; i < 2; i++){
						for(int j=0; j < 5; j++){
							System.out.println(length[i][j]);
						}
					} */
					
				
	
	
	
}
