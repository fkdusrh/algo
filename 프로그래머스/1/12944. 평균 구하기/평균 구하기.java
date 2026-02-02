class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int sum = 0;
        for(int n:arr){
            sum += n;
        }
        return sum / (double)arr.length;
    }
}