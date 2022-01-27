package 3-2;

import java.util.ArrayList;
import java.util.List;

/**
 * 배열을 전부 생성하고 특정값을 뽑으면 메모리 초과뜸..
 * 특정 범위만 뽑아내서 찾아내는 방법으로 해결.
 */
public class Solution {
    public static int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();
        // 배열은 전부 생성 할 필요가없음. 범위만 알아내면 특정 부분만 찾을 수 있다.
        for (int i = (int) (left / n + 1); i <= (right / n  + 1); i++) {
            for (int j = 0; j < i; j++) {
                list.add(i);
            }

            for (int j = i + 1; j <= n; j++) {
                list.add(j);
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = (int) (left % n); i <= (right - n * (left / n)); i++) {
            result.add(list.get(i));
        }

        return result.stream().mapToInt(x -> x).toArray();
    }
}
