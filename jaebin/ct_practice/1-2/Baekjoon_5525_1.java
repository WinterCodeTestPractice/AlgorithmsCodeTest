import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_5525_1 {
    /*
    * 서브태스크가 있는 제한이 두개인 문제 : 백준 5525 IOIOI
       번호	배점	제한
       1	50	N ≤ 100, M ≤ 10 000.
       2	50	추가적인 제약 조건이 없다.:
    * 오토마타 문자열 알고리즘을 사용하여 풀어보자!!
    * */
    //n,m,길이,답,현재상태
    static int n, m, len, answer, now;
    static char[] s;

    //길이 len인 IOI 문자열에는 길이 n인 IOI 문자열이 (len - n + 1)개 들어있다.
    static void IOIEnd() {
        if (len >= n) {
            answer += (len - n + 1);
        }
        len = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //길이가 n=1이면 IOI(2*n+1)
        n = Integer.parseInt(br.readLine());
        //s의 길이
        m = Integer.parseInt(br.readLine());
        //ex) OOIOIOIOIIOII -> chrt형 배열로 변환
        s = br.readLine().toCharArray();

        //상태 값들
        final int Ia = 1, Oa = 2, Ib = 3, Ob = 4;
        //첫문자로 첫 상태 계산
        now = (s[0] == 'I') ? Ia : Oa;
        for (int i = 1; i < s.length; i++) {
            switch (now) {
                case Oa:
                    if (s[i] == 'I') now = Ia;
                    break;
                case Ia:
                    if (s[i] == 'O') now = Ob;
                    break;
                case Ob:
                    if (s[i] == 'I') {
                        now = Ib;
                        len++;
                    } else {
                        now = Oa;
                        IOIEnd();
                    }
                    break;
                case Ib:
                    if (s[i] == 'O') {
                        now = Ob;
                    } else {
                        now = Ia;
                        IOIEnd();
                    }
                    break;
            }
        }
        IOIEnd();
        System.out.println(answer);
    }
}
