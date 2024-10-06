import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(min > arr[i]) {
                min = arr[i];
            }
        }

        List<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != min){
                arrList.add(arr[i]);
            }
        }
        
        if(arrList.size() == 0){
            return new int[]{-1};
        }
        
        int[] answer = new int[arrList.size()];
        for(int i = 0; i < arrList.size(); i++){
            answer[i] = arrList.get(i);
        }
        
        return answer;
    }
}
