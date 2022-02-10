// https://www.acmicpc.net/problem/7576
function solution(tomato) {
  let answer = 0;
  let dx = [0, 1, 0, -1];
  let dy = [1, 0, -1, 0];
  let queue = [];
  // 처음부터 익어있는 토마토를 먼저 큐로 보냅니다.
  for (let i = 0; i < tomato[0].length; i++) {
    for (let k = 0; k < tomato.length; k++) {
      if (tomato[k][i] === 1) {
        queue.push([i, k]);
      }
    }
  }
  // BFS를 돌며 당일에 익은 토마토의 목록이 없어질 때까지 탐색을 합니다.
  while (queue.length) {
    let change = false; // 익어버린 토마토를 확인하기 위한 변수입니다.
    let riped = queue.length; // 당일에 몇개나 익었는지 확인합니다.
    for (let k = 0; k < riped; k++) {
      // 익은 개수만큼 돕니다.
      let [x, y] = queue.shift();
      for (let i = 0; i < 4; i++) {
        // 상하좌우로 더 익을수있는게 있는지 확인합니다.
        let nx = x + dx[i];
        let ny = y + dy[i];

        if (
          ny >= 0 &&
          nx >= 0 &&
          ny < tomato.length &&
          nx < tomato[0].length &&
          tomato[ny][nx] === 0
        ) {
          change = true; // 당일에 익은 게 있다고 체크해줍니다.
          tomato[ny][nx] = 1; // 익을 수 있는 게 있다면 익힙니다.
          queue.push([nx, ny]); // 익히고 큐에 넣어줍니다.
        }
      }
    }
    if (change === false) break; // 당일에 익은게 하나도 없으면 탐색을 종료합니다.
    answer++;
  }

  for (let i = 0; i < tomato.length; i++) {
    if (tomato[i].includes(0)) return -1; // 탐색 완료한 결과에서 익지 않은 토마토가 있는지 확인합니다.
  }

  return answer;
}

console.log(
  solution([
    [-1, 1, 0, 0, 0],
    [0, -1, -1, -1, 0],
    [0, -1, -1, -1, 0],
    [0, -1, -1, -1, 0],
    [0, 0, 0, 0, 0],
  ])
);

// 자바스크립트로 백준 문제를 푸는데 불편함이 있어 프로그래머스 형식으로 풀었습니다.
