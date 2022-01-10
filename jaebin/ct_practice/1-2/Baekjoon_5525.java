import java.util.Scanner;

public class Baekjoon_5525 {
    /*
     * 서브태스크가 있는 제한이 두개인 문제 : 백준 5525 IOIOI
        번호	배점	제한
        1	50	N ≤ 100, M ≤ 10 000.
        2	50	추가적인 제약 조건이 없다.:
     * 문자열의 어떤 알고리즘으로 풀어야하는가?!
     * */
    public static void main(String[] args) {
        //브루트 포스로 전체를 다 검색하여 풀이
        Scanner sc = new Scanner(System.in);
        // 2*n+1개의 IOI...
        int n = sc.nextInt();
        // 입력받는 문자열의 길이
        int m = sc.nextInt();
        sc.nextLine();
        // 검색해야할 문자열
        String s = sc.nextLine();
        // 입력받은 문자열을 char형 문자 배열로 변환
        char[] sch = s.toCharArray();
        //check할 IOI 문자 배열
        char[] check = new char[2 * n + 1];
        // 탐색된 결과 개수
        int cnt = 0;

        //2*n+1개의 IOI 생성
        for (int i = 0; i < check.length; i++) {
            if (i % 2 == 0) {
                check[i] = 'I';
            } else {
                check[i] = 'O';
            }
        }
        // 2중 for문을 이용하여 sch 문자 배열에서 check 문자배열을 검색하는 로직
        for (int i = 0; i < m; i++) {
            //총 sch 문자 배열에 i번째 검색될 2*n+1의 char 배열o 
            char[] o = new char[2 * n + 1];
            if (i + (2 * n) < m) {
                int u = 0;
                for (int j = i; j < (2 * n + 1) + i; j++) {
                    o[u] = sch[j];
                    u++;
                }
                int res = 0;
                for (int k = 0; k < 2 * n + 1; k++) {
                    if (o[k] == check[k]) res++;
                }
                if (res == 2 * n + 1) cnt++;
            }
        }
        System.out.println(cnt);
        /*
         * 결론: 탐색한 개수 cnt가 구해졌으나 50점 ,
         * 어떠한 문자열 알고리즘 줄일 수 있을까?
         *
         * */
    }
}
