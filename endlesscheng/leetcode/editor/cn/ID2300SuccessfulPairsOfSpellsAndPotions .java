package endlesscheng.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

class ID2300SuccessfulPairsOfSpellsAndPotions {
    public static void main(String[] args) {
        Solution solution = new ID2300SuccessfulPairsOfSpellsAndPotions().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试
        //sb.append(solution.   );

        System.out.println(new int[]{0, 1}.length);
        System.out.println("123".length());
        System.out.println(new HashSet<Integer>() {{
            add(1);
            add(2);
        }}.size());

        System.out.println(new char[]{'1', '2', '3'}.length);

        System.out.println(sb);
    }

    /**
     * 时间复杂度 O()
     * 空间复杂度 O()
     **/

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            // 5* 2/3/4/5 >= 7   推理出  x >= 7/5=1.2   得 4
            // 7/1 = 7  0个满足条件 得 0
            // 7/3 = 2.3  3/4/5 满足条件 得 3

            // 转化问题为，potions内找到 第一个 >= success/i (double) 的值 x，并将 n - x得到 药水数目

            int[] res = new int[spells.length];

            // 警告！！！potions 并非有序！！！
            Arrays.sort(potions);
            for (int i = 0; i < res.length; i++) {
                // 向上取整
                int target = (int) Math.ceil((double) success / spells[i]);
                res[i] = potions.length - lowBound(potions, target);
            }

            return res;
        }

        public int lowBound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        //public int[] sortPotions(int[] potions) {
        //    for (int i = 0; i < potions.length; i++) {
        //        for (int j = i + 1; j < potions.length; j++) {
        //            if()
        //        }
        //
        //    }
        //}
    }
//leetcode submit region end(Prohibit modification and deletion)

}
