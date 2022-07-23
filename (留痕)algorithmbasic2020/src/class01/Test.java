package class01;


public class Test {

    public static void main(String[] args) {
        // 如何不需要额外的变量即可实现两个数字的交换，但是特别注意，只有两个变量用的不是同一个内存的时候才可以这样干！
        int a = 10;
        int b = 4;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        // b = a ^ b ^ b = a ^ 0 = a; 运用交换律和结合律
        // a = a ^ b = a ^ b ^ a ^ b ^ b = a ^ a ^ b ^ b ^ b = b; 运用交换律和结合律
        System.out.println("a=" + a + ",b=" + b);
    }


}

