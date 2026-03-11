package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P21736 {
    static int n;
    static int m;
    static char[][] map;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static boolean[][] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];

        int[] position = new int[2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'X') {
                    visited[i][j] = true;
                }

                if(map[i][j] == 'I') {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }

        bfs(position);

        System.out.println(answer == 0 ? "TT" : answer);
    }

    private static void bfs(int[] position) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(position);
        visited[position[0]][position[1]] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }

                if(visited[ny][nx]) {
                    continue;
                }

//                if(map[ny][nx] == 'X') {
//                    continue;
//                }

                if(map[ny][nx] == 'P') {
                    answer++;
                }

                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }
    }
}
