package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P15686 {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static List<int[]> homeLocation  = new ArrayList<>();
    static List<int[]> chickenLocation  = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 1) {
                    homeLocation.add(new int[] {i, j});
                }

                if(arr[i][j] == 2) {
                    chickenLocation.add(new int[] {i, j});
                }
            }
        }

        // 현재의 치킨집을 방문했는지 체크 (M의 치킨집 만큼 정해주기 위해)
        visited = new boolean[chickenLocation.size()];

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int depth, int idx) {
        if(depth == m) {
            int totalDist = 0;

            for (int[] home : homeLocation) {
                int homeY = home[0];
                int homeX = home[1];

                // 집마다 거리 초기화
                int dist = Integer.MAX_VALUE;

                for (int i = 0; i < chickenLocation.size(); i++) {
                    if(!visited[i]) {
                        continue;
                    }

                    int[] chicken = chickenLocation.get(i);
                    int chickenY = chicken[0];
                    int chickenX = chicken[1];

                    dist = Math.min(dist, Math.abs(homeY - chickenY) + Math.abs(homeX - chickenX));
                }
                totalDist += dist;
            }

            answer = Math.min(totalDist, answer);

            return;

        }

        for(int i = idx; i < chickenLocation.size(); i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}
