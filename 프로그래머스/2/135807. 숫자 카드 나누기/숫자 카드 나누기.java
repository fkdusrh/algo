import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = findGCD(arrayA);
        int gcdB = findGCD(arrayB);

        int resultA = checkConditions(gcdA, arrayB);
        int resultB = checkConditions(gcdB, arrayA);

        return Math.max(resultA, resultB);
    }

    private int findGCD(int[] array) {
        int gcd = array[0];
        for (int num : array) {
            gcd = gcd(gcd, num);
            if (gcd == 1) {
                return 1;  // GCD가 1이면 더 이상 진행할 필요 없음
            }
        }
        return gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int checkConditions(int gcd, int[] array) {
        // gcd의 약수들을 확인하면서 조건을 만족하는 가장 큰 값을 찾음
        for (int i = gcd; i >= 2; i--) {
            if (gcd % i == 0) {
                boolean isConditionMet = true;
                for (int num : array) {
                    if (num % i == 0) {
                        isConditionMet = false;
                        break;
                    }
                }
                if (isConditionMet) {
                    return i;
                }
            }
        }
        return 0;
    }
}
