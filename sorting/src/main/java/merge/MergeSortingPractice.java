package merge;

import base.BaseSorting;
import base.ISorting;

public class MergeSortingPractice extends BaseSorting implements ISorting {

	@Override
	public void sort(int[] data) {
		if (data != null && data.length > 1) {
			mergeSort(data, 0, data.length - 1);
		}
	}

	private void mergeSort(int[] data, int l, int h) {
		int m = (l + h) / 2;
		if (l < h) {
			mergeSort(data, l, m);
			mergeSort(data, m + 1, h);
			merge(data, l, m, h);
		}
	}

	private void merge(int[] data, int l, int m, int h) {
		int[] temp = new int[h - l + 1];

		int i = l;
		int j = m + 1;
		int k = 0;
		while (i <= m && j <= h) {
			if (data[i] < data[j]) {
				temp[k++] = data[i++];
			} else {
				temp[k++] = data[j++];
			}
		}

		// 把左边剩余的数移入数组
		while (i <= m) {
			temp[k++] = data[i++];
		}

		// 把右边边剩余的数移入数组
		while (j <= h) {
			temp[k++] = data[j++];
		}

		// 把新数组中的数覆盖nums数组
		for (int index = 0; index < temp.length; index++) {
			data[index + l] = temp[index];
		}
	}

}
