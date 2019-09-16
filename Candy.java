package greedy2;

import java.util.Arrays;

// Time complexity : O(n) : The array candies of size n is traversed twice.

// Space complexity : O(n) : An extra array candies of size n is used.

public class Candy {
	public int candy(int[] ratings) {
        int r = ratings.length;
        if(r == 0) return 0;
        if(r == 1) return 1;
        int[] candies = new int[ratings.length];
        
        // fill whole array by default value 1
        Arrays.fill(candies, 1);
        // start from second child and compare to previous one
        for(int i = 1; i < r; i++) {
            // if rating of previous child is less, increase rating of current child by 1
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // initialize sum with candies obtained by last chile
       int sum = candies[r - 1];
        // iterate from second last child and compare next one
        for(int i = r - 2; i >= 0; i--) {
            // if rating of next child is less, take max between his 'current candies' and 'candies incremented by 1'
            if(ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
            sum += candies[i];
        }
        return sum;
    }
}
