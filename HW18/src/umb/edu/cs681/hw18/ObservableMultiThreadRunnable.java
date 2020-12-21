package umb.edu.cs681.hw18;

import java.util.Random;

public class ObservableMultiThreadRunnable {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		StockQuoteObservable sqo = new StockQuoteObservable();
        String code = "SQO";
        Float value = 3000.0f;
        
        
        DJIAQuoteObservable djia = new DJIAQuoteObservable();
    	String quo = "DJIA";
    	Float val = 4000.0f;
    	
    	
    	
    	
    	//StockQuote Observer
    	
    	System.out.println("Stock Quote observers...");
    	sqo.addObserver((Observable o, Object obj) -> {
            String ticker = ((StockEvent) obj).getTicker();
            Float quote = ((StockEvent) obj).getQuote();
            System.out.println("Stock Quote observer 1" + ticker + " " + quote);
        });
    	
    	 sqo.addObserver((Observable o, Object obj) -> {
             String ticker = ((StockEvent) obj).getTicker();
             Float quote = ((StockEvent) obj).getQuote();
             System.out.println("Stock Quote observer 2" + ticker + " " + quote);
         });
    	 
    	 System.out.println("Number of Stock Quote observers:" + sqo.countObservers());
    	 sqo.changeQuote(code, value);
    	 value = 200.0f;
         System.out.println("\n\t SQO changed");
         sqo.changeQuote(code, value);
    	
    	
    	
    	//DJIA Observers
    	System.out.println("DJIA Quote observers...");
    	djia.addObserver((Observable o, Object obj) -> {
            Float t = ((DJIAEvent) obj).getDjia();
            System.out.println("DJIA observer 1 " + t);
        });
    	
    	
    	djia.addObserver((Observable o, Object obj) -> {
            Float t = ((DJIAEvent) obj).getDjia();
            System.out.println("DJIA observer 2 " + t);
        });
    	
    	System.out.println("Number of DJIA observers:" + djia.countObservers()); 
    	
    	djia.changeQuote(val);
    	val = 3000.0f;
    	djia.changeQuote(val);
    	System.out.println("\n DJIA changed");
    	
    	
    	
        
    	
    	
    	
    	
         
    	 //StockQuote MultiThreading
        Thread s1  = new Thread(() ->{ sqo.changeQuote("SQO", random.nextFloat()*10f + 2000f); 
		   sqo.notifyObservers(new StockEvent("SQO", random.nextFloat()*10f + 2000f));});
        Thread s2  = new Thread(() ->{ sqo.changeQuote("SQO", random.nextFloat()*10f + 2000f); 
		   sqo.notifyObservers(new StockEvent("SQO", random.nextFloat()*10f + 2000f));});
        Thread s3  = new Thread(() ->{ sqo.changeQuote("SQO", random.nextFloat()*10f + 2000f); 
		   sqo.notifyObservers(new StockEvent("SQO", random.nextFloat()*10f + 2000f));});
        Thread s4  = new Thread(() ->{ sqo.changeQuote("SQO", random.nextFloat()*10f + 2000f); 
		   sqo.notifyObservers(new StockEvent("SQO", random.nextFloat()*10f + 2000f));});
        
        
        
        
         //DJIA MultiThreading
         Thread d1  = new Thread(() ->{ djia.changeQuote(random.nextFloat()*10f + 1000f); 
		   djia.notifyObservers(new DJIAEvent(random.nextFloat()*10f + 1000f));});
         Thread d2  = new Thread(() ->{ djia.changeQuote(random.nextFloat()*10f + 1000f); 
		   djia.notifyObservers(new DJIAEvent(random.nextFloat()*10f + 1000f));});
         Thread d3  = new Thread(() ->{ djia.changeQuote(random.nextFloat()*10f + 1000f); 
		   djia.notifyObservers(new DJIAEvent(random.nextFloat()*10f + 1000f));});
         Thread d4  = new Thread(() ->{ djia.changeQuote(random.nextFloat()*10f + 1000f); 
		   djia.notifyObservers(new DJIAEvent(random.nextFloat()*10f + 1000f));});
         
         
         
        
         
         
         
         s1.start();
         s2.start();
         s3.start();
         s4.start();
         
         
         d1.start();
         d2.start();
         d3.start();
         d4.start();
         
         
         try {
        	 s1.join();
        	 s2.join();
        	 s3.join();
        	 s4.join();
        	 
        	 
        	 d1.join();
        	 d2.join();
        	 d3.join();
        	 d4.join();
        	 
         }catch(InterruptedException e) {
        	 System.out.println(e);
         }
    	
    	
	}

}
