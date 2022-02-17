package 6-1;

import java.util.LinkedList;
import java.util.Queue;

public class Solution9 {
    static boolean[][] matrix;
    static boolean[] visited;

    public static int solution(int n, int[][] edge) {
        matrix = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        int answer = 0;

        for (int[] ints : edge) {
            int a = ints[0];
            int b = ints[1];

            matrix[a][b] = true;
            matrix[b][a] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            answer = queue.size();

            for (int i = 0; i < answer; i++) {
                int node = queue.poll();

                for (int j = 2; j <= n; j++) {
                    if (visited[j] || !matrix[node][j]) continue;

                    visited[j] = true;
                    queue.add(j);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(6, arr));
    }
}
