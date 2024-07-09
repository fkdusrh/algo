import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalFatigue = 0;

        int diamondPicks = picks[0];
        int ironPicks = picks[1];
        int stonePicks = picks[2];

        int totalPicks = diamondPicks + ironPicks + stonePicks;
        int totalMinerals = minerals.length;

        int[][] mineralFatigueGroups = new int[totalPicks][6];

        for (int i = 0; i < Math.min(totalPicks * 5, totalMinerals); i += 5) {
            int groupFatigue = 0;

            for (int j = i; j < Math.min(i + 5, totalMinerals); j++) {
                int fatigue = 0;
                if (minerals[j].equals("diamond")) {
                    fatigue = 25;
                } else if (minerals[j].equals("iron")) {
                    fatigue = 5;
                } else if (minerals[j].equals("stone")) {
                    fatigue = 1;
                }

                groupFatigue += fatigue;
                mineralFatigueGroups[i / 5][j % 5 + 1] = fatigue;
            }

            mineralFatigueGroups[i / 5][0] = groupFatigue;
        }

        Arrays.sort(mineralFatigueGroups, (a, b) -> b[0] - a[0]);

        for (int i = 0; i < totalPicks; i++) {
            int[] group = mineralFatigueGroups[i];
            String pickType;

            if (diamondPicks > 0) {
                diamondPicks--;
                pickType = "diamond";
            } else if (ironPicks > 0) {
                ironPicks--;
                pickType = "iron";
            } else if (stonePicks > 0) {
                stonePicks--;
                pickType = "stone";
            } else {
                break;
            }

            // Calculate fatigue based on the pick type using if-else
            for (int j = 1; j < 6; j++) {
                if (pickType.equals("diamond")) {
                    totalFatigue += (int) Math.ceil(group[j] / 25.0);
                } else if (pickType.equals("iron")) {
                    totalFatigue += (int) Math.ceil(group[j] / 5.0);
                } else if (pickType.equals("stone")) {
                    totalFatigue += group[j];
                }
            }
        }
        return totalFatigue;
    }
}
