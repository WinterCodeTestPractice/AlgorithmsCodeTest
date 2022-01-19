package 2-1;

class Solution {

    /**
     * @param w : 너비
     * @param h : 높이
     * @return : 총 삼각형의 넓이 * 2(대각선으로 지나가는 넓이를 제외)
     *
     * 기울기를 알아내서 1차방정식을 구해 각각 i마다의 y(높이)를 구해 answer에 저장
     * y가 소수일 수 있으므로 내림으로 저장.
     */
    public long solution(int w, int h) {
        long answer = 0;
        for (int i=0; i < w; i++) {
            double temp = ((double) h * (double) i) / w;
            answer += (long) temp;
        }
        return answer * 2;
    }
}