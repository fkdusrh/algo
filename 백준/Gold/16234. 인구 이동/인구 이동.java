import java.util.*;

public class Main {

    static int size, lowerBound, upperBound;
    static int[][] populationMap;
    static boolean[][] isVisited;
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};
    static ArrayList<Location> regionsToAdjust;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        size = scanner.nextInt();
        lowerBound = scanner.nextInt();
        upperBound = scanner.nextInt();

        populationMap = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                populationMap[i][j] = scanner.nextInt();
            }
        }

        System.out.println(calculatePopulationMovements());
    }

    public static int calculatePopulationMovements() {
        int totalMovements = 0;

        while (true) {
            boolean hasMoved = false;
            isVisited = new boolean[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!isVisited[i][j]) {
                        int totalPopulation = exploreAndMarkRegion(i, j);
                        if (regionsToAdjust.size() > 1) {
                            redistributePopulation(totalPopulation);
                            hasMoved = true;
                        }
                    }
                }
            }

            if (!hasMoved) {
                return totalMovements;
            }
            totalMovements++;
        }
    }

    public static int exploreAndMarkRegion(int startX, int startY) {
        Queue<Location> queue = new LinkedList<>();
        regionsToAdjust = new ArrayList<>();

        queue.offer(new Location(startX, startY));
        regionsToAdjust.add(new Location(startX, startY));
        isVisited[startX][startY] = true;

        int populationSum = populationMap[startX][startY];
        while (!queue.isEmpty()) {
            Location currentLocation = queue.poll();

            for (int direction = 0; direction < 4; direction++) {
                int nextX = currentLocation.x + dX[direction];
                int nextY = currentLocation.y + dY[direction];

                if (isInBounds(nextX, nextY) && !isVisited[nextX][nextY]) {
                    int populationDifference = Math.abs(populationMap[currentLocation.x][currentLocation.y] - populationMap[nextX][nextY]);
                    if (lowerBound <= populationDifference && populationDifference <= upperBound) {
                        queue.offer(new Location(nextX, nextY));
                        regionsToAdjust.add(new Location(nextX, nextY));
                        populationSum += populationMap[nextX][nextY];
                        isVisited[nextX][nextY] = true;
                    }
                }
            }
        }
        return populationSum;
    }

    public static void redistributePopulation(int totalPopulation) {
        int averagePopulation = totalPopulation / regionsToAdjust.size();
        for (Location loc : regionsToAdjust) {
            populationMap[loc.x][loc.y] = averagePopulation;
        }
    }

    public static boolean isInBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < size && y < size;
    }

    public static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
