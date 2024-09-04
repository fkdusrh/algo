import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numSensors = sc.nextInt();
        int numStations = sc.nextInt();

        if (numStations >= numSensors) {
            System.out.println(0);
            return;
        }

        int[] sensors = new int[numSensors];
        for (int i = 0; i < numSensors; i++) {
            sensors[i] = sc.nextInt();
        }

        Arrays.sort(sensors);

        Integer[] differences = new Integer[numSensors - 1];
        for (int i = 0; i < numSensors - 1; i++) {
            differences[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(differences, Collections.reverseOrder());

        int totalDistance = 0;
        for (int i = numStations - 1; i < numSensors - 1; i++) {
            totalDistance += differences[i];
        }

        System.out.println(totalDistance);
    }
}
