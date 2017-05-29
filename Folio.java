import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;


public class Folio {

	ArrayList<Stock> arrayList = new ArrayList<Stock>();
	
	boolean entered = true;
	
		
	
	public Folio() {
		
		
	}
	
	public void add(Stock stock) {
		arrayList.add(stock);
	}
	
	public int size() {
		return arrayList.size();
	}
	
	public boolean checkIfEntered(String Ticker) {
		boolean result = false;
		for (int i=0; i<arrayList.size(); i++) {
			if(arrayList.get(i).getTicker().equals(Ticker)) {
				result = true;
			}
		}
		return result;
	}
	
	public int findTicker(String Ticker) {
		int result = 0;
		for (int i=0; i<arrayList.size(); i++) {
			if(arrayList.get(i).getTicker().equals(Ticker)) {
				result = i;
			}
		}
		return result;
		

	}
	
	public Stock updateBuy(int i, double newSharesValue) throws IOException, WebsiteDataException, NoSuchTickerException, MethodException {
		String ticker = arrayList.get(i).getTicker();
		String name = arrayList.get(i).getName();
		double shares = arrayList.get(i).getShares();
		double price = arrayList.get(i).getPrice();
		double value = arrayList.get(i).getValue();
		double totalShares = shares + newSharesValue;
		Stock stock = new Stock(ticker, name, totalShares);
		arrayList.set(i, stock);
		return stock;
	}
	
	public Stock updateSell(int i, double newSharesValue) throws IOException, WebsiteDataException, NoSuchTickerException, MethodException {
		Stock stock = null;
		String ticker = arrayList.get(i).getTicker();
		String name = arrayList.get(i).getName();
		double shares = arrayList.get(i).getShares();
		double price = arrayList.get(i).getPrice();
		double value = arrayList.get(i).getValue();
		if(newSharesValue<shares) {
		double totalShares = shares - newSharesValue;
		stock = new Stock(ticker, name, totalShares);
		arrayList.set(i, stock);
		}
		return stock;
	}
	
	public Stock refresh(int i) throws IOException, WebsiteDataException, NoSuchTickerException, MethodException {
			String ticker = arrayList.get(i).getTicker();
			String name = arrayList.get(i).getName();
			double shares = arrayList.get(i).getShares();
			Stock stock = new Stock(ticker, name, shares);
			arrayList.set(i, stock);
			return stock;
		
	}
	
	public Stock fill(int i) {
		return arrayList.get(i);
	}

	public void show() {
		for (int i=0; i<arrayList.size(); i++) {
			  System.out.println(arrayList.get(i).getTicker());
			  System.out.println(arrayList.get(i).getName());
			  System.out.println(arrayList.get(i).getShares());
			  System.out.println(arrayList.get(i).getPrice());
			  System.out.println(arrayList.get(i).getValue());
			 // result =  arrayList.get(i);
			}
	//	return result;
	} 
	
	
	
} 
