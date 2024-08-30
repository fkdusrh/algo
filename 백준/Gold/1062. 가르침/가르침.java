import java.util.*;

public class Main {

    static int n, k;
    static int maxWords = Integer.MIN_VALUE;
    static boolean[] learned;
    static String[] words;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine(); // 줄바꿈 문자 소비

        words = new String[n];
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            word = word.replace("anta", "").replace("tica", "");
            words[i] = word;
        }

        if (k < 5) { 
            System.out.println(0);
            return;
        } else if (k == 26) { 
            System.out.println(n);
            return;
        }

        learned = new boolean[26];
        learned['a' - 'a'] = true;
        learned['c' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;

        findMaximumReadableWords(0, 0);
        System.out.println(maxWords);
    }

    public static void findMaximumReadableWords(int start, int count) {
        if (count == k - 5) {
            int readableCount = 0;
            for (String word : words) {
                boolean canRead = true;
                for (int j = 0; j < word.length(); j++) {
                    if (!learned[word.charAt(j) - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) readableCount++;
            }
            maxWords = Math.max(maxWords, readableCount);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true;
                findMaximumReadableWords(i + 1, count + 1);
                learned[i] = false;
            }
        }
    }
}
