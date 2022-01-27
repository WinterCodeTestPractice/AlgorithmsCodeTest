import java.util.*;

//프로그래머스 레벨2 : 전력망을 둘로 나누기
public class Programmers_86971 {
    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println( solution(9, a));
    }

    static int[][] arr;

    // 노드가 9개 , 간선이 a.length 8개
    public static int solution(int n, int[][] wires) {
        /*
         * 전략 : 간선이 제일 많이 연결된 노드를 찾는다.
         * -> 선을 하나씩 끊어 보면서, 나눠진 두 전력망의 송전탑 개수의 차이를 구하자.
         */
        int answer = n;
        arr =new int[n + 1][n + 1];
        // 인접 행렬을 만든다.
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        //선을 하나씩 끊어 보면서 탐색
        int a, b;
        //a가 간선중 부모
        for (int i = 0; i < wires.length; i++) {
            a = wires[i][0];
            b = wires[i][1];

            // 선하나 끊음
            arr[a][b] = 0;
            arr[b][a] = 0;

            answer = Math.min(answer, bfs(n, a));

            //선 복구
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        return answer;
    }
    //bfs
    public static int bfs(int n, int start) {
        int[] visit = new int[n + 1];
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int point = queue.poll();
            visit[point] = 1;

            for (int i = 1; i <= n; i++) { //point와 연결된 애들 중에 방문한적 없는 노드 전부 큐에 넣기
                if (visit[i] == 1) continue;
                if (arr[point][i] == 1) {
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        //
        return (int) Math.abs(n - 2 * cnt); //cnt-(n-cnt);
    }
}
