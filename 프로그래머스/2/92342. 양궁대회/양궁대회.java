import java.util.*;

class Solution {
    static int numArrows, maxDifference;
    static int[] lionArrows;
    static int[] bestResult = {-1};

    public int[] solution(int n, int[] info) {
        numArrows = n;
        maxDifference = -1;
        lionArrows = new int[11];
        calculate(info, 0, 0);

        return bestResult;
    }
    
    private static void calculate(int[] apeach, int index, int usedArrows) {
        if(index == 11) {
            if(usedArrows == numArrows) {
                int apeachScore = 0, lionScore = 0;
                for(int i = 0; i < 11; i++) {
                    if(apeach[i] == 0 && lionArrows[i] == 0) continue;
                    if(apeach[i] >= lionArrows[i]) apeachScore += 10 - i;
                    else lionScore += 10 - i;
                }
                
                if(lionScore > apeachScore) {
                    if(lionScore - apeachScore > maxDifference) {
                        maxDifference = lionScore - apeachScore;
                        bestResult = lionArrows.clone();
                    } else if(lionScore - apeachScore == maxDifference) {
                        for(int i = 10; i >= 0; i--) {
                            if(bestResult[i] < lionArrows[i]) {
                                bestResult = lionArrows.clone();
                                return;
                            } else if(bestResult[i] > lionArrows[i]) return;
                        }
                    }
                }
            }
            return;
        }

        if(apeach[index] == 0) {
            calculate(apeach, index + 1, usedArrows);
        }

        if(usedArrows + 1 + apeach[index] <= numArrows) {
            lionArrows[index] = apeach[index] + 1;
            calculate(apeach, index + 1, usedArrows + 1 + apeach[index]);
            lionArrows[index] = 0;
        }

        if(apeach[index] != 0) {
            for(int i = 0; i <= apeach[index]; i++) {
                lionArrows[index] = i;
                calculate(apeach, index + 1, usedArrows + i);
                lionArrows[index] = 0;
            }
        }
    }
}
