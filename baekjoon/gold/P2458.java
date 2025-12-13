package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2458 {
    static int n;
    static int m;
    static int[] students;
    static boolean[] visited;
    static List<List<Integer>> higher = new ArrayList<>();
    static List<List<Integer>> lower = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        students = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            higher.add(new ArrayList<>());
            lower.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            higher.get(a).add(b);
            lower.get(b).add(a);
        }

        for(int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            higherBfs(i);
            lowerBfs(i);
        }

        int count = 0;
        for (int student : students) {
            if(student == n - 1) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void higherBfs(int currentStudent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentStudent);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer higherStudent : higher.get(now)) {
                if (visited[higherStudent]) {
                    continue;
                }

                students[currentStudent]++;
                queue.add(higherStudent);
                visited[higherStudent] = true;
            }
        }
    }

    private static void lowerBfs(int currentStudent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentStudent);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (Integer lowerStudent : lower.get(now)) {
                if (visited[lowerStudent]) {
                    continue;
                }

                students[currentStudent]++;
                queue.add(lowerStudent);
                visited[lowerStudent] = true;
            }
        }
    }
}
