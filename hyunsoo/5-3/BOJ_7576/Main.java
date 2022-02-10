package BOJ_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] moveY = {1, 0, -1, 0};
    static int[] moveX = {0, 1, 0, -1};
    static int N;
    static int M;
    static int max;
    static int status = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        max = M * N;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());

                if (input == -1) {
                    max--;
                } else if (input == 1) {
                    status++;
                }

                map[i][j] = input;
            }
        }

        while (max != status) {
            int tempStatus = status;
            int[][] tempMap = copyArray();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tempMap[i][j] == 1) {
                        fillTomato(i, j);
                    }
                }
            }

            if (tempStatus == status) {
                count = -1;
                break;
            }

            count++;
        }

        System.out.println(count);
    }

    public static void fillTomato(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + moveY[i];
            int nx = x + moveX[i];

            if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                if (map[ny][nx] == 1 || map[ny][nx] == -1) continue;
                map[ny][nx] = 1;
                status++;
            }
        }
    }

    public static int[][] copyArray() {
        int[][] result = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = map[i][j];
            }
        }

        return result;
    }
}
