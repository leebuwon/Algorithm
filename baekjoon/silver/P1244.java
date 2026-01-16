package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1244 {
    static int n;
    static int[] arr;
    static int m;
    static int[][] student;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        student = new int[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            student[i][0] = Integer.parseInt(st.nextToken());
            student[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            if(student[i][0] == 1) {
                // 남자
                int count = 1;
                while ((student[i][1] * count) - 1 < n) {
                    int next = (student[i][1] * count) - 1;
                    if(arr[next] == 1) {
                        arr[next] = 0;
                    } else {
                        arr[next] = 1;
                    }
                    count++;
                }
            } else {
                int center = student[i][1] - 1;
                int left = center;
                int right = center;

                while (left - 1 >= 0 && right + 1 < n) {
                    if (arr[left - 1] != arr[right + 1]) {
                        break;
                    }
                    left--;
                    right++;
                }

                for (int j = left; j <= right; j++) {
                    if(arr[j] == 1) {
                        arr[j] = 0;
                    } else {
                        arr[j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");

            if(count % 20 == 0) {
                sb.append("\n");
                count = 1;
            }

            count++;
        }

        System.out.println(sb.toString());
    }
}
