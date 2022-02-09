// https://www.acmicpc.net/problem/1021
function solution(N, arr) {
  let num = [];
  for (let i = 1; i <= N; i++) num.push(i);

  let answer = 0;
  while (true) {
    if (arr[0] === num[0] && arr.length > 0) {
      arr.shift();
      num.shift();
      continue;
    }
    if (arr.length === 0 || num.length === 0) break;

    let targetIndex = num.indexOf(arr[0]);
    if (num.length / 2 > targetIndex) {
      num.push(num.shift());
      answer++;
    } else {
      num.unshift(num.pop());
      answer++;
    }
  }
  return answer;
}

console.log(solution(32, [27, 16, 30, 11, 6, 23]));

// 자바스크립트로 백준 문제를 푸는데 불편함이 있어 프로그래머스 형식으로 풀었습니다.
// 원하는 값의 인덱스가 원형 큐 인덱스의 절반을 넘어가면 반대로, 아니라면 원래 방향대로 돌리며 풀 수 있었습니다.
