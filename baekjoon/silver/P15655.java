import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solution(arr, new int[m], 0, 0, m);
    }

    // 풀이 방법 참고
    private static void solution(int[] arr, int[] temp, int depth, int start, int m) {
        if (depth == m) {
            for (int num : temp) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            temp[depth] = arr[i];
            solution(arr, temp, depth + 1, i + 1, m);
        }
    }
}
