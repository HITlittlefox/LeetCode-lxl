// 辅助数组，
// 遇到正常数字依次填入辅助数组，
// 遇到空格则填入“%20”
/* class Solution {
    // 使用一个新的对象，复制 str，复制的过程对其判断，是空格则替换，否则直接复制，类似于数组复制
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        // 选用 StringBuilder 单线程使用，比较快，选不选都行
        StringBuilder sb = new StringBuilder();
        // 使用 sb 逐个复制 str ，碰到空格则替换，否则直接复制
        for (int i = 0; i < str.length(); i++) {
            // str.charAt(i) 为 char 类型，为了比较需要将其转为和 " " 相同的字符串类型
            // if (" ".equals(String.valueOf(str.charAt(i)))){
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

} */

// 双指针
// 首先扩充数组到每个空格替换成"%20"之后的大小。
// 然后从后向前替换空格，也就是双指针法，过程如下：
// i指向新长度的末尾，j指向旧长度的末尾。
// 遇到正常数字覆盖至后面
// 遇到空格则用“%20”依次覆盖

class Solution {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        // 扩充空间，空格数量2倍
        // 创造额外空间（恰好等于多余的空格数）
        // 每一个' '都要替换为'%20'，也就是添加n+2n个' '
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        // 若是没有空格直接返回
        if (str.length() == 0) {
            return s;
        }
        // 有空格情况 定义两个指针
        int left = s.length() - 1;// 左指针：指向原始字符串最后一个位置
        s += str.toString();
        int right = s.length() - 1;// 右指针：指向扩展字符串的最后一个位置
        char[] chars = s.toCharArray();
        // 从右往左走
        while(left>=0){
            if(chars[left] == ' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else{
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }