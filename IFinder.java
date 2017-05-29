import java.io.IOException;

public interface IFinder {

	//from front-end
	//String tickerSymbol(String tickerSymbol);
	
	//String stockName(String stockName);
	
	//double numberOfShares(double numberOfShares);
	
	// from back-end
	double value();
	
	double pricePerShare() throws MethodException, IOException, WebsiteDataException, NoSuchTickerException;
	
	
	
	
	
}
