import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Integer, Integer> magazineMap = new HashMap<>();
        for (char perChar : magazine.toCharArray()) {
            int key = perChar - 'a';
            if (!magazineMap.containsKey(key)) {
                magazineMap.put(key, 1);
            } else {
                magazineMap.put(key, magazineMap.get(perChar - 'a') + 1);

            }
        }

        // 用magazine 去 构成ransomNote 

        for (char perChar : ransomNote.toCharArray()) {
            // if(perChar==)
            int key = perChar - 'a';
            if (!magazineMap.containsKey(key) || magazineMap.get(perChar - 'a') == 0) {
                return false;
            } else {
                magazineMap.put(key, magazineMap.get(perChar - 'a') - 1);
            }

        }

        System.out.println(magazineMap.toString());

        return true;
    }
}
// @lc code=end
