package 4-3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix = new int[301][301];
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static int N;
    static int M;

    public static void rotate() {
        int count = Math.min(N, M) / 2;

        for (int i = 0; i < count; i++) {
            int startValue = matrix[i][i];
            int x = i;
            int y = i;

            int k = 0;

            while(k < 4) {

                int nx = x + moveX[k];
                int ny = y + moveY[k];

                if (nx == i && ny == i) break;

                if (i <= ny && ny < N-i && i <= nx && nx < M-i) {
                    matrix[y][x] = matrix[ny][nx];
                    y = ny;
                    x = nx;
                } else {
                    k++;
                }
            }
            matrix[i + 1][i] = startValue;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            rotate();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(matrix[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
