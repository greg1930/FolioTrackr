import java.io.IOException;

import javax.swing.table.DefaultTableModel;

public class Stock  {

	private String ticker;
	private String name;
	private double nOfShares;
	private double pPerShare;
	private double val;
	
	
	
	
	public Stock(String tickerSymbol, String stockName, double numberOfShares) throws IOException, WebsiteDataException, NoSuchTickerException, MethodException {
		this.ticker = tickerSymbol;
		this.name = stockName;
		this.nOfShares = numberOfShares;
		Quote quote = new Quote(false);
		quote.setValues(ticker);
		this.pPerShare = quote.getLatest();
		this.val = nOfShares*pPerShare;
		
	}
	
	


	public String getTicker() {
		// TODO Auto-generated method stub
		return ticker;
	}




	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}




	public double getShares() {
		// TODO Auto-generated method stub
		return nOfShares;
	}




	public double getPrice() {
		// TODO Auto-generated method stub
		return pPerShare;
	}




	public double getValue() {
		// TODO Auto-generated method stub
		return val;
	}
	
	
	
	
	
}
