package edu.umb.cs681.hw1;

public class ObservableTest {

	public static void main(String[] args) {
		StockQuoteObservable stock = new StockQuoteObservable();
		DJIAQuoteObservable djia = new DJIAQuoteObservable(); 
		
		
		djia.addObserver(( Observable o, Object obj)-> {
			System.out.println("DJIA observer added");
		});
		djia.changeQuote(100);
		System.out.println("DJIA Observers notified");
		
		djia.addObserver(( Observable o, Object obj)-> {
			System.out.println("DJIA observer added");
		});
		djia.changeQuote(200);
		System.out.println("DJIA Observers notified");
		
		System.out.println("Number of djia observers"+djia.countObservers());
		
		
		
		stock.addObserver(( Observable o, Object obj)-> {
			System.out.println("Stock observer added");
		});
		stock.changeQuote("test1", 100);
		System.out.println("Stock Observers notified");
		System.out.println("Number of Stock observers"+stock.countObservers());
		

	}

}
