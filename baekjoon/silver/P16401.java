package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16401 {
    static int m;
    static int n;
    static int[] snack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        snack = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snack);


        // 중앙값 구하기
        int left = 1;
        int right = snack[n - 1];
        int optimizationSnackLength = 0;

        // 초기 또는 끝까지 갔을 경우 0으로 while문 끝내기
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
        while (left <= right) {
            int middle = (left + right) / 2; // 매번 중간값을 갱신
            int count = 0;

            // 중간값으로 잘랐을 때 나오는 과자의 갯수
            for(int i = 0; i < n; i++) {
                count += snack[i] / middle;
            }

            if(count < m) {
                // 만약 count가 조카보다 적을 경우 -> 잘 나눠지지 못한 값임 -> rigt를 더 작게해서 중앙 값을 작게함
                right = middle - 1;
            } else {
                // 만약 count가 조카보다 많을 경우 -> 최대 깅리의 과자 막대를 구하지 못한 값임
                // -> 조카들에게 과자를 나눠줄 수 있는 상황이지만 최적은 아닐수도있어서 optimizationSnackLength 계속 초기화
                left = middle + 1;
                optimizationSnackLength = middle;
            }
        }

        System.out.println(optimizationSnackLength);

        // 만약에 과자가 조카보다 많을 경우 정렬해줘서 뒤에서 조카수만큼 긴 과자 막대를 주면됨
//        if(m <= n) {
//            System.out.println(snack[snack.length - m]);
//        } else {
//            // 5 3
//            // 10 10 24 -> 44 / 5 = 8
//            // 8 8 8 8 8
//
//            // 4 3
//            // 10 10 15
//            // 35 -> 4 // 8
//            // 근데 가장 큰값에서 15 - 8하면 반으로 쪼갠것보다 커서 안됨
//
//            // 4 3
//            // 9 9 9 -> 27 / 4 = 5
//
//            // 모든 길이의
//            sum /= m;
//            // 만약 모든 값을 합친 값을 조카 수로 나눈 값보다 가장 짧은 과자 막대의 값이 작을 경우
//            if(sum > snack[0]) {
//                // 가장 짧은 값 리턴
//                System.out.println(snack[0]);
//            } else {
//                // 우선 가장 큰 값이 딱 떨어지는 판단
//                if(snack[n - 1] % sum != 0) {
//                    // 만약 홀수가 아닐 경우 딱 맞아 떨어지지 않기 때문에 1을 빼준다.
//                    sum--;
//                }
//                System.out.println(sum);
//            }
//        }
    }
}
