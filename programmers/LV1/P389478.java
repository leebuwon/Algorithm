import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int height = 0; // 높이
        
        if(n % w == 0) { // 담을 높이 계산
            height = n / w;
        } else {
            height = n / w + 1;
        }
        
        int[][] arr = new int[height][w]; // 담을 배열
        
        int box = 1;
        int start = 0;
        int idx = 0;
        for(int i = 0; i < height; i++) {
            if(i % 2 == 0) { // 짝수일경우는 왼쪽부터
                for(int j = 0; j < w; j++){
                    if(box == num) {
                        start = i;
                        idx = j;
                    }
                    arr[i][j] = box;
                    box++;
                    if(box == n + 1) {
                        break;
                    }
                }
                
            } else { // 홀수일경우는 오른쪽부터
                for(int j = w - 1; j >= 0; j--){
                    if(box == num) {
                        start = i;
                        idx = j;
                    }
                    arr[i][j] = box;
                    box++;
                    if(box == n + 1) {
                        break;
                    }
                }
            }
        }

        // NUM 상자의 위치와 현재 상자의 높이를 뺴줘서 몇개를 뺴줘야하는지 구한다.
        height = height - 1;
        if(arr[height][idx] == 0) {
            answer = height - start;
        } else {
            answer = height - start + 1;
        }
        
        return answer;
    }
}
