import java.util.*;

public class Main {
    
    static List<Integer> resultList;
    static boolean[] isVisited;
    static int[] inputNumbers;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        inputNumbers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            inputNumbers[i] = scanner.nextInt();
        }
        
        resultList = new ArrayList<>();
        isVisited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            isVisited[i] = true;
            searchCycle(i, i);
            isVisited[i] = false;
        }
        
        Collections.sort(resultList);
        System.out.println(resultList.size());
        for (int num : resultList) {
            System.out.println(num);
        }
    }
    
    public static void searchCycle(int start, int original) {
        if (!isVisited[inputNumbers[start]]) {
            isVisited[inputNumbers[start]] = true;
            searchCycle(inputNumbers[start], original);
            isVisited[inputNumbers[start]] = false;
        }
        if (inputNumbers[start] == original) resultList.add(original);
    }
}
