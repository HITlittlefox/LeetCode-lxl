package class05;

// 测试链接：https://leetcode.com/problems/divide-two-integers
public class Code03_BitAddMinusMultiDiv {

	public static int add(int a, int b) {
		int sum = a;
		while (b != 0) {
			// 无进位相加信息 -> sum
			sum = a ^ b;
			// 进位信息 -> b-> b'
			b = (a & b) << 1;
			// a -> a' 无进位相加信息
			a = sum;
		}
		return sum;
	}

	public static int negNum(int n) {
		return add(~n, 1);
	}

	public static int minus(int a, int b) {
		return add(a, negNum(b));
	}

	public static int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			if ((b & 1) != 0) {
				res = add(res, a);
			}
			a <<= 1;
			b >>>= 1;
		}
		return res;
	}

	public static boolean isNeg(int n) {
		return n < 0;
	}

	public static int div(int a, int b) {
		// 正数绝对值的形式
		int x = isNeg(a) ? negNum(a) : a;
		// 正数绝对值的形式
		int y = isNeg(b) ? negNum(b) : b;
		int res = 0;
		// x/y x非负，不用去试右移31位
		for (int i = 30; i >= 0; i = minus(i, 1)) {
			if ((x >> i) >= y) {
				res |= (1 << i);
				x = minus(x, y << i);
			}
		}
		return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
	}

	public static int divide(int a, int b) {
		if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
			return 1;
		} else if (b == Integer.MIN_VALUE) {
			return 0;
		} else if (a == Integer.MIN_VALUE) {
			if (b == negNum(1)) {
				return Integer.MAX_VALUE;
			} else {
				// a/b
				// (a+1)/b == c
				// a - (b*c) = d
				// d/b = e
				// c + e

				int c = div(add(a, 1), b);
				return add(c, div(minus(a, multi(c, b)), b));
			}
		} else {
			return div(a, b);
		}
	}

}
