class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        
        double sum = 0;
        double[] rank = new double[score.length];
        for(int i = 0; i < score.length; i++) {
            sum = score[i][0] + score[i][1];
            
            sum = sum / 2;
            
            rank[i] = sum;
            
            sum = 0;
        }
        
        for(int i = 0; i < rank.length; i++) {
            int ranker = 1;
            double current = rank[i];
            for(int j = 0; j < rank.length; j++) {
                if(current < rank[j]) {
                    ranker++;
                }
            }
            
            answer[i] = ranker;
        }
        
        
        
        return answer;
    }
}
