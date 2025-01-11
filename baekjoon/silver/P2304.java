import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int solution = solution(arr);
        System.out.println(solution);
    }

    private static int solution(int[][] arr) {
        int answer = 0;

        // 가로를 기준으로 정렬
        Arrays.sort(arr, Comparator.comparing(o -> o[0]));

        // 가장 높은 기둥의 크기와 인덱스 위치
        int maxPillarIndex = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(maxPillarIndex <= arr[i][1]){
                maxPillarIndex = arr[i][1];
                index = i;
            }
        }

        // 가장 높은 기둥 왼쪽의 창고 크기
        int startLeftDistance = arr[0][0];
        int startLeftPillar  = arr[0][1];
        for(int i = 1; i <= index; i++){
            // 왼쪽의 가장 큰 기둥 기억하기
            if(arr[i][1] >= startLeftPillar){
                answer += (arr[i][0] - startLeftDistance) * startLeftPillar;
                startLeftDistance = arr[i][0];
                startLeftPillar = arr[i][1];
            }
        }

        // 가장 높은 기둥 오른쪽의 창고 크기
        int startRightDistance = arr[arr.length - 1][0];
        int startRightPillar = arr[arr.length - 1][1];
        for(int i = arr.length - 1; i >= index; i--){
            if(arr[i][1] >= startRightPillar){
                answer += Math.abs(arr[i][0] - startRightDistance) * startRightPillar;
                startRightDistance = arr[i][0];
                startRightPillar = arr[i][1];
            }
        }

        return answer + maxPillarIndex;
    }
}
