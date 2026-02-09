package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P23747 {
    static int r;
    static int c;
    static String[][] map;
    static int hr;
    static int hc;
    // U, D, L, R은 각각 위, 아래, 왼쪽, 오른쪽 W는 현재위치 와드
    static String dir;
    static int[] dy = {-1, 1, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0};
    static boolean[][] visited;
    static boolean[][] light;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Character, Integer> parsing = new HashMap<>();
        parsing.put('U', 0);
        parsing.put('D', 1);
        parsing.put('L', 2);
        parsing.put('R', 3);
        parsing.put('W', 4);

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        light = new boolean[r][c];
        visited = new boolean[r][c];
        map = new String[r][c];
        for(int i = 0; i < r; i++) {
            String str = br.readLine();
            for(int j = 0; j < c; j++) {
                char c = str.charAt(j);
                map[i][j] = String.valueOf(c);
            }
        }

        st = new StringTokenizer(br.readLine());
        hr = Integer.parseInt(st.nextToken()) - 1;
        hc = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        dir = st.nextToken();

        for(int i = 0; i < dir.length(); i++) {
            char move = dir.charAt(i);
            Integer nextDir = parsing.get(move);

            if(nextDir == 4) {
                String nowFloor = map[hr][hc];
                bfs(hr, hc, nowFloor);
                continue;
            }

            myBfs(hr, hc, nextDir);
        }

        light[hr][hc] = true;
        for(int i = 0; i < 4; i++) {
            int ny = hr + dy[i];
            int nx = hc + dx[i];

            if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                continue;
            }

            light[ny][nx] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(light[i][j]) {
                    sb.append(".");
                } else {
                    sb.append("#");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    // 나의 이동방향
    private static void myBfs(int y, int x, int nextDir) {
        int ny = y + dy[nextDir];
        int nx = x + dx[nextDir];

        if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
            return;
        }

        hr = ny;
        hc = nx;
    }

    // 와드 일 경우 같은 발판은 bfs 순회
    private static void bfs(int y, int x, String nowFloor) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        light[y][x] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                // 격자를 벗어날 경우
                if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                    continue;
                }

                // 영역이 다를 경우
                if(!map[ny][nx].equals(nowFloor)) {
                    continue;
                }

                if(visited[ny][nx]) {
                    continue;
                }

                queue.add(new int[]{ny, nx});
                visited[ny][nx] = true;
                light[ny][nx] = true; // 밝힌 부분을 .으로 표시할 부분
            }
        }
    }
}
