import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> trash = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        String[][] day = new String[privacies.length][];

        for (int i = 0; i < privacies.length; i++) {
            day[i] = privacies[i].split(" ");
        }

        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate current = LocalDate.parse(today, formatter);

        for (int i = 0; i < privacies.length; i++) {
            LocalDate date = LocalDate.parse(day[i][0], formatter);
            int period = map.get(day[i][1]);
            LocalDate expiration = date.plusMonths(period);

            if (!expiration.isAfter(current)) {
                trash.add(i + 1); 
            }
        }

        return trash.stream().mapToInt(Integer::intValue).toArray();
    }
}