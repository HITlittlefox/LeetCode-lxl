package 数据结构知识点;

import java.math.BigInteger;

import org.junit.Test;

public class test {

    public static void main(String[] args) {
        // char temp = 'X';
        // temp = Character.toLowerCase(temp);
        // temp = (char) (temp + 1);
        // System.out.println("temp:" + temp);
        char c = '2';
        System.out.println(c >= '0' && c <= '9' ? true : false);
    }

    @Test
    public void Integer十进制2其他() {
        int n = 13;
        Integer.toHexString(n);
        System.out.println(n + "的二进制是:" + Integer.toBinaryString(n));
        System.out.println(n + "的八进制是:" + Integer.toOctalString(n));
        System.out.println(n + "的十六进制是" + Integer.toHexString(n));
        System.out.println(n + "的三进制是:" + Integer.toString(n, 3));
    }

    @Test
    public void IntegervalueOf其他2十进制() {
        String str = new String("1001011");
        System.out.println("二进制数" + str + "的十进制数为：" + Integer.valueOf(str, 2));
        str = "123";
        System.out.println("八进制数" + str + "的十进制数为：" + Integer.valueOf(str, 8));
        str = "ffee23";
        System.out.println("十六进制数" + str + "的十进制数为：" + Integer.valueOf(str, 16));
    }

    @Test
    public void IntegerparseInt其他2十进制() {
        String str = new String("1001011");
        System.out.println("二进制数" + str + "的十进制数为：" + Integer.parseInt(str, 2));
        str = "123";
        System.out.println("八进制数" + str + "的十进制数为：" + Integer.parseInt(str, 8));
        str = "ffee23";
        System.out.println("十六进制数" + str + "的十进制数为：" + Integer.parseInt(str, 16));
    }

    @Test // 16进制数 abcdef123 转换成8进制数为：527467570443
    public void BigInteger进制转换() {
        String string = new String("abcdef123");
        int base = 16;
        int to = 8;
        System.out.println(base + "进制数 " + string + " 转换成" + to + "进制数为：" + new BigInteger(string, base).toString(to));
    }
}
