package class08;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Code03_PartitionAndQuickSort {

    // 版本1：分为两层：<=区和 >区
    // <=区：<=划分值的数，放左边，划分值放<=区最右边
    // >区：>划分值的数，放右边
    public static void splitNum1(int[] arr) {
        // 小于等于区的右边界
        int lessEqualR = -1;
        int index = 0;
        // 最右侧的数
        int mostR = arr.length - 1;
//        int N = arr.length;
        while (index < arr.length) {
            // 1. 如果当前数<= 划分值，当前值和<=区的下一个数交换，≤区右扩，当前数跳到下一个
            // 2. 如果当前数 > 划分值，当前数直接跳到下一个
            if (arr[index] <= arr[mostR]) {
                // swap(arr,i,j):交换arr中位于i与位于j的数
                swap(arr, lessEqualR + 1, index);
                lessEqualR++;
                index++;

//                swap(arr, ++lessEqualR, index++);
            } else {
                index++;
            }
        }
//        swap(arr, moreL, N - 1);
    }

    // 版本2：分为3层：<区，=区，>区
    // <区：<划分值的数，放左边
    // =区：=划分值的数，放中间
    // >区：>划分值的数，放右边
    public static void splitNum2(int[] arr) {
        int N = arr.length;
        // <区 的左边界
        int lessR = -1;
        // >区 的右边界
        int moreL = N - 1;
        int index = 0;
        // arr[N-1]
        // index < >区的左边界
        while (index < moreL) {
            // 划分值arr[N - 1]
            if (arr[index] < arr[N - 1]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[N - 1]) {
                // >区的前一个位置，和当前数做交换，然后>区左扩
                // swap(arr, --moreL, index);
                swap(arr, moreL - 1, index);
                moreL--;

            } else {
                index++;
            }
        }
        // 数组中，>区的第一个位置，和划分值做交换
        swap(arr, moreL, N - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // arr[L...R]范围上，拿arr[R]做划分值，
    // L....R < = >
    // 返回的是[L,R]，把小区域的最小坐标和最大坐标返回
    public static int[] partition(int[] arr, int L, int R) {
        int lessR = L - 1;
        int moreL = R;
        int index = L;
        while (index < moreL) {
            if (arr[index] < arr[R]) {
                // 当前值和小于区的下一个交换，小于区向右扩
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[R]) {
                // 当前值和大于区的前一个交换，大于区向左扩
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        // 最后一个数，也就是划分值，归位
        swap(arr, moreL, R);
        // 小于区的最后一个+1，划分值归位的位置
        return new int[]{lessR + 1, moreL};
    }

    // quickSort 递归版本
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalE = partition(arr, L, R);
        // euqalE[0] 等于区域的第一个数
        // euqalE[1] 等于区域的最后一个数
        process(arr, L, equalE[0] - 1);
        process(arr, equalE[1] + 1, R);
    }

    // 任务类：告诉我任务的左边界，和，任务的右边界
    public static class Job {
        public int L;
        public int R;

        public Job(int left, int right) {
            L = left;
            R = right;
        }
    }

    // quickSort 非递归版本，迭代版本
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        Stack<Job> stack = new Stack<>();
        stack.push(new Job(0, arr.length - 1));
        while (!stack.isEmpty()) {
            Job cur = stack.pop();
            int[] equals = partition(arr, cur.L, cur.R);
            // 有 < 区域的子任务
            if (equals[0] > cur.L) {
                stack.push(new Job(cur.L, equals[0] - 1));
            }
            // 有 > 区域的子任务
            if (equals[1] < cur.R) {
                stack.push(new Job(equals[1] + 1, cur.R));
            }
        }
    }

    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R); // <[R] =[R] >[R]
        return new int[]{less + 1, more};
    }

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    public static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = netherlandsFlag(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, R);
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

    @Test
    public void MyTest() {
        int[] arr = {7, 1, 3, 5, 4, 5, 1, 4, 2, 4, 2, 4};

        splitNum2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // for test
    public static void main(String[] args) {


        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            quickSort1(arr1);
            quickSort2(arr2);
            quickSort3(arr3);
            if (!isEqual(arr1, arr2) || !isEqual(arr1, arr3)) {
                System.out.println("Oops!");
                succeed = false;
                break;
            }
        }
        System.out.println("test end");
        System.out.println(succeed ? "Nice!" : "Oops!");

    }

}
