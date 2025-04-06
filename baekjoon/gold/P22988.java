import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P22988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        int solution = solution(m, arr);
        System.out.println(solution);
    }


    private static int solution(long m, long[] arr) {
        int start = 0; // 시작 위치
        int end = arr.length - 1; // 종료 위치

        double flag = (double) m / 2;

        int cosmetics = 0;
        int remainBottle = 0;
        while (start <= end) {
            // 혼자서 가득 차 있을 경우
            if(arr[end] >= m) {
                end--;
                cosmetics++;
                continue;
            }

            if(start == end) {
                remainBottle++;
                break;
            }

            // 완벽한 병이됨
            if(arr[start] + arr[end] >= flag) {
                cosmetics++;
                end--;
                start++;
                continue;
            }

            remainBottle++;
            start++;
        }

        return cosmetics + (remainBottle / 3);
    }
}
