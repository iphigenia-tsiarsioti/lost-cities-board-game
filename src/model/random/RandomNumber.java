package model.random;

import java.util.Random;

public class RandomNumber {
	public static int getRandomVal(int min, int max) {
        Random rand = new Random();
        int n = rand.nextInt(max - min + 1) + min;
        
        return n;
    }
}
