package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P17952 {
    static int n = 0; // 과제 시간
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
            }
        }

        // n은 내가할 수 있는 과제의 시간!

        // queue 선언!
        Deque<List<Integer>> dq = new ArrayDeque<>();

        // 완료한 과제를 점수에 넣어준다.
        int score = 0;

        // 처음 과제 세팅
        for(int i = 0; i < arr.length; i++) {
            // 내가 과제를 해야할 경우
            if(arr[i][0] == 1) {
                // 과제를 넣는 순간 한것으로 취급하기 때문에 -1
                dq.add(Arrays.asList(arr[i][1], arr[i][2] - 1));

                if(dq.getLast().get(1) == 0) {
                    score += Objects.requireNonNull(dq.pollLast()).get(0);
                }
            } else {
                // arr[i][0] == 0
                if(!dq.isEmpty()) {
                    List<Integer> list = dq.peekLast();
                    list.set(1, list.get(1) - 1);

                    if(list.get(1) == 0) {
                        score += dq.pollLast().get(0);
                    }
                }

            }
            n--;
        }


        while (n != 0 && !dq.isEmpty()) {
            // 만약에 과제를 다한 경우에는 마지막에 있는 값 제거!
            if(dq.getLast().get(1) == 0) {
                score += dq.pollLast().get(0);
                continue;
            }

            if(dq.getLast().get(1) != 0) {
                // queue를 뽑아주고 값을 마지막 인자값에 1 마이너스 !
                List<Integer> newList = new ArrayList<>();
                List<Integer> list = dq.pollLast();
                newList.add(list.get(0));
                newList.add(list.get(1) - 1);
                dq.add(newList);
            }

            n--; // n = 0
        }

        if(!dq.isEmpty() && dq.getLast().get(1) == 0) {
            score += dq.pollLast().get(0);
        }

        System.out.println(score);
    }
}
