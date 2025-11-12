package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11060 {
    static int n;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 시작 지점 추가
        int cnt = bfs();
        System.out.println(cnt);
    }

    // GPT 참고...
    private static int bfs() {
        // n이 1일 경우 더 이상 방문할 필요가 없음
        if(n == 1) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0}); // 현제 인덱스와 점프 횟수
        visited[0] = true;

        // 인덱스를 기억해줘야함! 시작하는 인덱스..
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int idx = current[0];
            int jumpCount = current[1];

            for(int i = idx + 1; i <= idx + arr[idx] && i < n; i++) {
                if (visited[i]) {
                    continue;
                }

                if(i == n - 1) {
                    return jumpCount + 1;
                }

                visited[i] = true;
                queue.add(new int[] {i, jumpCount + 1});
            }
        }

        return -1;
    }
}
