package sort;

/**
 * @ClassName ShellSort
 * @Author ZhuGuangLiang <786945363@qq.com>
 * @Date 2022/05/17 22:10
 */
public class ShellSort {
	public static void shellSort(int[] arr) {
		int length = arr.length;
		int temp;
		for (int step = length / 2; step >= 1; step /= 2) {
			for (int i = step; i < length; i++) {
				temp = arr[i];
				int j = i - step;
				while (j >= 0 && arr[j] > temp) {
					arr[j + step] = arr[j];
					j -= step;
				}
				arr[j + step] = temp;
			}
		}
	}
}
