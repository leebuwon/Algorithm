package baekjoon.brz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        solution(A, B, C, M);
    }

    private static void solution(int a, int b, int c, int m) {
        // 1 시간 단위로 일을 해야함 (1시간 일하면 피로도가 A만큼 쌓임, 그리고 B만큼 일을 할 수 있음)
        // 하지만 M만큼 넘으면 쉬어야함
        // M이 넘는다면 1시간을 쉬어서 C만큼 시간을 줄일 수 있음

        // 현재 일한 시간
        int workTime = 0;
        int realWorkTime = 0; // 진자로 일한 시간!

        // 하루에 24시간 일할 수 있음
        for(int i = 0; i < 24; i++) {
            // 일단 계속 a를 더해줌
            workTime += a;

            // 만약에 workTiem이 M을 넘는다면 이미 과부하가 발생(이럴경우 a를 빼주고 c를 더 빼줌!)
            // 그리고 시간은 당연히 흘러감 (왜냐 쉬는시간으로 1시간을 허비했기 때문임)

            // 1 = 5
            // 2 = 10
            // 3 = 15
            if(workTime > m) {
                workTime -= a;
                workTime -= c;

                // workTime이 음수일 경우에는 0으로 값 초기화
                if(workTime < 0) {
                    workTime = 0;
                }
            } else {
                realWorkTime += b;
            }
        }

        System.out.println(realWorkTime);
    }
}
