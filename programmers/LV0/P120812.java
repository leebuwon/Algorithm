import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> maps = new HashMap<>();
        
        for(int i = 0; i < array.length; i++){
            maps.put(array[i], maps.getOrDefault(array[i], 0) + 1);
        }
        
        int max = Integer.MIN_VALUE;
        int maxCount = 0;
        
        for(int key : maps.keySet()) {
            int value = maps.get(key);
            
            if(value > max) {
                max = value;
                answer = key;
                maxCount = 1;
            } else if(value == max) {
                maxCount++;
            }
        }
        
        if(maxCount > 1) {
            return -1;
        }
        
        return answer;
    }
}
