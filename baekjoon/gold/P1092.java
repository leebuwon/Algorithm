package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1092 {
    static int n;
    static Integer[] crane;
    static int m;
    static Integer[] box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        crane = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        box = new Integer[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(crane, Collections.reverseOrder());
        Arrays.sort(box, Collections.reverseOrder());

        if (box[0] > crane[0]) {
            System.out.println(-1);
            return;
        }

        boolean[] visited = new boolean[m];
        int moved = 0;
        int time = 0;

        while (moved < m) {
            int boxIdx = 0;
            for (int i = 0; i < n ; i++) {
                if(boxIdx == m) {
                    break;
                }
                for(int j = 0; j < m; j++) {
                    if(boxIdx >= m) {
                        break;
                    }

                    if (!visited[boxIdx] && crane[i] >= box[boxIdx]) {
                        visited[boxIdx] = true;
                        moved++;
                        boxIdx++;
                        break;
                    }
                    boxIdx++;
                }
            }
            time++;
        }

        System.out.println(time);
    }
}
