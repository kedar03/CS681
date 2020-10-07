package edu.umb.cs681.hw1;
import java.util.*;

public abstract class Observable {
	private LinkedList<Observer> observers = new LinkedList<Observer>();
	private boolean changed;
	
	
	public synchronized void addObserver(Observer obs)
	   {
	    
	     observers.add(obs);
	   }
	
	public synchronized void deleteObserver(Observer victim)
	    {
	      observers.remove(victim);
	    }
	
	
	protected synchronized void clearChanged()
	     {
	       changed = false;
	     }
	
	public synchronized boolean hasChanged()
	    {
	      return changed;
	    }
	
	public void notifyObservers()
	    {
	      notifyObservers(null);
	    }
	
	public void notifyObservers(Object obj)
	    {
	      if (! hasChanged())
	        return;
	    
	      Set s;
	      synchronized (this)
	        {
	          s = (Set) observers.clone();
	        }
	      int i = s.size();
	      Iterator iter = s.iterator();
	      while (--i >= 0)
	        ((Observer) iter.next()).update(this, obj);
	      clearChanged();
	    }
	
	
	protected synchronized void setChanged()
	    {
	      changed = true;
	    }
	
	
	protected int countObservers() {
		return observers.size();
	}
	
	
	
	
	
	
	
	
	
}
