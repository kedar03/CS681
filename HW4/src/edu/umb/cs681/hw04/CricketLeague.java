package edu.umb.cs681.hw04;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;
import java.util.Comparator;





public class CricketLeague {
	
	
	
	private String name;
	private int no_of_runs, centuries, avg, strike_rate;
	

	public CricketLeague(String name,int  no_of_runs, int centuries,int  avg,int strike_rate){
		this.name = name;
		this.no_of_runs = no_of_runs;
		this.avg = avg;
		this.strike_rate = strike_rate;
		
	}

	public String getName() {
		return name;
	}

	public int getRuns() {
		return no_of_runs;
	}

	public int getCenturies() {
		return centuries;
	}

	public int getAvg() {
		return avg;
	}

	public int getStrikeRate() {
		return strike_rate;
	}


	
          @Override
        public String toString() {
        	
        	return this.name +" "+ this.no_of_runs+" "+ this.centuries+" "+this.avg+" "+this.strike_rate;
        }

	public static void main(String[] args) {
		
		List<CricketLeague> list=new ArrayList<CricketLeague>();
		list.add(new CricketLeague("Virat Kohli", 11867, 43, 59, 93));
		list.add(new CricketLeague("MS Dhoni", 10000, 10, 50, 85));
		list.add(new CricketLeague("Steven Smith", 9000, 11, 55, 90));
		list.add(new CricketLeague("Chris Gayle", 10480, 25, 38, 87));
		list.add(new CricketLeague("Ab de Villiers", 9577, 25, 53,101 ));
		
		
		
		//max() with reduce.
		int max_runs = list.stream().map((CricketLeague batsman) ->batsman.getRuns() )
				.reduce(0, (result,price)->result > price ? result : price);
		
		System.out.println("Maximum number of runs scored byt batsman $"+max_runs);
		
		
		//min() with reduce
		
		int min_cost = list.stream().map((CricketLeague batsman) ->batsman.getAvg() )
				.reduce(1000000000, (result, price)->price>result ? result : price);
		
		System.out.println(" Minimum average runs per match $"+min_cost);
		
		//count() with reduce
		int y=0;
		int count = list.stream().map(x->y+1).reduce(0,(a,b)->a+b);
		System.out.println("Total number of batsman in list:"+count);
		
		
		System.out.println("Batsman sorted by number of runs:");
		List<CricketLeague> sortedByRuns=list.stream().sorted(Comparator.comparingInt(CricketLeague::getRuns)).collect(Collectors.toList());
		sortedByRuns.forEach(System.out::println);
		
		
		System.out.println("Batsman sorted by Strike rate:");
		List<CricketLeague> sortedByStrikeRate=list.stream().sorted(Comparator.comparingInt(CricketLeague::getStrikeRate)).collect(Collectors.toList());
		sortedByStrikeRate.forEach(System.out::println);

	}

}