class Solution {
    public long solution(int price, int money, int count) {
        long sum = 0;
        sum = (long)count * (price + price*count) / 2;
        
        return money - sum < 0? sum - money :0;
    }
}