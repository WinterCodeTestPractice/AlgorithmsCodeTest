import java.util.ArrayList;
import java.util.List;

//프로그래머스 레벨 2 : n^2 배열 자르기
public class Programmers_87390 {
    public static void main(String[] args) {
        solution(3, 2, 5);
    }
    /*전략
     * 원래는 이중배열 만들어서 i행,i열에 i넣고 , 행마다 잘라서 리스트에 넣어서 left~right 구하려고 했는데, 자료형 범위를 넘어감
     * */
    public static List<Long> solution(int n, long left, long right) {
        List<Long> list = new ArrayList<>();

        //규칙을 찾자.
        //i보다 j가 큰 경우를 살펴보면 j+1
        // n*n이기 떄문에, 세로 Index를 구해보자면 순서에 n을 나눈 값 ,가로 Index의 경우는 순서에 n을 나눈 나머지
        for (long i = left; i < right + 1; i++) {
            list.add(Math.max(i / n, i % n) + 1);
        }

        return list;
    }
}
