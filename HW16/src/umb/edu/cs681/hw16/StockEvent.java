package umb.edu.cs681.hw16;

public class StockEvent{
	
	public String ticker;
	public float quote;

	public StockEvent(String t, float q) {
		this.ticker = t;
		this.quote = q;
	}
	public float getQuote()
	{
		return quote;
	}
	//getters
	public String getTicker()
	{
		return ticker;
	}
	
	
	
	
}
