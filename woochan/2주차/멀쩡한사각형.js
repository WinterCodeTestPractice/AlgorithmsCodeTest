// https://programmers.co.kr/learn/courses/30/lessons/62048
function solution(w, h) {
  let answer = 0;
  let width = w;
  let height = h;
  // w는 이제 최대공약수
  while (h != 0) {
    let tmp = h;
    h = w % h;
    w = tmp;
  }
  let broken = width / w + height / w - 1;
  answer = width * height - broken * w;
  return answer;
}

console.log(solution(8, 12));

/*
      규칙을 찾지 못하면 풀지 못하는 문제였습니다.
      꼭지점끼리 만나는 작은 사각형에서 가로+세로-1 이 지워지는 정사각형인 특징이 있었습니다.
      작은 사각형을 구하기 위해 최대공약수를 구해야 했습ㄴ디ㅏ.
      유클리드호제법을 이용하여 최대공약수를 구한 뒤 가장 작은 사각형의 가로세로를 구하였습니다.
      이 작은 사각형이 반복되는 횟수는 최대공약수만큼 반복되었습니다.
      전체 사각형 개수에서 잘리는 사각형들을 제거하여 문제를 풀 수 있었습니다.
   */
