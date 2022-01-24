// https://programmers.co.kr/learn/courses/30/lessons/86971
function solution(n, wires) {
  let answer = Number.MAX_SAFE_INTEGER;
  let visited = Array.from({ length: n + 1 }, () => 0); // 깊이탐색을 하며 이미 지나온 전선 여부를 파악하기 위해 만들었습니다.
  let count = 1; // 송전탑의 개수입니다.
  let graph = Array.from(Array(n + 1), () => Array(n + 1).fill(0)); // 공간복잡도에 여유가 있어 인접행렬을 이용하였습니다.
  // 송전탑과 전망을 인접행렬을 이용한 양방향 그래프로 사용했습니다.
  for (let [a, b] of wires) {
    graph[a][b] = 1;
    graph[b][a] = 1;
  }

  for (let [a, b] of wires) {
    graph[a][b] = 0; // 모든 전선을 끊어보기 위해 이미 만들었던 인접행렬을 수정하였습니다.
    graph[b][a] = 0;
    count = 1;
    function DFS(L) {
      // 전선을 끊은 상태에서 깊이탐색을 이용하여 연결된 송전탑이 몇개인지 확인하였습니다.
      for (let i = 1; i <= n; i++) {
        if (visited[i] === 0 && graph[L][i] === 1) {
          visited[L] = 1; // 지나온 전선
          count++; // 연결된 송전탑 개수 추가
          DFS(i);
          visited[L] = 0; // 지나온 전선 복구
        }
      }
    }
    DFS(1);
    graph[a][b] = 1; // 수정했던 인접행렬의 전선 연결 여부를 복구했습니다.
    graph[b][a] = 1;

    answer = Math.min(answer, Math.abs(n - count - count)); // 송전탑의 개수의 차이는 (전체 송전탑의 개수 - 깊이탐색을 통해 나온 송전탑의 개수) - 깊이탐색을 통해 나온 송전탑의 개수 입니다.
    // 그렇게 나온 결과 중 작은 값으로 계속 초기화해줬습니다.
  }
  return answer;
}
console.log(
  solution(9, [
    [1, 3],
    [2, 3],
    [3, 4],
    [4, 5],
    [4, 6],
    [4, 7],
    [7, 8],
    [7, 9],
  ])
);
/*
  질문사항
  문제를 보고 모든 경우의 수를 탐색하는방법 말고는 생각나지 않아 그렇게 풀었습니다.
  풀고 난 뒤 다른사람 풀이를 봤는데 해시를 이용해 시간복잡도를 엄청나게 줄여 푼 사람이 있었습니다. https://velog.io/@e7838752/programmers86971
  제한사항이 빡빡하지 않아 문제는 풀 수 있었지만 만약 빡빡했더라면 시간복잡도에서 0점이 나왔을 문제였다고 생각됩니다.
  그래서 해시를 이용한 풀이방법을 이해해보려 하였으나 도무지 이해하기 힘들어 해시를 이용한 문제풀이 질문드립니다.
*/
