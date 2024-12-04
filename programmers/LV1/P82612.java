class Solution {
    public long solution(long price, long money, long count) {
        long totalPrice = 0;
        for(long i = 1; i <= count; i++) {
            totalPrice += price * i;
        }
        
        if(totalPrice - money <= 0) {
            return 0L;
        }
        
        return totalPrice - money;
    }
}
