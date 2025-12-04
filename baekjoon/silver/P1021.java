package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P1021 {
    static int n;
    static int m;
    static int[] arr;
    static int[] idxArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            deque.add(i);
        }

        int count = 0;

        // 10 10
        // 1 6 3 2 7 9 8 4 10 5
        // 1 그냥빠짐
        // 10 9 8 7 6 -> count 5 // queue 10 9 8 7 2 3 4 5 -> 3의 인덱스가 바뀜..이거 인덱스 계속기억해줘야하나..
        for(int i = 0; i < m; i++) {
            int currentNum = arr[i];

            int idxCount = 0;
            int idx = 0;
            // idx 초기화
            idxArr = new int[deque.size()];
            while (!deque.isEmpty() && idxCount < deque.size()) {
                Integer num = deque.pollFirst();
                idxArr[idxCount] = num;
                if(currentNum == num) {
                    idx = idxCount;
                }
                idxCount++;
                deque.add(num);
            }

            int middle = deque.size() % 2 == 0 ? deque.size() / 2 : deque.size() / 2 + 1;

            if(idx < middle) {
                // 1번
                if(!deque.isEmpty() && deque.peekFirst() == currentNum) {
                    deque.pollFirst();
                    continue;
                }

                // 2번
                while (!deque.isEmpty()) {
                    Integer num = deque.pollFirst();
                    if(num == currentNum) {
                        break;
                    }
                    count++;
                    deque.addLast(num);
                }
            } else {
                while (!deque.isEmpty()) {
                    Integer num = deque.pollLast();
                    count++;
                    if(num == currentNum) {
                        break;
                    }
                    deque.addFirst(num);
                }
            }
        }

        System.out.println(count);

    }
}
