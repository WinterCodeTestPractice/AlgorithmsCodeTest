package BOJ_2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] matrix = new int[101][101];
    static int[][] visited = new int[101][101];
    // 좌표를 좌 우 상 하로 옮기기위해 배열생성
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static int count;
    static List<Integer> result = new ArrayList<>();
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            int[] loc = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            fillMatrix(loc[0], loc[1], loc[2], loc[3]);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 만약 해당 부분이 채워져있지않고 방문하지 않았으면
                if (visited[i][j] == 0 && matrix[i][j] == 0) {
                    // count를 1로 초기화하고 dfs 함수 실행
                    count = 1;
                    dfs(i, j);
                    // dfs가 완료됬으면 결과값을 list에 넣는다.
                    result.add(count);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        result.forEach(x -> System.out.print(x + " "));
    }

    // 두개의 꼭지점, xy좌표를 두개를 매개변수로 받아 해당 범위를 1로 채워주는 함수
    public static void fillMatrix(int downX, int downY, int upX, int upY) {
        for (int i = downY; i < upY; i++) {
            for (int j = downX; j < upX; j++) {
                matrix[i][j] = 1;
                visited[i][j] = 1;
            }
        }
    }

    public static void dfs(int y, int x) {
        // x, y 부분에 방문했다는 표시를 하기위해 1로 채운다.
        visited[y][x] = 1;

        // 상하좌우로 이동하기위해 ny, nx를 생성
        for (int i = 0; i < 4; i++) {
            int ny = y + moveY[i];
            int nx = x + moveX[i];

            // 만약 ny, nx가 배열의 범위를 벗어나지 않았으면
            if (0 <= ny && ny < M && 0 <= nx && nx < N) {
                // 만약 해당 부분이 채워져있지않고 방문하지 않았으면
                if (visited[ny][nx] == 0 && matrix[ny][nx] == 0) {
                    // count에 1을 더하고 재귀적으로 dfs를 실행
                    count++;
                    dfs(ny, nx);
                }
            }
        }
    }
}
