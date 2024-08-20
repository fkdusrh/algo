class Solution {
    public int bsearch(int begin, int end, int w) { 
        int intervalLength = end - begin + 1;
        int stationsNeeded = intervalLength / (2 * w + 1);
        if (intervalLength % (2 * w + 1) != 0) {
            stationsNeeded++;
        }
        return stationsNeeded;
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int begin = 1;

        for (int i = 0; i < stations.length; i++) {
            int coverageStart = stations[i] - w;
            if (begin < coverageStart) {
                answer += bsearch(begin, coverageStart - 1, w);
            }
            begin = stations[i] + w + 1;
        }

        if (begin <= n) {
            answer += bsearch(begin, n, w);
        }

        return answer;
    }
}
