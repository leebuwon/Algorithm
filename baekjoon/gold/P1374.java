package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1374 {
    static int n;
    static Integer[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new Integer[n][4];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 필요한 강의실의 수
        int classCount = 0;

        // 강의 시작시간으로 오름차순 정렬
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

        // 강의 번호, 강의 시작 시간, 강의 종료 시간
        // 한 강의실에서는 동시에 2개 이상의 강의를 진행할 수 없고, 한 강의의 종료시간과 다른 강의의 시작시간이 겹치는 것은 상관없다.

        // [3, 2, 14] : 강의실 1 -> [7, 20, 25] : 강의실 1
        // [1, 3, 8]  : 강의실 2 -> [4, 12, 18] : 강의실 2
        // [8, 6, 27] : 강의실 3
        // [5, 6, 20] : 강의실 4 -> [7, 20, 25] : 강의실 4 (1도 사용가능하고 4도 사용가능함, 근데 먼저끝난걸 사용하는게 좋을거같음!)
        // [2, 7, 13] : 강의실 5 -> [6, 15, 21] : 강의실 5

        // [[3, 2, 14], [1, 3, 8], [8, 6, 27], [5, 6, 20], [2, 7, 13], [4, 12, 18], [6, 15, 21], [7, 20, 25]]
        Queue<Integer> queue = new PriorityQueue<>();

        // 강의실 번호도 기억을 해줘야함...
        for(int i = 0; i < n - 1; i++) {

            // 만약 가장 먼저 끝나는 강의보다 시작 시간이 같거나 느릴경우 deque에서 가장 빨리 끝나는 강의실을 뺴주고 넣어주기!
            if(!queue.isEmpty() && queue.peek() <= arr[i][1]) {

                // 빼주면서 넣어주기!
                queue.poll();
                queue.add(arr[i][2]);
                continue;
            }

            // 첫번쨰 강의 끝나는 시간이 다음 강의 시작시간 보다 늦게 끝난다면 강의실 하나 추가 !
            if(arr[i][2] > arr[i + 1][1]) {
                // 끝나는 시간 넣어주기!
                queue.add(arr[i][2]);
            }
        }

        if(!queue.isEmpty() && queue.peek() <= arr[n - 1][1]) {
            queue.poll();
            queue.add(arr[n - 1][2]);
        } else {
            queue.add(arr[n - 1][2]);
        }

        System.out.println(queue.size());

    }
}
