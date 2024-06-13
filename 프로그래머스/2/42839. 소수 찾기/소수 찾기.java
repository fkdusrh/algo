import java.util.HashSet;
import java.util.Set;

class Solution {
    private Set<Integer> numberSet = new HashSet<>();

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        int limit = (int) Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void generateCombinations(String combination, String remaining) {
        if (!combination.isEmpty()) {
            numberSet.add(Integer.parseInt(combination));
        }
        for (int i = 0; i < remaining.length(); i++) {
            generateCombinations(combination + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1));
        }
    }

    public int solution(String numbers) {
        numberSet.clear();
        generateCombinations("", numbers);
        
        int count = 0;
        for (int number : numberSet) {
            if (isPrime(number)) {
                count++;
            }
        }
        return count;
    }
}
