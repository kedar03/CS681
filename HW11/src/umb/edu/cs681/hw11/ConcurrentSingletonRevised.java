package umb.edu.cs681.hw11;

import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentSingletonRevised {
	
	private ConcurrentSingletonRevised() {};
	private static AtomicReference<ConcurrentSingletonRevised> instance = 
			new AtomicReference<ConcurrentSingletonRevised>(null);
	
	public static AtomicReference<ConcurrentSingletonRevised> getInstance(){
		if (instance.get() == null) {
            instance.set(new ConcurrentSingletonRevised());
        }        
        return instance;
        
        
    }

}
