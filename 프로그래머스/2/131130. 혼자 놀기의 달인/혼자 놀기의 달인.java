import java.util.*;class Solution {
        public int solution(int[] cards) {
            List<Integer> cycles = findCycle(cards);

            if (cycles.size() == 0)
                return 0;

            Collections.sort(cycles, Collections.reverseOrder());
            return cycles.get(0) * cycles.get(1);
        }

        public List<Integer> findCycle(int[] cards) {
            boolean[] isGet = new boolean[cards.length + 1];
            List<Integer> cardCountInCycle = new ArrayList<>();
            
            for (int i = 0; i < cards.length; i++) {

                int curCard = cards[i];
                if (isGet[curCard])
                    continue;

                int cnt = 0;
                int nextCard = cards[curCard - 1];

                while (true) {
                    if (isGet[nextCard])
                        break;
                    
                    isGet[nextCard] = true;
                    nextCard = cards[nextCard - 1];
                    cnt++;
                }
                if (cnt == cards.length)
                    return cardCountInCycle;

                cardCountInCycle.add(cnt);
            }
            return cardCountInCycle;
        }
    }