package leetcode.editor.test;

/**
 * 给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
 * <p>
 * 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
 * <p>
 * 对于输入字符串 "a5b"，函数应该将其转换为 "anumberb"
 * <p>
 * 输入：一个字符串 s,s 仅包含小写字母和数字字符。
 * <p>
 * 输出：打印一个新的字符串，其中每个数字字符都被替换为了number
 * <p>
 * 样例输入：a1b2c3
 * <p>
 * 样例输出：anumberbnumbercnumber
 * <p>
 * 数据范围：1 <= s.length < 10000。
 */
public class TransferNumber {
    public static void main(String[] args) {
        System.out.println(new TransferNumber().transferNumber("a1b2c3"));
        System.out.println(new TransferNumber().transferNumber("a5b"));
    }


    private String transferNumber(String str) {
        char[] charS = str.toCharArray();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < charS.length; i++) {
            if (Character.isDigit(charS[i]) == false) {
                res.append(charS[i]);
            } else {
                res.append("number");
            }
        }
        return String.valueOf(res);
    }
}
