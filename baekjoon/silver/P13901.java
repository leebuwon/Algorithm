package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P13901 {
    static int r;
    static int c;
    static int[][] map;
    // 장애물 갯수
    static int k;
    // 장애물 위치
    static int[][] block;
    // 시작 위치
    static int sr;
    static int sc;
    //  1은 위 방향, 2은 아래 방향, 3은 왼쪽 방향, 4는 오른쪽 방향을 나타낸다
    static int[] dir;
    static boolean[][] visited;
    static boolean[] success;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new boolean[r][c];

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        block = new int[k][2];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            block[i][0] = Integer.parseInt(st.nextToken());
            block[i][1] = Integer.parseInt(st.nextToken());

            map[block[i][0]][block[i][1]] = 1;
        }

        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());

        dir = new int[4];
        success = new boolean[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            dir[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        int count = 0;
        while (true) {
            int nowDir = dir[count];
            move(sr, sc, nowDir);

            if(count == 3 && !success[0] && !success[1] && !success[2] && !success[3]) {
                break;
            }

            // 모든 방향을 순회했으면 처음으로 돌아가기!
            if(count == 3) {
                success = new boolean[4];
                count = 0;
                continue;
            }
            count++;
        }

        System.out.println(sr + " " + sc);
    }

    private static void move(int y, int x, int nowDir) {
        visited[y][x] = true;
        while (true) {
            int ny = y + dy[nowDir];
            int nx = x + dx[nowDir];

            // 범위를 벗어날 경우 break
            if(ny < 0 || nx < 0 || ny >= r || nx >= c) {
                break;
            }

            // 벽을 만날 경우 break
            if(map[ny][nx] == 1) {
                break;
            }

            // 방문했을 경우 break
            if(visited[ny][nx]) {
                break;
            }

            success[nowDir] = true;
            visited[ny][nx] = true;
            y = ny;
            x = nx;
            sr = ny;
            sc = nx;
        }
    }
}
