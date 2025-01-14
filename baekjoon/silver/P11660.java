import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다시 한번 보기!
public class P11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1]; // 구간합 배열

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                sum[i][j] = arr[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
            }
        }

        int[][] input = new int[m][4];
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] results = solution(sum, input);

        // 결과 출력
        for (int num : results) {
            System.out.println(num);
        }
    }

    private static int[] solution(int[][] sum, int[][] input) {
        int[] answer = new int[input.length];

        for(int i = 0; i < input.length; i++){
            int x1 = input[i][0];
            int y1 = input[i][1];
            int x2 = input[i][2];
            int y2 = input[i][3];

            answer[i] = solution2(sum, x1, y1, x2, y2);
        }

        return answer;
    }

    private static int solution2(int[][] sum, int x1, int y1, int x2, int y2) {
        return sum[y2][x2] - sum[y2][x1-1] - sum[y1-1][x2] + sum[y1-1][x1-1];
    }
}
