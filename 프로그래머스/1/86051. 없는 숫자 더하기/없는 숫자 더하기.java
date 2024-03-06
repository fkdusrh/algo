class Solution {
    public int solution(int[] numbers) {
        int total =0;
        for(int i=1;i<=9;i++)
            total+=i;

        int existSum = 0;
        for(int i=0;i<numbers.length;i++){
            existSum += numbers[i];
        }


        return total-existSum;
    }
}