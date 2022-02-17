// https://leetcode.com/problems/3sum/
let threeSum = function (nums) {
  nums.sort((a, b) => a - b); // 받은 배열 내림차순정렬
  let answer = [];
  for (let i = 0; i < nums.length - 2; i++) {
    if (nums[i] > 0) break; // 이미 정렬했기때문에 lt역할을 할 부분이 0을 넘어가면 리턴해버립니다.
    if (i > 0 && nums[i] === nums[i - 1]) continue; // 값이 연속되면 넘겨버립니다.
    let lt = i + 1; // left포인터
    let rt = nums.length - 1; // right포인터
    while (lt < rt) {
      let sum = nums[i] + nums[lt] + nums[rt]; // 더한 값 확인
      if (sum > 0) rt--;
      // 더 클 경우 큰 수를 담당하는 오른쪽포인터가 문제이기에 rt--;
      else if (sum < 0) lt++;
      // 위와 같은 논리로 작으면 lt++;
      else {
        answer.push([nums[lt], nums[i], nums[rt]]); // 결과 저장
        while (lt < rt && nums[lt] === nums[lt + 1]) lt++; // 값이 중복되는경우를 막기 위한 코드
        while (lt < rt && nums[rt] === nums[rt - 1]) rt++;
        lt++;
        rt--;
      }
    }
  }
  return answer;
};

console.log(threeSum([-1, 0, 1, 2, -1, -4]));

/*
    투포인터를 이용하여 풀 수 있는 문제였습니다.
    받은 배열 먼저 내림차순으로 정렬한 뒤 lt와 rt를 정해둔 채로 i를 탐색해가는 방법으로 풀었습니다.
    배열이 중복되지 않도록 풀어야 하기 떄문에 중간에 같은 값을 피할때까지 while문을 돌려줍니다.
    먼저 정렬하고 시작했기 때문에 lt부분이 양수를 넘어가면 0이나올확률이 없기에 리턴해버립니다.
*/
