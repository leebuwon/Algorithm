package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16434 {
    static int n;
    static int H;
    static int[][] monster;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        monster = new int[n][3];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                monster[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // HMaxHP : 용사의 최대 생명력입니다.
        // HCurHP : 현재 용사의 생명력입니다.
        // HATK : 용사의 공격력입니다.

        // 용사의 공격력 HATK만큼 몬스터의 생명력을 깎습니다.
        // 몬스터의 생명력이 0 이하이면 전투가 종료되고 용사는 다음 방으로 이동합니다.
        // 몬스터의 공격력만큼 용사의 생명력 HCurHP를 깎습니다.
        // 용사의 생명력이 0 이하이면 전투가 종료되고 용사는 사망합니다.
        // 다시 1부터 진행합니다.

        long HP = 0; // 누적 데미지 (음수 누적)
        long maxHP = 0; // 지금까지 받은 최대 누적 데미지 (필요한 최대 체력)
        long HATK = H;
        for(int i = 0; i < n; i++) {
            int t = monster[i][0];

            // 3 3
            // 1 1 20 -> 3으로 7번때려야지 죽음
            // 2 3 10
            // 1 3 100

            // 몬스터방
            if(t == 1) {
                long monsterAttack = monster[i][1];
                long monsterLife = monster[i][2];

                long attackCount = (monsterLife + HATK - 1) / HATK;
                HP -= (attackCount - 1) * monsterAttack;
                maxHP = Math.min(maxHP, HP);
            }

            // 포션방
            if(t == 2) {
                long soliderAttackBonus = monster[i][1];
                long heal = monster[i][2];

                HATK += soliderAttackBonus;
                // 0을 최대 HP로 주고 HP + heal 더 클 경우 0으로 초기화
                HP = Math.min(0, HP + heal);
            }
        }

        System.out.println(Math.abs(maxHP) + 1);
    }
}
