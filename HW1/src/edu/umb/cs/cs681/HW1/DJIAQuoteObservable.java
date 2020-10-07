package edu.umb.cs681.hw1;

//import java.util.Observable;


public class DJIAQuoteObservable extends Observable{
	
	float quote;
	void changeQuote(float q) {
		this.quote = q;
		setChanged();
		notifyObservers(new DJIAEvent(q));
	}
	
	
}
