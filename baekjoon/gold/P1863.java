package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class P1863 {
    static int n;
    static int[][] skyLine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        skyLine = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            skyLine[i][0] = Integer.parseInt(st.nextToken());
            skyLine[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(skyLine, Comparator.comparingInt(a -> a[0]));

        Stack<Integer> stack = new Stack<>();

        int buildingCount = 0;
        for(int i = 0; i < n; i++) {
            int cp = skyLine[i][0];
            int height = skyLine[i][1];

            if(stack.isEmpty() && height != 0) {
               stack.push(height);
               continue;
            }

            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
                buildingCount++;
            }

            if(height > 0 && (stack.isEmpty() || stack.peek() < height)) {
                stack.push(height);
            }
        }

        System.out.println(buildingCount + stack.size());
    }
}
