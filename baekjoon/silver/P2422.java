package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// N : 5  / M : 3
// 1 2
// 3 4
// 1 3
public class P2422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] nums = new int[m][2];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }

        solution2(n, nums);
    }

    private static void solution2(int n, int[][] nums) {
        Set<String> sets = new HashSet<>();

        // Set의 모든 경우의 수를 담기!
        for(int[] num : nums) {
            sets.add(num[0] + ", " + num[1]);
            sets.add(num[1] + ", " + num[0]);
        }

        int count = 0;
        // 탐색
        for(int i = 1; i <= n - 2; i++) {
            for(int j = i + 1; j <= n - 1; j++) {
                // 만약에 i, j 가 이미 포함되면 안되는 것들이라면 당므으로 넘어감! (for문을 최적화로 돌기)
                if(sets.contains(i + ", " + j)) {
                    continue;
                }
                // i, j 가 통과한다면 i , k / j , k 조합을 통해 포함되는 것이 잇는지 판단
                for(int k = j + 1; k <= n; k++) {
                    if(sets.contains(i + ", " + k) || sets.contains(j + ", " + k)) {
                        continue;
                    }

                    // 포함되는게 없다면 count++
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    // 잘못된 코드 이유는
    // O(1)로 해결해야하는데 현재눈 O(n^3)으로 돌아가고 있으며 마지막에 nums만큼 또 순회하기 때문에 절대 가능하지 않음
    // 즉 N = 200이고 M = 10,000 이라면 시간초과가 나옴
    // O(n^3) * 10,000 -> 시간초과
    private static void solution(int n, int[][] nums) {
        // 우선 3가지 맛을 뽑아야함
        // 근데 m의 라인에 들어가는 숫자가 포함되면 안됨!
        int count = 0;

        // 1 4 5
        // 2 3 5
        // 2 4 5
        for(int i = 1; i < n - 1; i++) {

            // j는 i를 보다 항상 1높은 수로 체크
            for(int j = i + 1; j < n; j++) {

                // k는 j보다 항상 1높은 수로 체크
                for(int k = j + 1; k <= n; k++) {
                    boolean flag = false;

                    for (int[] num : nums) {
                        int a = num[0];
                        int b = num[1];

                        if((i == a || j == a || k == a) && (i == b || j == b || k == b)) {
                            flag = true;
                            break;
                        }
                    }
                    if(!flag) {
                        count++;
                    }
                }
            }
        }


        System.out.println(count);
    }
}
