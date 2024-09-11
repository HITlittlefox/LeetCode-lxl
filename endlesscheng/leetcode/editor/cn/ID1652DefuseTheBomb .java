package endlesscheng.leetcode.editor.cn;

import java.util.Arrays;

class ID1652DefuseTheBomb {
    public static void main(String[] args) {
        Solution solution = new ID1652DefuseTheBomb().new Solution();
        StringBuilder sb = new StringBuilder();

        //执行测试
        sb.append(Arrays.toString(solution.decrypt(new int[]{5, 7, 1, 4}, 3)));
        sb.append(Arrays.toString(solution.decrypt(new int[]{2, 4, 9, 3}, -2)));
        sb.append(Arrays.toString(solution.decrypt(new int[]{5, 2, 2, 3, 1}, 3)));
        sb.append(Arrays.toString(solution.decrypt(new int[]{10, 5, 7, 7, 3, 2, 10, 3, 6, 9, 1, 6}, -4)));

        System.out.println(sb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int[] decrypt(int[] code, int k) {
            int n = code.length;
            int temp = 0;

            if (k > 0) {
                // 5714
                // 5714571
                int[] tempIntArr = new int[n + k];
                for (int i = 0; i < n + k; i++) {
                    if (i <= n - 1) {
                        tempIntArr[i] = code[i];
                    } else {
                        int tempI = i - n;
                        tempIntArr[i] = code[tempI];
                    }
                }

                for (int i = 0; i < n + k; i++) {
                    int updateTarget = 0;
                    // updateTarget
                    updateTarget = (i + n - k) % n;
                    // 1
                    temp += tempIntArr[i];
                    // 2
                    if (updateTarget >= 0 && updateTarget < n) {
                        code[updateTarget] = temp;
                    }
                    if (i >= k - 1) {
                        // 3
                        temp -= tempIntArr[i - k + 1];
                    }
                }
                // System.out.println(Arrays.toString(code));
                return code;
            } else if (k == 0) {
                for (int i = 0; i < n; i++) {
                    code[i] = 0;
                }
                // System.out.println(Arrays.toString(code));
                return code;
            } else {
                // ?
                // 932493

                // ,6,9,1,6 10,5,7,7,3,2,10,3,6,9,1,6
                int realK = -k;
                int[] tempIntArr = new int[n + realK];
                for (int i = 0; i < n + realK; i++) {
                    if (i < realK) {
                        int tempI = n - realK + i;
                        tempIntArr[i] = code[tempI];
                    } else {
                        tempIntArr[i] = code[i - realK];
                    }
                }

                // reverse
                int tempL = tempIntArr.length;
                for (int i = 0; i <= (tempL - 1) / 2; i++) {
                    int tempN = tempIntArr[tempL - 1 - i];
                    tempIntArr[tempL - 1 - i] = tempIntArr[i];
                    tempIntArr[i] = tempN;
                }

                // window
                for (int i = 0; i < n + realK; i++) {
                    int updateTarget = 0;
                    // updateTarget
                    updateTarget = (i + n - realK) % n;
                    // 1
                    temp += tempIntArr[i];
                    // 2
                    if (updateTarget >= 0 && updateTarget < n) {
                        code[updateTarget] = temp;
                    }
                    if (i >= realK - 1) {
                        // 3
                        temp -= tempIntArr[i - realK + 1];
                    }
                }

                // reverse
                for (int i = 0; i <= (n - 1) / 2; i++) {
                    int tempN = code[n - 1 - i];
                    code[n - 1 - i] = code[i];
                    code[i] = tempN;
                }
                // System.out.println(Arrays.toString(code));

                return code;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
