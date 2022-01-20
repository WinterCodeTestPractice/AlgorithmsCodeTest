package 2-2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(String s) {
        Deque<Character> deque = new LinkedList<>();
        int count = 0;

        s.chars().forEach(x -> deque.add((char) x));

        for (int i = 0; i < s.length(); i++) {
            String a = toString(deque);
            // 올바른 문자인지 판단하고 맞으면 count++
            if (isBracket(toString(deque))) count++;

            // 맨앞에있는 char를 뒤로보낸다.
            deque.add(deque.poll());
        }

        return count;
    }

    /**
     * 문자열을 매개변수로 받고 올바른 괄호인지 boolean을 반환하는 메소드
     * @param str : String형태
     * @return 스택이 최종적으로 비어있으면 올바른 괄호 문자열(true), 아니면 틀린 문자열(false)
     */
    public static boolean isBracket(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);

            if (temp == '(' || temp == '[' || temp == '{') {
                stack.push(temp);
            } else if (temp == ')' || temp == ']' || temp == '}') {
                if (stack.isEmpty()) {
                    stack.push(temp);
                    break;
                }
                char open = stack.peek();

                if (temp == ')' && open == '(') {
                    stack.pop();
                } else if (temp == ']' && open == '[') {
                    stack.pop();
                } else if (temp == '}' && open == '{') {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    // Deque 안에있는 char들을 합쳐서 String으로 반환하는 메소드
    public static String toString(Deque<Character> deque) {
        return deque.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
}