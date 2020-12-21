package umb.edu.cs681.hw18;

//import java.util.Observable;

import java.util.concurrent.locks.ReentrantLock;


public class DJIAQuoteObservable extends Observable{
	
	
	
	float quote;
	private ReentrantLock lock = new ReentrantLock();
	void changeQuote(float q) {
		lock.lock();
		this.quote = q;
		setChanged();
		notifyObservers(new DJIAEvent(q));
		lock.unlock();
	}
	
	
}
