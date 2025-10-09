package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 시간 초과
        // 시간초과 원인은 System.out.println()이 매우 느림
        // 콘솔(표준 출력 스트림) 에 접근해서 -> 버퍼를 비우고(flush) → 한 줄씩 출력
//        for (int num : arr) {
//            System.out.println(num);
//        }

        // 삽입 정렬은 O(n^2) 으로 해결이 안됨 -> 시간 초과
//        int tmp = 0;
//        for(int i = 1; i < n; i++) {
//            tmp = arr[i];
//            for(int j = i - 1; j >= 0; j--) {
//                if(arr[j] > tmp) {
//                    arr[j + 1] = arr[j];
//                } else {
//                    break;
//                }
//
//                arr[j] = tmp;
//            }
//        }



        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            // append는 메모리 내부 연산이기 때문에 거의 즉시 처리
            //
            sb.append(num).append("\n");
        }

        // 마지막에 System.out.print() 한 번만 I/O 발생
        System.out.print(sb);
    }
}
