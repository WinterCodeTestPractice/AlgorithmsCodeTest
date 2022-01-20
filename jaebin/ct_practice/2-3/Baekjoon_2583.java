import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 2583번 :  영역 구하기
/*
 * 그래프 이론과 DFS,BFS를 사용하여 문제를 풀어보자!
 *
 * BFS : 너비 우선 탐색
 * BFS는 재귀적으로 동작하지 않는다.
 * BFS는 시작 정점으로부터 거리가 가까운 정점의 순서로 탐색한다. (거리 1부터 2, 3 순서대로)
 * BFS는 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 자료 구조인 큐(Queue)를 사용한다.
 * 즉, 선입선출(FIFO) 원칙으로 탐색
 *
 * DFS : 깊이 우선 탐색
 * 자기 자신을 호출하는 순환 알고리즘의 형태
 * 트리 순회(전위, 중위, 후위 순회)는 모두 DFS의 한 종류
 * 그래프 탐색의 경우 어떤 노드를 방문했었는지의 여부를 반드시 검사해야함(안하면 무한루프 빠질 위험 있음)
 * 구현방법 : 재귀, 스택
 * */

/*
* 결론 : 탐색중 재귀 할때 배열의 index가 벗어나서 실패. -> 디버그 할때, 어디 부분에서 out of index가 났는지 확인 필요
* */
public class Baekjoon_2583 {
    // 총 7 x 5 배열 a
    static int[][] a;
    // M,N,K
    static int M;
    static int N;
    static int K;

    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    //넓이가 들어간 리스트
    static List<Integer> list;
    //탐색 하여 나온 하나의 넓이 값
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        a = new int[M][N]; // 7 5
        for (int i = 0; i < K; i++) {
            // (x1,y1)(x2,y2)를 각각 담아줌
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            // 좌표의 직사각형을 구해서 범위 안에 들면 1, 아니면 0
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    a[j][k] = 1;
                }
            }
            //확인
//            for (int j = a.length - 1; j >= 0; j--) {
//                for (int k = 0; k < a[j].length; k++) {
//                    System.out.print(a[j][k]);
//                }
//                System.out.println();
//            }
        }
        list = new ArrayList<>();
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
                if (a[j][k] == 0) {
                    count = 0;
                    //깊이 우선 탐색 시작!
                    dfs(j, k);
                    list.add(count);
                }
            }
        }
        //개수
        System.out.println(list.size());
        //정렬
        Collections.sort(list);
        //넓이들 출력
        for (Integer c : list) {
            System.out.print(c + " ");
        }

    }

    public static void dfs(int r, int c) {
        // 탐색한것은 1로 바꿈
        a[r][c] = 1;
        // 넓이 1 증가
        count++;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            //0,0 에서 5,7 사이
            if (nr >= 0 && nc >= 0 && nr < M && nr < N) {
                // 영역이 0이어야함.
                if (a[nr][nc] == 0) {
                    dfs(nr, nc);
                }
            }
        }
    }
}
