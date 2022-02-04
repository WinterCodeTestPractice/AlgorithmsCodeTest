package 4-1;

import java.util.Arrays;

public class Solution7 {
    static int[][] map = new int[51][51];
    static final int INF = Integer.MAX_VALUE;
    static int[] result;
    static int[] visited;

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        for (int[] ints : road) {
            setMap(ints[0], ints[1], ints[2]);
        }

        result = new int[N + 1];
        Arrays.fill(result, INF);
        visited = new int[N + 1];
        result[1] = 0;
        visited[1] = 1;

        for (int i = 1; i <= N ; i++) {
            if (visited[i] == 0 && map[1][i] != 0) {
                result[i] = map[1][i];
            }
        }

        for (int i = 0; i < N - 1; i++) {

            int min = INF;
            int minIndex = -1;

            for (int j = 1; j <= N; j++) {
                if (visited[j] == 0 && result[j] != INF) {
                    if (result[j] < min) {
                        min = result[j];
                        minIndex = j;
                    }
                }
            }

            visited[minIndex] = 1;

            for (int j = 1; j <= N; j++) {
                if (visited[j] == 0 && map[minIndex][j] != 0) {
                    if (result[j] > result[minIndex] + map[minIndex][j]) {
                        result[j] = result[minIndex] + map[minIndex][j];
                    }
                }
            }
        }

        return (int) Arrays.stream(result).filter(x -> x <= K).count();
    }

    public static void setMap(int target1, int target2, int weight) {
        if (map[target1][target2] != 0) {
            weight = Math.min(weight, map[target1][target2]);
        }

        map[target1][target2] = weight;
        map[target2][target1] = weight;
    }

    public static void main(String[] args) {
        int[][] test = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        System.out.println(solution(5, test, 3));
    }
}
