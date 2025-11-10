package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667 {
    static int n;
    static int[][] rectangle;
    static boolean[][] visited;
    static int totalCnt;
    static int cnt;
    static List<Integer> answerList = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        rectangle = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                rectangle[i][j] = Integer.parseInt(line[j]);
            }
        }

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                // 처음발견된 1일 경우!
                if(rectangle[y][x] == 1 && !visited[y][x]) {
                    cnt++;
                    visited[y][x] = true;
                    dfs(y, x);
                    answerList.add(cnt);
                    cnt = 0;
                }
            }
        }

        Collections.sort(answerList);

        System.out.println(answerList.size());
        for (Integer num : answerList) {
            System.out.println(num);
        }
    }

    private static void dfs(int y, int x) {

        // 상화좌우 4번 탐색하기 위해서 4번만큼 탐색!
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }

            if (rectangle[ny][nx] == 1 && !visited[ny][nx]) {
                cnt++;
                visited[ny][nx] = true;
                dfs(y + dy[i], x + dx[i]);
            }
        }
    }
}
