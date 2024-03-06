class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = m;
        int min = n;
        if (n > m) {
            max = n;
            min = m;
        }

        for (int i = min; i >= 1; i--) {
            if (min % i == 0 && max % i == 0) {
                answer[0] = i;
                break;
            }
        }

        int productMin=min;
        int productMax = max;

        if (max % min == 0) {
            answer[1] = max;
        } else {
            while (productMax != productMin) {
                if (productMin < productMax) {
                    productMin += min;
                    continue;
                }
                productMax += max;
            }
            answer[1]=productMax;

        }
        return answer;
    }
}