package edu.umb.cs681.hw1;

import java.util.HashMap;
import java.util.Map;
//import java.util.Observable;

public class StockQuoteObservable extends Observable{
	
	Map<String, Float> map = new HashMap<String, Float>();
	
	void changeQuote(String t,float q) {
		map.put(t, q);
		setChanged();
		notifyObservers(new StockEvent(t,q));
	}
	
	
}
