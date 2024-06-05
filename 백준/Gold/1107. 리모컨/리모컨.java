import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetChannel = scanner.nextInt();
        int brokenCount = scanner.nextInt();

        Set<Integer> brokenButtons = new HashSet<>();
        for (int i = 0; i < brokenCount; i++) {
            brokenButtons.add(scanner.nextInt());
        }

        int minPressCount = Math.abs(100 - targetChannel);

        for (int i = 0; i <= 999999; i++) {
            String strChannel = String.valueOf(i);
            if (canPressChannel(strChannel, brokenButtons)) {
                int pressCount = strChannel.length() + Math.abs(i - targetChannel);
                if (pressCount < minPressCount) {
                    minPressCount = pressCount;
                }
            }
        }

        System.out.println(minPressCount);
    }

    private static boolean canPressChannel(String channel, Set<Integer> brokenButtons) {
        for (char ch : channel.toCharArray()) {
            if (brokenButtons.contains(ch - '0')) {
                return false;
            }
        }
        return true;
    }
}
