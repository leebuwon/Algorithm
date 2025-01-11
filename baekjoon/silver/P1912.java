import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int solution = solution(arr);
        System.out.println(solution);
    }

    private static int solution(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(sum < arr[i]) {
                sum = 0;
                sum += arr[i];
            }

            if(maxSum <= sum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }
}
