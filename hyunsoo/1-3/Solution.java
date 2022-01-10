package 1.3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println("#" + (i + 1));
            makeSnail(n);
        }
    }

    static void makeSnail(int n) {
        // 해당 x, y를 들럿는지 판단하기 위한 2차원 배열
        int[][] visited = new int[n][n];
        // 실제 값들이 들어가는 배열
        int[][] matrix = new int[n][n];
        // x(행)이 이동하는 방향
        int[] moveX = {1, 0, -1, 0};
        // y(행)이 이동하는 방향
        int[] moveY = {0, 1, 0, -1};
        // 처음 x, y는 0, 0 부터 시작
        int x = 0;
        int y = 0;

        // moveX, moveY의 인덱스 초기값
        int index = 0;

        for (int i = 0; i < n * n; i++) {
            // 만약 x, y가 범위를 벗어나거나 해당 x, y에 이미 접근을 했다면
            if ((x < 0 || x >= n || y < 0 || y >= n) || (visited[y][x] == 1)) {
                // 다시 그 전단계 좌표로간다.
                x -= moveX[index];
                y -= moveY[index];

                // 방향을 바꾸기위해 index++
                index++;
                // index가 4가되면 범위가 넘어서므로 0으로 다시 초기화
                if (index > 3) {
                    index %= 4;
                }

                // 다른 방향으로 간다
                x += moveX[index];
                y += moveY[index];
            }

            // matrix에 실제 값을 저장하고 visited에 1을 저장
            matrix[y][x] = i + 1;
            visited[y][x] = 1;
            // x, y 좌표를 이동시킨다.
            x += moveX[index];
            y += moveY[index];
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
