class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 접은 횟수 cnt
        int cnt = 0;
        
        
        int width = bill[0]; // 가로
        int length = bill[1]; // 세로
        
        // 무한루프
        while(true) {
            
            // 그대로 넣었을 경우
            if(wallet[0] >= width && wallet[1] >= length) {
                break;   
            }
            
            // 90도로 돌려서 넣었을 경우
            if(wallet[0] >= length && wallet[1] >= width) {
                break;   
            }
            
            // 만약에 통과하지 못한다면 반으로 줄이고 cnt++
            if(width > length) {
                width = width / 2;
            } else {
                length = length / 2;
            }
            
            cnt++;
        }
        
        answer = cnt;
        
        return answer;
    }
}
