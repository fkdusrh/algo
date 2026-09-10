class Solution {
    int[] numbers;
    int target;
    boolean[] visit;
    int cnt = 0;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        visit = new boolean[numbers.length];
        
        dfs(0, 0);
        return cnt;
    }
    void dfs(int depth, int sum){
        if(depth == numbers.length){
            if(sum == target){
                cnt++;
            }
            return;
        }
        
        dfs(depth+1, sum + numbers[depth]);
        dfs(depth+1, sum - numbers[depth]);
    }
}