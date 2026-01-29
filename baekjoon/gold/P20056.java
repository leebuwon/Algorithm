package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P20056 {
    static int n;
    static int m;
    static int k;
    static int[][] map;
    // 1부터 순서대로 ↑, ↗, →, ↘, ↓, ↙, ←, ↖
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static List<fireball>[][] fireballs;

    static class fireball {
        int y;
        int x;
        int m;
        int s;
        int d;

        public fireball(int y, int x, int m, int s, int d) {
            this.y = y;
            this.x = x;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        @Override
        public String toString() {
            return "fireball{" +
                    "y=" + y +
                    ", x=" + x +
                    ", m=" + m +
                    ", s=" + s +
                    ", d=" + d +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        fireballs = new ArrayList[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                fireballs[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireballs[y][x].add(new fireball(y, x, m, s, d));
        }

        // 0 0 0 0
        // 0 0 0 0
        // 0 0 0 0
        // 0 0 0 0
        for(int l = 0; l < k; l++) {
            List<fireball>[][] temp  = new ArrayList[n][n];
            List<fireball>[][] next  = new ArrayList[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    temp[i][j] = new ArrayList<>();
                    next[i][j] = new ArrayList<>();
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    // temp 배열 생성

                    // 이동하기
                    for (fireball fireball : fireballs[i][j]) {
                        // gpt 참고
                        int ny = (i + dy[fireball.d] * fireball.s) % n;
                        int nx = (j + dx[fireball.d] * fireball.s) % n;

                        if (ny < 0) {
                            ny += n;
                        }

                        if (nx < 0) {
                            nx += n;
                        }

                        temp[ny][nx].add(new fireball(ny, nx, fireball.m, fireball.s, fireball.d));
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    // 만약 1개 이상의 파이어볼이 겹쳐있을 경우
                    if(temp[i][j].size() > 1) {
                        int mSum = 0;
                        int sSum = 0;
                        boolean even = false;
                        boolean odd = false;
                        for (fireball fireball : temp[i][j]) {
                            mSum += fireball.m;
                            sSum += fireball.s;

                            if(fireball.d % 2 == 0) {
                                even = true;
                            } else {
                                odd = true;
                            }
                        }

                        mSum /= 5;
                        sSum /= temp[i][j].size();

                        // 질량이 0이라면 삭제
                        if(mSum == 0) {
                            continue;
                        }

                        int[] arr = new int[4];

                        if(even && odd) {
                            arr[0] = 1;
                            arr[1] = 3;
                            arr[2] = 5;
                            arr[3] = 7;
                        } else {
                            arr[0] = 0;
                            arr[1] = 2;
                            arr[2] = 4;
                            arr[3] = 6;
                        }

                        for(int d = 0; d < 4; d++) {
                            next[i][j].add(new fireball(i, j, mSum, sSum, arr[d]));
                        }
                    } else {
                        next[i][j] = temp[i][j];
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                fireballs[i] = next[i];
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for (fireball fireball : fireballs[i][j]) {
                    answer += fireball.m;
                }
            }
        }

        System.out.println(answer);
    }
}
