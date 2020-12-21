package umb.edu.cs681.hw18;
import java.util.*;

import java.util.concurrent.atomic.AtomicBoolean;
//import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Observable {
	
	private ConcurrentLinkedQueue<Observer> observers;
	private AtomicBoolean atomic_changed;
	
	public Observable() {
		observers = new ConcurrentLinkedQueue<Observer>();
		atomic_changed = new AtomicBoolean();
		
	}
	//private LinkedList<Observer> observers = new LinkedList<Observer>();
	
	
	
	//private ReentrantLock lock = new ReentrantLock();
	
	
	public synchronized void addObserver(Observer obs)
	   {
		if(obs == null) throw new NullPointerException();
		observers.add(obs);
	    
	     
	   }
	
	public synchronized void deleteObserver(Observer victim)
	    {
			if(observers.remove(victim)) {
				System.out.println("Observer deleted");
			}else {
				System.out.println("Observer does not exist");
			}
	    }
	
	
	protected synchronized void clearChanged()
	     {
	       atomic_changed.set(false);;
	     }
	
	public synchronized boolean hasChanged()
	    {
	      return atomic_changed.get();
	    }
	
	public void notifyObservers()
	    {
	      notifyObservers(null);
	    }
	
	public void notifyObservers(Object obj)
	    {
			if(!atomic_changed.get()) {
				return;
			}
			observers.forEach(o -> o.update(this, obj));
		clearChanged();
	    }
	
	
	protected synchronized void setChanged()
	    {
	      atomic_changed.set(true);;
	    }
	
	
	protected int countObservers()
	{
		return observers.size();
	}
	
	
	
	
	
	
	
	
	
}
