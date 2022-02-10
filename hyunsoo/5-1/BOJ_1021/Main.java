package BOJ_1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;
    static int N = 10;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {

            int target = Integer.parseInt(st.nextToken());

            int a = 0;
            int b = 0;

            Integer[] array = deque.toArray(new Integer[deque.size()]);

            for (int i = 0; i < array.length; i++, a++) {
                if (array[i] == target) break;
            }

            for (int i = array.length - 1; i >= 0; i--, b++) {
                if (array[i] == target) {
                    b++;
                    break;
                }
            }

            if (a > b) {
                for (int i = 0; i < b; i++) {
                    deque.addFirst(deque.pollLast());
                }
            } else {
                for (int i = 0; i < a; i++) {
                    deque.addLast(deque.pollFirst());
                }
            }

            deque.pollFirst();

            result += Math.min(a, b);
        }

        System.out.println(result);
    }
}
