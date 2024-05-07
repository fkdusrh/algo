import java.io.*;
import java.util.*;

class Path {
    int start;
    int end;
    int cost;

    public Path(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

public class Main {
    static List<Path> paths;
    static int totalPaths, destination;
    static int minCost = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        initialize(reader);
        dfs(0, destination, 0);
        System.out.println(minCost);
    }

    private static void initialize(BufferedReader reader) throws IOException {
        String[] input = reader.readLine().split(" ");
        totalPaths = Integer.parseInt(input[0]);
        destination = Integer.parseInt(input[1]);
        paths = new ArrayList<>();

        for (int i = 0; i < totalPaths; i++) {
            input = reader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            if (start > destination || end > destination) {
                continue;
            }
            paths.add(new Path(start, end, cost));
        }

        visited = new boolean[paths.size()];
    }

    private static void dfs(int current, int end, int accumulatedCost) {
        if (current > end) {
            return;
        } else if (current == end) {
            minCost = Math.min(minCost, accumulatedCost);
            return;
        } else {
            minCost = Math.min(minCost, accumulatedCost + (end - current));
        }

        for (int i = 0; i < paths.size(); i++) {
            if (!visited[i] && paths.get(i).start == current) {
                visited[i] = true;
                dfs(paths.get(i).end, end, accumulatedCost + paths.get(i).cost);
                visited[i] = false;
            }
        }

        dfs(current + 1, end, accumulatedCost + 1);
    }
}