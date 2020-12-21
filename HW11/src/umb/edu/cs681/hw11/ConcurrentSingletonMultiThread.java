package umb.edu.cs681.hw11;

public class ConcurrentSingletonMultiThread implements Runnable{
	public void run() {
		System.out.println(ConcurrentSingletonRevised.getInstance());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new ConcurrentSingletonMultiThread()).start();

	}

}
