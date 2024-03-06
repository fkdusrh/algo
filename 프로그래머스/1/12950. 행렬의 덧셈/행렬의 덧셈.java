class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int [arr1.length][arr1[0].length];
        for(int row = 0;row<arr1.length;row++){
            for(int col=0;col<arr1[0].length;col++){
                answer[row][col]=arr1[row][col] + arr2[row][col];
            }
        }

        return answer;
    }
}