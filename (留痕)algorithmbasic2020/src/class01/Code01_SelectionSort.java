package class01;

import java.util.Arrays;

public class Code01_SelectionSort {

    // TODO:选择排序
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ N-1 找到最小值，在哪，放到0位置上
        // 1 ~ n-1 找到最小值，在哪，放到1 位置上
        // 2 ~ n-1 找到最小值，在哪，放到2 位置上
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // i ~ N-1 上找最小值的下标
                // 找到最小值给minIndex
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
