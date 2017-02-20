package com.chenxi.algorithm.sort;

/**
 * 快速排序
 * 
 * 快速排序流程：
 * 
 * (1) 从数列中挑出一个基准值。
 * 
 * (2) 将所有比基准值小的摆放在基准前面，所有比基准值大的摆在基准的后面(相同的数可以到任一边)；在这个分区退出之后，该基准就处于数列的中间位置。
 * 
 * (3) 递归地把"基准值前面的子数列"和"基准值后面的子数列"进行排序。
 * 
 * 稳定算法，时间复杂度O(n^2)
 * 
 * @author zhaochx1
 *
 */
public class QuickSort {
	/**
	 * 快速排序
	 * 
	 * @param array
	 *            待排序的数组
	 * @param left
	 *            数组的左边界(例如，从起始位置开始排序，则=0)
	 * @param right
	 *            数组的右边界(例如，排序截至到数组末尾，则array.length-1)
	 */
	private static void quickSort(int[] array, int left, int right) {

		if (left < right) {
			int i, j, x;

			i = left;
			j = right;
			x = array[i];
			while (i < j) {
				while (i < j && array[j] > x)
					j--; // 从右向左找第一个小于x的数
				if (i < j)
					array[i++] = array[j];
				while (i < j && array[i] < x)
					i++; // 从左向右找第一个大于x的数
				if (i < j)
					array[j--] = array[i];
			}
			array[i] = x;
			quickSort(array, left, i - 1); /* 递归调用 */
			quickSort(array, i + 1, right); /* 递归调用 */
		}
	}

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	public static void main(String[] args) {
		int[] array = { 45, 78, 94, 12, 34, 89, 74, 65, 32, 15, 67, 86, 53 };
		quickSort(array);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
