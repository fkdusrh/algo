import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        int[] currentStages = new int[N + 2];
        int[] biggerCnt = new int[N + 2];

        Arrays.sort(stages);

        for (int j = 1; j < N + 1; j++)
            for (int i = 0; i < stages.length; i++) {

                if(j==stages[i])
                    currentStages[j]++;

                if (j <= stages[i])
                    biggerCnt[j]++;

            }

        double[] fail = new double[N + 2];

        for (int i = 1; i < N+1; i++) {
             if(biggerCnt[i]==0){
                fail[i-1]=0;
                continue;
            }
            fail[i-1] = (double) currentStages[i] / biggerCnt[i];
        }


        int[] failStages = new int[N];

        for (int i = 0; i < N; i++) {
            int maxIdx = 0;
            for (int j = 0; j < N; j++) {
                if (fail[maxIdx] < fail[j])
                    maxIdx = j;


            }
            failStages[i] = maxIdx+1;
            fail[maxIdx]=-1;
        }
        return failStages;
    }
}