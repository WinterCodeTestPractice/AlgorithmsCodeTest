import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Baekjoon_1406_1 {
    /*
     * 시간 제한이 짧은 문제: 백준 1406 에디터
     * 추가 삭제에 시간복잡도가 o(1)인 doubleLinkedList를 사용하여 풀자!!
     * */
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //LinkedList로 구현
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        //명령어 개수
        int n = Integer.parseInt(br.readLine());
        //ListIterator는 양방향으로의 이동이 가능,
        //ListIterator 인터페이스는 List인터페이스를 구현한 List 컬렉션 클래스 객체 에서만 listIterator를 통해 사용가능.
        //list.size()가 4
        ListIterator<Character> iterator = list.listIterator(list.size());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //명령어의 첫번재 토큰
            String cmd = st.nextToken();
            switch (cmd) {
                case "L":
                    if (iterator.hasPrevious()) iterator.previous();
                    break;
                case "D":
                    if (iterator.hasNext()) iterator.next();
                    break;
                case "B":
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case "P":
                    iterator.add(st.nextToken().charAt(0));
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        System.out.println(sb.toString());

    }
}
