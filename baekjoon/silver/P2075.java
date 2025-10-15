package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2075 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

//        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
//                list.add(Integer.parseInt(st.nextToken()));
//                dq.add(Integer.parseInt(st.nextToken()));
//                arr[i][j] = Integer.parseInt(st.nextToken());

//                if(i < n - 2) {
//                    qp.poll();
//                }
            }
        }

//        for(int i = arr.length - 1; i >= 3; i--) {
//            for(int j = 0; j < arr[i].length; j++) {
//                pq.add(arr[i][j]);
//            }
//        }

        while(n != 1) {
            pq.poll(); //
            n--;
        }

        System.out.println(pq.poll());

//        dq.stream().sorted().limit(n).forEach(System.out::println);
//
//        System.out.println(dq);

        //        Integer poll = pq.poll();

        // 메모리 초과
//        list.sort(Collections.reverseOrder());
//        System.out.println(list.get(n - 1));


    }
}
