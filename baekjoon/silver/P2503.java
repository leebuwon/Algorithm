import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> conditions = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            conditions.add(new int[]{num, strike, ball});
        }

        solution(conditions);
    }

    private static void solution(ArrayList<int[]> conditions) {
        ArrayList<Integer> possibleNumbers = new ArrayList<>();
        for (int i = 100; i <= 999; i++) {
            int num1 = i / 100;
            int num2 = (i / 10) % 10;
            int num3 = i % 10;

            if (num2 == 0 || num3 == 0 || num1 == num2 || num1 == num3 || num2 == num3) {
                continue;
            }

            boolean isValid = true;
            for (int[] condition : conditions) {
                int condNum = condition[0];
                int condStrike = condition[1];
                int condBall = condition[2];

                if (!find(num1, num2, num3, condNum, condStrike, condBall)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                possibleNumbers.add(i);
            }
        }

        System.out.println(possibleNumbers.size());
    }


    private static boolean find(int num1, int num2, int num3, int num, int strike, int ball) {
        int a = num / 100;
        int b = (num / 10) % 10;
        int c = num % 10;

        int strikeCount = 0;
        int ballCount = 0;

        if (num1 == a) strikeCount++;
        if (num2 == b) strikeCount++;
        if (num3 == c) strikeCount++;

        if (num1 == b || num1 == c) ballCount++;
        if (num2 == a || num2 == c) ballCount++;
        if (num3 == a || num3 == b) ballCount++;

        return strikeCount == strike && ballCount == ball;
    }
}
