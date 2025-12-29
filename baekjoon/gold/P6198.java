package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6198 {
    static int n;
    static int[] building;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        building = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            building[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(building[i] > building[j]) {
                    count++;
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
