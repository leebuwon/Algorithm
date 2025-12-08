package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16234 {
    static int n;
    static int l;
    static int r;
    static int[][] population;
    static boolean[][] visited;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        population = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int totalDay = 0;
        while (true) {
            visited = new boolean[n][n];
            boolean isMoved = false;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        int moveDay = bfs(i, j);
                        if(moveDay == 1) {
                            isMoved = true;
                        }
                    }
                }
            }

            if(!isMoved) {
                break;
            }
            totalDay++;
        }

        System.out.println(totalDay);
    }

    private static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        int day = 0;
        int currentPopulation = population[y][x];
        int attendCountry = 1;

        List<int[]> union = new ArrayList<>();
        union.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] country = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ny = country[0] + dy[i]; // y축
                int nx = country[1] + dx[i]; // x축

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) {
                    continue;
                }

                if(visited[ny][nx]) {
                    continue;
                }

                int absDiff = Math.abs(population[country[0]][country[1]] - population[ny][nx]);

                if(l <= absDiff && r >= absDiff) {
                    day = 1;
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                    union.add(new int[]{ny, nx});
                    currentPopulation += population[ny][nx];
                    attendCountry++;
                }
            }
        }

        // 연합크기가 1이라면 참가한 나라가 없으므로 return 0;
        if(attendCountry == 1) {
            return 0;
        }

        int movePopulation = currentPopulation / attendCountry;

        for (int[] unionCountry : union) {
            population[unionCountry[0]][unionCountry[1]] = movePopulation;
        }

        return day;
    }
}
