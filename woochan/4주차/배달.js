// https://programmers.co.kr/learn/courses/30/lessons/12978

function solution(N, road, K) {
  let graph = Array.from(Array(N + 1), () => Array()); // 인접리스트 역할을 할 graph배열입니다.
  let distance = Array.from({ length: N + 1 }, () => Infinity); // 다익스트라 문제이기에 거리를 모두 infinity로 초기화해줍니다.
  let queue = []; // 우선순위큐 역할을 할 큐입니다.

  for (let [a, b, c] of road) {
    // 인접리스트를 구현해주었습니다.
    graph[a].push([b, c]);
    graph[b].push([a, c]);
  }

  queue.push([1, 0]); // 1번마을은 기본적으로 배달이 가능합니다.
  distance[1] = 0; // 1번부터 출발하니 1번마을 거리는 0입니다.
  while (queue.length) {
    // 우선순위큐가 빌때까지 계속 돕니다.
    const [point, cost] = queue.shift();
    for (let i = 0; i < graph[point].length; i++) {
      const next = graph[point][i][0]; // 다음 갈 마을 번호
      const nextcost = graph[point][i][1]; // 다음 갈 마을 코스트

      // 다음 갈 마을 코스트를 더한 값이 기존 값보다 작은지부터 확인해줍니다.
      if (distance[next] > distance[point] + nextcost) {
        distance[next] = distance[point] + nextcost; // 작다면 넣어줍니다.
        queue.push([next, nextcost]); // 우선순위큐에도 넣어줍니다.
      }
    }
  }

  distance = distance.filter((v) => v <= K); // 거리배열에서 K보다 작거나 같은 값만 추려냅니다.
  console.log(distance);
  return distance.length; // 이후 마을의 개수를 리턴해줍니다.
}

console.log(
  solution(
    6,
    [
      [1, 2, 1],
      [1, 3, 2],
      [2, 3, 2],
      [3, 4, 3],
      [3, 5, 2],
      [3, 5, 3],
      [5, 6, 1],
    ],
    4
  )
);
