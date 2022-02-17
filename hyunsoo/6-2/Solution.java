package 6-2;

import java.util.*;

public class Solution10 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    set.add(List.of(nums[i], nums[left++], nums[right--]));
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] arr = {3,0,-2,-1,1,2};

        List<List<Integer>> a = threeSum(arr);
        System.out.println();
    }
}
