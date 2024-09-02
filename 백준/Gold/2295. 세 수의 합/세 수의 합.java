import java.util.*;

public class Main {
    static int elementCount;
    static int[] elements;
    static List<Integer> pairSums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elementCount = scanner.nextInt();
        elements = new int[elementCount];
        int maximum = 0;

        for (int i = 0; i < elementCount; i++) {
            elements[i] = scanner.nextInt();
        }

        pairSums = new ArrayList<>();
        for (int i = 0; i < elementCount; i++) {
            for (int j = 0; j < elementCount; j++) {
                pairSums.add(elements[i] + elements[j]);
            }
        }

        Arrays.sort(elements);
        Collections.sort(pairSums);

        for (int i = elementCount - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int difference = elements[i] - elements[j];

                if (binarySearch(difference) && elements[i] > maximum) {
                    maximum = elements[i];
                }
            }
        }

        System.out.println(maximum);
    }

    static boolean binarySearch(int target) {
        int start = 0;
        int end = pairSums.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (pairSums.get(mid) == target) {
                return true;
            }

            if (pairSums.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
