class Solution {
    public String solution(String s) {
        String answer = "";
        
        int len = s.length();
        
        StringBuilder sb = new StringBuilder();
        if(len % 2 == 0) {
            len = len / 2 - 1;
            
            for(int i = len; i <= len + 1; i++) {
                sb.append(s.charAt(i));
            }
        } else {
            len = len / 2;
            sb.append(s.charAt(len));
        }
        

        answer = sb.toString();
        
        return answer;
    }
}
