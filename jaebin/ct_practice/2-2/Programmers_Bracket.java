import java.util.Stack;

//프로그래머스 레벨2 : 괄호 회전하기
/*
 * 백준 9012번 괄호의 응용문제!!!
 * 알맞은 자료구조를 사용하여 풀자!!!
 * 회전하는 로직과 괄호가 올바른지 확인하는 로직이 필요함.
 * */

// 결론 : 성공  -> 스위치문을 이용하지 않고 로직을 줄일 수 있는 방법이 있을까?
// 문자열을 회전시킬때, StringBuilder를 사용하지 않고 시간복잡도가 적은 자료구조가 있을까?
public class Programmers_Bracket {
    public static void main(String[] args) {
        String s = "}]()[{";
        solution(s);

    }

    public static int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            String temp = sb.substring(0, 1);
            //문자열 끝에 추가
            sb.append(temp);
            sb.deleteCharAt(0);
            if (check(sb.toString())) answer++;
        }
        return answer;
    }

    // 해당 괄호가 올바른지 확인하는 메서드
    public static boolean check(String s) {
        boolean answer = false;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int st_len = st.size();
            //스택에 아무것도 없을때 닫힌괄호는 허용하지 않는다.
            if (st_len == 0) {
                switch (ch) {
                    case ')':
                    case '}':
                    case ']': {
                        return false;
                    }
                    default: {
                        st.push(s.charAt(i));
                    }
                }
                continue;
            }
            char peek = st.peek();
            // 문자열의 마지막일때는 열린괄호는 허용하지 않는다.
            if (i == s.length() - 1) {
                switch (ch) {
                    case '(':
                    case '{':
                    case '[': {
                        return false;
                    }
                }
            }
            // 열린괄호라면 스택에 넣고, 닫힌괄호라면 스택의 최상위와 비교하여 맞으면 스택에서 꺼내고, 틀리면 괄호 전체가 틀린다.
            switch (ch) {
                case '(':
                case '{':
                case '[': {
                    st.push(ch);
                    break;
                }
                case ')':
                    if (peek == '(') {
                        st.pop();
                        break;
                    } else return false;
                case '}':
                    if (peek == '{') {
                        st.pop();
                        break;
                    } else return false;
                case ']':
                    if (peek == '[') {
                        st.pop();
                        break;
                    } else return false;
            }
        }
        if (st.size() > 0) {
            answer = false;
        } else answer = true;
        return answer;
    }
}

