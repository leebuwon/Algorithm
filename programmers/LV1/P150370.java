import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();

        List<String[]> list = new ArrayList<>();

        // terms에 들어있던 정보 split
        for(int i = 0; i < terms.length; i++){
            list.add(terms[i].split(" "));
        }

        // 날짜 돌아가면서 비교하기
        for(int i = 0; i < privacies.length; i++){
            String date = privacies[i];

            // List에 들어있는 알파벳과 비교하기
            for(int j = 0; j < list.size(); j++){
                if(date.charAt(date.length() - 1) == list.get(j)[0].charAt(0)) {

                    // 날짜만 subStr로 나누기
                    String dateStr = date.substring(0, 10);

                    // date 더해주기
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
                    LocalDate localDate = LocalDate.parse(dateStr, formatter);
                    LocalDate newDate = localDate.plusMonths(Long.parseLong(list.get(j)[1])).minusDays(1);

                    // 비교할 날짜 타입 변경
                    LocalDate todayDate = LocalDate.parse(today, formatter);

                    // 파기해야할 정보 저장
                    if(todayDate.isAfter(newDate)){
                        answerList.add(i + 1);
                    }
                    break;
                }
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
