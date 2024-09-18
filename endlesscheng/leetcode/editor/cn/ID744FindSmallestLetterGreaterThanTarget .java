package endlesscheng.leetcode.editor.cn;

class ID744FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        Solution solution = new ID744FindSmallestLetterGreaterThanTarget().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试
        //sb.append(solution.   );
        System.out.println('a' + 0);

        System.out.println('a' + 1);

        System.out.println(sb);
    }

    /**
     * 时间复杂度 O()
     * 空间复杂度 O()
     **/

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            // 2. 第一个大于x的下标：可以转换为`第一个大于等于 x+1 的下标` ，low_bound(x+1)

            return letters[lowBound(letters, target)];
        }

        public int lowBound(char[] letters, char target) {
            int targetPlusOne = target + 1;
            int maxLength = letters.length - 1;
            int left = 0, right = letters.length - 1;

            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (letters[middle] < targetPlusOne) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            return left > maxLength ? 0 : left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
