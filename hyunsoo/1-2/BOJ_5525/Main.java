package BOJ_5525;

import java.util.Scanner;


// 브루트 포스를 이용했는데.. 너무 느리다 KMP 알고리즘을 사용해서 빠르게 해야하는 문제인 것 같다.
public class Main {
    static StringBuilder sb = new StringBuilder("I");
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String S = sc.next();

        // N만큼 OI 문자열을 더한다
        sb.append("OI".repeat(N));

        for (int i = 0; i < M - (sb.length() - 1); i++) {
            // 한문자열의 시작점과 끝을 정해 잘라서 temp 변수에 저장
            String temp = S.substring(i, i + sb.length());
            // temp와 sb를 비교해서 맞으면 count++
            if (temp.equals(sb.toString())) {
                count++;
            }
        }

        System.out.println(count);
    }
}
