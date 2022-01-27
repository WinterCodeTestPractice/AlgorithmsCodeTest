import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 알고리즘 1654번 : 랜선 자르기
public class Baekjooon_1654 {
    public static void main(String[] args) throws IOException {
        /*전략
         * k개(4개) 를 n개(11개)로 만들수 있는 최대의 길이?
         * 802 743 457 539
         * 이분탐색문제
         * 무조건 되는 경우(start)와 무조건 안되는경우 (end)찾기
         * 즉,탐색 범위 최소 길이와 최대 길이를 구하여 탐색 -> min, max, mid
         * 또한! 개수가 중복이 될 떄 최대 길이를 찾아야 한다는 것 ->
         * 제한조건의 자료형 크기조심 ->long으로 변환
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] a = new int[k];
        long max = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(br.readLine());
            if (max < a[i]) {
                max = a[i];
            }
        }
        // 0을 나눌 수도 있음.
        max++;
        long min = 0;
        long mid = 0;

        while (min < max) {
            //중간길이로 자름
            mid = (min + max) / 2;
            long count = 0;
            for (int i = 0; i < a.length; i++) {
                count += (a[i] / mid);
            }
            //중간길이로 잘랐을때 count 개수가 n보다 작다는건 mid길이를 줄여야한다. 그러기 위해 max길이를 반으로 줄인다.
            //반대는 count 개수가 너무 많이 나와서 min 길이를 늘려준다.
            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        // (Upper Bound - 1)
        System.out.println(min - 1);
    }
}
