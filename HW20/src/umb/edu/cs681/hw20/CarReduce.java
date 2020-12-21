package umb.edu.cs681.hw20;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
//import java.util.stream.*;





public class CarReduce {
	
	
	
	private String model, make;
	private int mileage, year,noOfAirbags;
	private int price;
	private int dominationCount;

	public CarReduce(String make, String model, int mileage, int year, int price,int noOfAirbags) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
		this.noOfAirbags = noOfAirbags;
	}

	public String getModel() {
		return model;
	}

	public String getMake() {
		return make;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return price;
	}
	
	public int getNoOfAirbags() {
		return noOfAirbags;
	}

	public int getDominationCount() {
		return this.dominationCount;
	}

	public void setDominationCount(ArrayList<CarReduce> cars) {
		
		for (CarReduce car : cars) {
			if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
					&& (car.getYear() <= this.getYear())) {
				this.dominationCount++;
			}
		}
		this.dominationCount--; 	
	}
	
          @Override
        public String toString() {
        	
        	return this.make +" "+ this.model+" "+ this.mileage+" "+this.year+" "+this.price+" "+ this.noOfAirbags;
        }

	public static void main(String[] args) {
		
		List<CarReduce> list=new ArrayList<CarReduce>();
		list.add(new CarReduce("Tesla", "S", 25, 2018, 100000,6));
		list.add(new CarReduce("Toyota", "Corolla", 9, 2002, 35000,4));
		list.add(new CarReduce("Honda", "Civic", 12, 2012, 40000,2));
		list.add(new CarReduce("Ford", "Fiesta", 10, 2009, 3800,0));
		list.add(new CarReduce("Ford", "Fiesta", 20, 2019, 38000,3));
		
		
		
		//max() with reduce.
		int max_airbags = list.stream().parallel().map((CarReduce car) ->car.getNoOfAirbags() )
				.reduce(0, (result,price)->result > price ? result : price);
		
		System.out.println("Car with most number of air bags"+max_airbags);
		
		
		//min() with reduce
		
		int min_cost = list.stream().parallel().map((CarReduce car) ->car.getPrice() )
				.reduce(1000000000, (result, price)->price>result ? result : price);
		
		System.out.println("Price of cheapest car $"+min_cost);
		
		//count() with reduce
		int y=0;
		int count = list.stream().parallel().map(x->y+1).reduce(0,(a,b)->a+b);
		System.out.println("Total number of cars in list:"+count);
		

	}

}