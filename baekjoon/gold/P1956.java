package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 플로이드 위셜 (블로그 참고 : https://steady-coding.tistory.com/101#google_vignette
public class P1956 {
    static int v;
    static int e;
    static int INF = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int[][] floyd = new int[v + 1][v + 1];

        for(int i = 1; i <= v; i++) {
            for(int j = 1; j <= v; j++) {
                if(i != j) {
                    floyd[i][j] = INF;
                }
            }
        }


        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            floyd[a][b] = c;
        }

        for(int k = 1; k <= v; k++) {
            for(int i = 1; i <= v; i++) {
                for(int j = 1; j <= v; j++) {
                    if(i == j) {
                        continue;
                    }

                    if(floyd[i][j] > floyd[i][k] + floyd[k][j]) {
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                    }
                }
            }
        }

        int answer = INF;
        for(int i = 1; i <= v; i++) {
            for(int j = 1; j <= v; j++) {
                if(i == j) {
                    continue;
                }

                if(floyd[i][j] != INF && floyd[j][i] != INF) {
                    answer = Math.min(answer, floyd[i][j] + floyd[j][i]);
                }
            }
        }

        if(answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
