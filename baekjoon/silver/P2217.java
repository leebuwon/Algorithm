package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2217 {
    static int n;
    static int[] weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        weight = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);

        int useLopeCount = 0;
        int currentWeight = 0;
        int maxWeight = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            currentWeight += weight[i];
            useLopeCount++;
            int max = currentWeight / useLopeCount;

            if(max >= weight[i]) {
                max = useLopeCount * weight[i];
            }

            maxWeight = Math.max(max, maxWeight);
        }

        System.out.println(maxWeight);
    }
}
