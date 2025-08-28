class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        int start = startday;
        for(int i = 0; i < schedules.length; i++) {
            int schedule = schedules[i];

            schedule += 10;

            int ones = schedule % 10;
            int tens = (schedule / 10) % 10;
            int hundreds = (schedule / 100) % 10;
            int thousands = (schedule / 1000) % 10;

            if (tens >= 6) { // 10의 자리가 6보다 크면
                tens = 0;
                hundreds += 1;
            }

            if(thousands * 10 + hundreds >= 24) {
                hundreds = 0;
                thousands = 0;
            }

            int time = thousands * 1000 + hundreds * 100 + tens * 10 + ones;

            // 근무시간을 지켰는지 판단하는 로직
            boolean flag = true;
            // 날짜 초기화
            start = startday;

            // 근무시간 체크
            for(int j = 0; j < timelogs[i].length; j++) {
                // 토요일 또는 일요일일 경우 건너뛰기
                int dow = ((start - 1) % 7) + 1;
                if (dow == 6 || dow == 7) {
                    start++;
                    continue;
                }


                // 약속을 지키지 않은 경우 종료
                if(time < timelogs[i][j]) {
                    flag = false;
                    break;
                }

                if(!flag) {
                    break;
                }

                start++;
            }

            // 만약에 Flag가 true일 경우에는 약속을 모두 잘 지킨것으로 판단
            if(flag) {
                answer++;
            }
        }

        return answer;
    }
}
