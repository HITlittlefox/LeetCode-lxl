package class08;


public class Code02_MergeSort {

    // 递归方法实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // arr[L...R]范围上，请让这个范围上的数，有序！
    public static void process(int[] arr, int L, int R) {
        // basecase
        if (L == R) {
            return;
        }
        // int mid = (L + R) / 2
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    // M是middle
    public static void merge(int[] arr, int L, int M, int R) {
        // 辅助数组
        int[] help = new int[R - L + 1];
        // i是给help使用的
        int i = 0;
        // p1是左半的指针
        // p2是右半的指针
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            // 两个分支，最终会到左半越界或者右半越界
            // branch1：左半指针指的数<右半指针指的数，把左半指针指的数塞入辅助数组，并把左半指针挪到下一位
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么p1越界，要么p2越界
        // 不可能出现：共同越界

        // 如果右半越界，就把左边剩余的全都塞入辅助数组
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        // 如果左半越界，就把右边剩余的全都塞入辅助数组
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }


    // 步长：1，2，4
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int step = 1;
        int N = arr.length;
        // 步长变化一定是2^n:1-2-4-8
        while (step < N) {
            int L = 0;
            while (L < N) {
                int M = 0;

                // 通过计算长度防止越界
                if (N - L >= step) {
                    M = L + step - 1;
                } else {
                    M = N - 1;
                }
                // 左组：L...M
                if (M == N - 1) {
                    break;
                }

                // 右组：M+1...R
                int R = 0;
                if ((N - 1) - (M + 1) + 1 >= step) {
                    R = M + 1 + step - 1;
                } else {
                    R = N - 1;
                }

                // 此时的左组和右组：L...M M+1...R


                merge(arr, L, M, R);
                if (R == N - 1) {
                    break;
                } else {
                    // 下一个左组
                    L = R + 1;
                }
            }
            // 防止溢出
            // N/2是向下取整，所以不能用等于号=
            if (step > N / 2) {
                break;
            }
            step *= 2;
        }

    }

    // 非递归方法实现
    // 步长：1，2，4

    public static void mergeSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                if (mergeSize >= N - L) {
                    break;
                }
                int M = L + mergeSize - 1;
                int R = M + Math.min(mergeSize, N - M - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort1(arr1);
            mergeSort2(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }

}
