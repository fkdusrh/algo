import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        System.out.println(Arrays.toString(d));
        int sum=0;
        int cnt=0;
        for(int i=0;i<d.length;i++){

            if(sum+d[i]>budget)
                return cnt;

            sum+=d[i];
            cnt++;
        }
        return cnt;
    }
}