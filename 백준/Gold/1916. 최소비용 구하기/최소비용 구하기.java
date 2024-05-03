import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        StringTokenizer st ;
        for (int i = 0; i < M; i++) {
            st =new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList.get(u).add(new Node(v, cost));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int minCost = dijkstra(N, A, B, adjList);
        System.out.println(minCost);
    }

    static int dijkstra(int N, int start, int end, List<List<Node>> adjList) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.city == end) return current.cost;

            if (current.cost > dist[current.city]) continue;

            for (Node next : adjList.get(current.city)) {
                int newCost = dist[current.city] + next.cost;
                if (newCost < dist[next.city]) {
                    dist[next.city] = newCost;
                    pq.offer(new Node(next.city, newCost));
                }
            }
        }

        return dist[end];
    }

    static class Node {
        int city;
        int cost;

        Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }
}
