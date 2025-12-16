package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// GPT 참고
public class P2437 {
    static int n;
    static int[] weight;
    static boolean[] visited;
    static boolean flag;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        weight = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);

        int currentWeight = 0;
        for(int i = 0; i < n; i++) {
            if (weight[i] <= currentWeight + 1){
                currentWeight += weight[i];
            } else {
                break;
            }
        }

        System.out.println(currentWeight + 1);
    }
}
