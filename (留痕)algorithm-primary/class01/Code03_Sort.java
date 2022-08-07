package class01;

public class Code03_Sort {

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;
	}

	// 先选择出最小的
	public static void selectSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			int minValueIndex = i;
			for (int j = i + 1; j < N; j++) {
				// 如果j位置的数字比当前最小值位置的数字小，就让j位置变成当前最小值位置
				minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
			}
			swap(arr, i, minValueIndex);
		}
	}

	// 先冒泡出来最大的
	// 冒泡排序每次交换都是相邻的
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 0~n-1
		// 0~n-2
		// 0~n-3
		// 0~n-end
		int N = arr.length;
		for (int end = N - 1; end >= 0; end--) {
			// 0~end 干一坨事
			// 0与1的数需要换吗？ 1与2的数需要换吗？··· end-1和end的数需要换吗？
			for (int second = 1; second <= end; second++) {
				// 如果第一个数>第二个数
				if (arr[second - 1] > arr[second]) {
					swap(arr, second - 1, second);
				}
			}
		}
	}
	// 插入的前n项是有序的

	public static void insertSort1(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 0~0有序
		// 0~1有序
		// 0~2有序
		// 0~n-1有序
		int N = arr.length;
		for (int end = 1; end < N; end++) {
			int newNumIndex = end;
			while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
				swap(arr, newNumIndex - 1, newNumIndex);
				newNumIndex--;
			}
		}
	}

	// 实现的更漂亮
	public static void insertSort2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		for (int end = 1; end < N; end++) {
			// pre:新数的前一个位置
			for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
				swap(arr, pre, pre + 1);
			}
		}
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 7, 1, 3, 5, 1, 6, 8, 1, 3, 5, 7, 5, 6 };
		printArray(arr);
		insertSort2(arr);
		printArray(arr);
	}

}
