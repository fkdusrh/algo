import java.util.*;

class Solution {
    static HashMap<String, ArrayList<Integer>> attributeScoreMap = new HashMap<>();

    public int[] solution(String[] info, String[] queries) {
        for (String candidateInfo : info) {
            generateCombinations(candidateInfo.split(" "), "", 0);
        }

        for (ArrayList<Integer> scores : attributeScoreMap.values()) {
            Collections.sort(scores);
        }

        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            results[i] = countCandidatesMatchingQuery(queries[i]);
        }

        return results;
    }

    static void generateCombinations(String[] info, String combination, int depth) {
        if (depth == 4) {
            int score = Integer.parseInt(info[depth]);
            attributeScoreMap
                .computeIfAbsent(combination, k -> new ArrayList<>())
                .add(score);
            return;
        }

        generateCombinations(info, combination + "-", depth + 1);
        generateCombinations(info, combination + info[depth], depth + 1);
    }

    static int countCandidatesMatchingQuery(String query) {
        String[] parts = query.split(" and ");
        int requiredScore = Integer.parseInt(parts[3].split(" ")[1]);
        String attributeCombination = parts[0] + parts[1] + parts[2] + parts[3].split(" ")[0];

        if (!attributeScoreMap.containsKey(attributeCombination)) {
            return 0;
        }

        ArrayList<Integer> scores = attributeScoreMap.get(attributeCombination);
        return scores.size() - findFirstScoreIndex(scores, requiredScore);
    }

    static int findFirstScoreIndex(ArrayList<Integer> scores, int targetScore) {
        int left = 0;
        int right = scores.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) >= targetScore) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
