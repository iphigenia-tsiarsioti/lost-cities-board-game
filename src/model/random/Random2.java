package model.random;

import java.util.Random;

public class Random2 {
	
		public static int getRandomVal(int min, int max) {
	        Random rand = new Random();
	        int n = rand.nextInt(max - min + 1) + min;
	        if(n==8)	return n;
	        if(n%2==0)  return n+1;
	        return n;
	    }
	

}
