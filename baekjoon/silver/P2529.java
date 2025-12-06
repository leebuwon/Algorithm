package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2529 {
    static int k;
    static String[] str;
    static boolean[] visited;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    static String stringMin;
    static String stringMax;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        str = new String[k];
        visited = new boolean[10];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            str[i] = st.nextToken();
        }

        for(int i = 0; i < 10; i++) {
            visited[i] = true;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            dfs(i, 0, sb);
            visited[i] = false;
        }

        System.out.println(stringMax);
        System.out.println(stringMin);
    }

    private static void dfs(int num, int depth, StringBuilder sb) {
        if(k == depth) {
            String finish = sb.toString();

            long answer = Long.parseLong(finish);

            if (answer > max) {
                max = answer;
                stringMax = finish;
            }

            if (answer < min) {
                min = answer;
                stringMin = finish;
            }

            return;
        }

        for(int i = 0; i < 10; i++) {
            if(visited[i]) {
                continue;
            }

            if((str[depth].equals("<") && num < i)) {
                visited[i] = true;
                sb.append(i);
                dfs(i, depth + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }

            if((str[depth].equals(">") && num > i)) {
                visited[i] = true;
                sb.append(i);
                dfs(i, depth + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
