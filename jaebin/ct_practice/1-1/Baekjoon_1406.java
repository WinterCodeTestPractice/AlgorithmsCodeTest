import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon_1406 {
    /*

    array list , linked list  개념을 잡자.
    * 시간 제한이 짧은 문제: 백준 1406 에디터
    * 알맞는 자료구조를 이용하여 풀자!
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력받는 문자열
        String s = sc.nextLine();
        //문자열에 커서에 해당되는 | 추가
        s += "|";
        //문자열 길이
        int n = s.length();
        //입력받는 명령어 개수
        int m = sc.nextInt();
        sc.nextLine();
        //명령어들을 배열에 넣음
        String[] comm = new String[m];
        //문자열을 문자 배열 ArrayList에 넣기 위해
        ArrayList<Character> arr = new ArrayList<>();
        //명령어 받기
        for (int i = 0; i < m; i++) {
            comm[i] = sc.nextLine();
        }
        //a,b,c,d,|
        for (int i = 0; i < n; i++) {
            arr.add(s.charAt(i));
        }
        //이중 for문을 이용한 전체 탐색 로직
        for (int i = 0; i < m; i++) {
            //i가 0이면 첫번째 명령어
            for (int j = 0; j < arr.size(); j++) {
                //커서가 있는 곳에서 명령어를 실행시키기위해 커서를 먼저 찾는다.
                if (arr.get(j).equals('|')) {
                    if (comm[i].equals("L")) {
                        //맨 앞이라 아무 실행 x
                        if (j == 0) {
                            continue;
                        }
                        //현재랑 현재 앞과 스왑
                        Collections.swap(arr, j - 1, j);
                        break;
                    } else if (comm[i].equals("D")) {
                        if (j == arr.size() - 1) {
                            continue;
                        }
                        //현재랑 현재 뒤와 스왑
                        Collections.swap(arr, j, j + 1);
                        break;
                    } else if (comm[i].equals("B")) {
                        if (j == 0) {
                            continue;
                        }
                        //현재 앞의 문자 삭제
                        arr.remove(j - 1);
                        break;
                    } else if (comm[i].charAt(0) == 'P') {
                        //해당 문자 뽑아내기
                        char new_word = comm[i].charAt(2);
                        //
                        arr.add(j, new_word);
                        break;
                    }
                }
            }
        }
        //커서에 해당되는 | 삭제
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals('|')) {
                arr.remove(i);
            }
        }
        //출력
        for (Character i : arr) {
            System.out.print(i);
        }
        /*
        * 결론: 시간초과가 떠서 실패 ,
        * 어떠한 자료구조를 사용해야 시간복잡도를 줄일 수 있을까?
        * 입력 시간에 방해되는 Scanner 보다 BufferedReader를 사용해야 하는가?
        * */
    }
}
