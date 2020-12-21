package umb.edu.cs681.hw16;
import java.util.*;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Observable {
	private LinkedList<Observer> observers = new LinkedList<Observer>();
	private boolean changed;
	
	private AtomicBoolean atomic_changed= new AtomicBoolean(false);
	private ReentrantLock lock = new ReentrantLock();
	
	
	public synchronized void addObserver(Observer obs)
	   {
		lock.lock();
		try {
			if(!observers.contains(obs)) {
				observers.add(obs);
				
			}
		}finally {
			lock.unlock();
		}
	    
	     
	   }
	
	public synchronized void deleteObserver(Observer victim)
	    {
			lock.lock();
			try {
				if (observers.contains(victim)) {
					observers.remove(victim);
				} 
			} finally {
				lock.unlock();
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
			lock.lock();
			try {
				
				observers.forEach(o -> o.update(this, obj));
				
		} finally {
			
			lock.unlock();
		}
		clearChanged();
	    }
	
	
	protected synchronized void setChanged()
	    {
	      atomic_changed.set(true);;
	    }
	
	
	protected int countObservers() {
		lock.lock();
		try {
			return observers.size();
		} finally {
			lock.unlock();
		}
	}
	
	
	
	
	
	
	
	
	
}
