import java.util.Scanner;

class SW_Expert_Academy_1954 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //박스 n * n
            int n = sc.nextInt();
            int result[][] = dal(n);
            System.out.println("#" + test_case);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] dal(int n) {
        //우 하 좌 상
        int result[][] = new int[n][n];
        // 증가 숫자
        int temp = 1;
        //행
        int col = 0;
        //열  -> 주의 : 시작이 0,0입니다. 시작할때 row를 더해주면서 해당 좌표값에 값을 넣어줌.
        int row = -1;

        int flag = 1;
        while (true) {

            //우, 좌
            for (int i = 0; i < n; i++) {
                row += flag;
                result[col][row] = temp;
                temp++;
            }
            // n n-1 n-2 n-3  ex) 3 2 2 1 1
            n -= 1;

            if (n == 0) break;
            //하, 상
            for (int i = 0; i < n; i++) {
                col += flag;
                result[col][row] = temp;
                temp++;
            }
            flag *= (-1);
        }

        return result;
    }
}