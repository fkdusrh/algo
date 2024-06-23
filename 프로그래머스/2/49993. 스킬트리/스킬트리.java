class Solution {
    private boolean isSkillTreeValid(String skill, String skillTree) {
        int lastIndex = -1;
        for (char requiredSkill : skill.toCharArray()) {
            int currentIndex = skillTree.indexOf(requiredSkill);
            if (currentIndex == -1) currentIndex = Integer.MAX_VALUE;
            if (currentIndex < lastIndex) return false;
            lastIndex = currentIndex;
        }
        return true;
    }

    public int solution(String skill, String[] skill_trees) {
        int validCount = 0;
        for (String skillTree : skill_trees) {
            if (isSkillTreeValid(skill, skillTree)) {
                validCount++;
            }
        }
        return validCount;
    }
}
