class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        
        int length = pat.length();
        
        for (int i = myString.length(); i >= 0; i--) {
            if (i >= length && myString.substring(i - length, i).equals(pat)) {
                answer = myString.substring(0, i);
                break;
            }
        }

        return answer;
    }
}
