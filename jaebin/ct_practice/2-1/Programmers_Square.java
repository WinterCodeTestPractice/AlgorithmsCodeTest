//프로그래머스 레벨2 : 멀쩡한 사각형
/*
 * 최대공약수 수학적 규칙을 찾아서 풀 수 있는 문제=> 유클리드 호제법(재귀)을 사용하여 최대공약수를 찾자.
 * w와 h의 최대공약수를 구해야한다!!!
 * */

//결론 : 성공 -> 최대공약수가 아닌 다른 수학적 규칙으로 풀 수 있지 않을까?
public class Programmers_Square {
    public static void main(String[] args) {
        int m = 1;
        int n = 4;
        solution(m, n);
    }

    public static long solution(int w, int h) {
        long answer = 1;

        //w 8 , h 12
        //총 정사각형 개수
        long all = (long) w * (long) h;
        // 최대공약수 => n배수
        long gcd = gcd(w, h); //4
        // 작은 패턴 직사각형의 가로 길이 -> 가로 서로소 만들기
        long wl = (long) w / gcd;
        // 작은 패턴 직사각형의 세로 길이 -> 세로 서로소 만들기
        long hl = (long) h / gcd;

        //서로소인 가로와 세로를 가지는 작은 패턴 직사각형의 대각선이 겹치는 직사각형 (가로 + 세로 -1)
        // 전체 개수 - n배수(최대공약수) *(작은 패턴 직사각형 가로 + 작은 패턴 직사각형 세로 -1(중복되는 정사각형 한개) )
        answer = all - (gcd * (wl + hl - 1));
        return answer;
    }

    //유클리드 호제법을 이용한 최대공약수 구하기
    public static long gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1 % num2);
    }
}
