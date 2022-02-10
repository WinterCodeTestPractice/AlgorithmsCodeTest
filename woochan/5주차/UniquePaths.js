// https://leetcode.com/problems/unique-paths/
let uniquePaths = function (m, n) {
  let arr = Array.from({ length: m }, () => Array(n).fill(0));
  arr[0][0] = 1;
  for (let i = 0; i < n; i++) {
    for (let k = 0; k < m; k++) {
      if (i === 0 || k === 0) arr[k][i] = 1;
      else arr[k][i] = arr[k - 1][i] + arr[k][i - 1];
    }
  }

  return arr[m - 1][n - 1];
};

console.log(uniquePaths(3, 7));

// 첫 시도는 DFS로 해보았으나 시간초과가 나버렸고, 백트래킹과 메모이제이션으로 풀어보려 하였으나 뜻대로 풀리지 않았습니다.
// [i][k]가 [k-1][i]+[k][i-1]임을 이용하여 풀 수 있는 DP문제였습니다.
