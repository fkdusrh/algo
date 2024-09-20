import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < testCaseCount; i++) {
            String inputString = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                System.out.println("1 1");
                continue;
            }

            int[] charFrequency = new int[26];
            for (int j = 0; j < inputString.length(); j++) {
                charFrequency[inputString.charAt(j) - 'a']++;
            }

            int minLength = Integer.MAX_VALUE;
            int maxLength = -1;
            
            for (int j = 0; j < inputString.length(); j++) {
                if (charFrequency[inputString.charAt(j) - 'a'] < k) continue;

                int count = 1;
                for (int l = j + 1; l < inputString.length(); l++) {
                    if (inputString.charAt(j) == inputString.charAt(l)) count++;
                    if (count == k) {
                        minLength = Math.min(minLength, l - j + 1);
                        maxLength = Math.max(maxLength, l - j + 1);
                        break;
                    }
                }
            }

            if (minLength == Integer.MAX_VALUE || maxLength == -1) {
                System.out.println("-1");
            } else {
                System.out.println(minLength + " " + maxLength);
            }
        }
    }
}
