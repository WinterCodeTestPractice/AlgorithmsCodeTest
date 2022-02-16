// https://programmers.co.kr/learn/courses/30/lessons/49189
function solution(n, edge) {
  let graph = Array.from({ length: n + 1 }, () => []); // 그래프에대한 내용을 정리할 배열
  let check = Array.from({ length: n + 1 }, () => 0); // 한번 간 곳인지 확인용 배열
  let distance = Array.from({ length: n + 1 }, () => 0); // 거리 체크용 배열
  let queue = []; // bfs에돌릴 큐

  // 노드개수가 20000까지 갈 수 있으므로 공간복잡도를 고려해 인접리스트로 사용
  for (let [a, b] of edge) {
    graph[a].push(b);
    graph[b].push(a);
  }

  queue.push(1);
  check[1] = 1;

  // BFS탐색
  while (queue.length) {
    let N = queue.shift();

    for (let nl of graph[N]) {
      if (check[nl] === 0) {
        check[nl] = 1;
        queue.push(nl);
        distance[nl] = distance[N] + 1;
      }
    }
  }
  // 탐색 완료 후 거리를 기록한 배열 내림차순으로 정렬
  distance.sort((a, b) => b - a);
  distance = distance.filter((v) => v === distance[0]); // 제일 높은것만 남도록 배열 처리
  return distance.length; // 남은 배열의 길이 리턴
}

console.log(
  solution(6, [
    [3, 6],
    [4, 3],
    [3, 2],
    [1, 3],
    [1, 2],
    [2, 4],
    [5, 2],
  ])
);

// bfs를 이용하여 풀 수 있었습니다. 공간복잡도를 생각해 인접리스트를 사용하고 bfs를 이용하면 풀 수 있는 문제였습니다.
