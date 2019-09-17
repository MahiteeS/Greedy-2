package greedy2;

import java.util.HashMap;
// TC: O(n)
// SC: O(1) constant space for 26 characters in arrays solution
public class TaskScheduler {
	public static int leastInterval(char[] tasks, int n) {
	       
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxFreq = 0;
        
        for(int i = 0; i < tasks.length; i++) {
            if(map.containsKey(tasks[i])) {
                int count = map.get(tasks[i]) + 1;
                
                if(count > maxFreq) {
                    maxFreq = count;
                }
                map.put(tasks[i], count);
            }
            else {
                map.put(tasks[i], 1);
            }
        }
        
        for(int val : map.values()) {
            if(val == maxFreq) {
                maxCount++;
            }
        }
        
        int partCount = maxFreq - 1;
        int emptySlots = (n - (maxCount - 1)) * partCount;
        int availableSlots = tasks.length - (maxCount * maxFreq);
        int idle = Math.max(0, emptySlots - availableSlots);  
        
        return tasks.length + idle;
        
        /*
        int[] counter = new int[26];
        int maxCount = 0;
        int max = 0;
        
        for(char task : tasks) {
            counter[task - 'A']++;
            
            if(max == counter[task - 'A'])
            {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        int partCount = max - 1;
        int emptySlots = (n - (maxCount - 1)) * partCount;
        int availableSlots = tasks.length - (maxCount * max);
        int idle = Math.max(0, emptySlots - availableSlots);
        
        return tasks.length + idle;
        */
    }
	
	public static void main(String[] args ) {
		char[] tasks = {'A','A','A','B','B','B'};
		int n = 2;
		System.out.println(leastInterval(tasks, n)); // 8
		
	}
}
