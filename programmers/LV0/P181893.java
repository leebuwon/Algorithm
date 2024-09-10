import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = arr.length - 1; i >= 0; i--){
            deque.push(arr[i]);
        }

        for(int i = 0; i < query.length; i++) {
            int idx = query[i];
            // 짝수
            if(i % 2 == 0){
                int pop = (deque.size() - 1) - idx;

                while(pop > 0) {
                    deque.pollLast();
                    pop--;
                }


                // 홀수
            } else {
                while(idx > 0) {
                    deque.pollFirst();
                    idx--;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        while(!deque.isEmpty()) {
            list.add(deque.pop());
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
