package class01;

// import java.util.Arrays;

import org.junit.Test;

public class Code03_InsertionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 不只1个数
        // 0~0 有序
        // 0~i 有序
        for (int i = 1; i < arr.length; i++) { // 0 ~ i 做到有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

//    public static void MyInsertionSort(int[] arr) {
//        if (arr == null || arr.length < 2) {
//            return;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
//                swap(arr, j, j + 1);
//            }
//
//        }
//    }

    // i和j是一个位置的话，会出错
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    @Test
    public void MyTest() throws Exception {

        System.out.println();
    }

}
