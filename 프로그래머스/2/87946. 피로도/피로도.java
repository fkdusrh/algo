class Solution {
    static boolean[] explored;
    static int maxDepth = 0;

    public int solution(int k, int[][] dungeons) {
        explored = new boolean[dungeons.length];
        searchDungeons(0, k, dungeons);
        return maxDepth;
    }

    private void searchDungeons(int depth, int currentFatigue, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (explored[i] || dungeons[i][0] > currentFatigue) {
                continue;
            }
            explored[i] = true;
            searchDungeons(depth + 1, currentFatigue - dungeons[i][1], dungeons);
            explored[i] = false;
        }
        maxDepth = Math.max(maxDepth, depth);
    }
}
