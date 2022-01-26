// https://www.acmicpc.net/problem/1654
function solution(K, lans) {
  let answer = 0;
  let min = 1;
  let max = Math.max(...lans);
  while (min <= max) {
    let mid = Math.floor((max + min) / 2);
    let count = 0;
    lans.forEach((v) => {
      count += Math.floor(v / mid);
    });
    if (count >= K) {
      if (mid > answer) answer = mid;
      min = mid + 1;
    } else {
      max = mid - 1;
    }
  }
  return answer;
}

console.log(solution(11, [802, 743, 457, 539]));
/*
    자바스크립트로 풀다보니 백준문제를 푸는데 어려움이 있어 프로그래머스 방식이라고 생각하고 풀었습니다.
    (백준은 node.js만 지원하는데 node.js는 scanner가 없어 다른 특정한 파일에 테스트케이스를 저장하고 이를 fs모듈로 읽어온 뒤 문자열로 파싱해주어야 풀기 시작할 수 있기에 제출 코드와 테스트 코드도 다르다보니 불편함이 많습니다..)

    이 문제는 이분탐색문제였습니다.
    이분탐색으로 푸니 랜선중 가장 큰 크기의 랜선을 max로 정하고 1을 min으로 정했습니다.
    이후 중간값을 mid로 정한 뒤 mid의 범위를 줄여가며 결과를 구할 수 있었습니다.
*/
