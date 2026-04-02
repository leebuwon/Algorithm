package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P15723 {
    static int n;
    static String[] nStr;
    static int m;
    static Character[][] mStr;
    static List<List<Character>> graph = new ArrayList<>();
    // 그래프 문제같은데
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        nStr = new String[n];

        // a b c g
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            nStr[i] = line;
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        mStr = new Character[m][2];
        for(int i = 0; i < m; i++) {
            String line = br.readLine();
            mStr[i][0] = line.charAt(0);
            mStr[i][1] = line.charAt(5);
        }

        for(int i = 0; i <= 26; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            String s = nStr[i];
            int num = s.charAt(0) - 'a';
            graph.get(num).add(s.charAt(5));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            char start = mStr[i][0];
            char end = mStr[i][1];

            boolean flag = bfs(start, end);

            if(flag) {
                sb.append("T").append("\n");
            } else {
                sb.append("F").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean bfs(char start, char end) {
        List<Character> list = graph.get(start - 'a');
        Queue<Character> queue = new LinkedList<>(list);

        boolean flag = false;
        while (!queue.isEmpty()) {
            Character now = queue.poll();

            if(now.equals(end)) {
                flag = true;
                break;
            }

            List<Character> next = graph.get(now - 'a');
            queue.addAll(next);
        }

        return flag;
    }
}
