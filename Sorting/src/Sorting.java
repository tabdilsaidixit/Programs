import java.nio.channels.SelectableChannel;

public class Sorting {

	void swap(int arr[], int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	void SelectionSort(int[] unsortedArray) {
		int length = unsortedArray.length;

		for (int i = 0; i < length - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < length; j++) {
				if (unsortedArray[j] < unsortedArray[minIndex]) {
					minIndex = j;
				}
			}
			swap(unsortedArray, i, minIndex);
		}

	}

	void BubbleSort(int[] unsortedArray) {
		int length = unsortedArray.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (unsortedArray[j] > unsortedArray[j + 1]) {
					swap(unsortedArray, j + 1, j);
				}
			}
		}

	}

	void InsertionSort(int[] unsortedArray) {
		int length = unsortedArray.length;

		for (int i = 0; i < length; i++) {
			int currentValue = unsortedArray[i];

			int j = i - 1;
			while (j >= 0 && unsortedArray[j] > currentValue) {
				unsortedArray[j + 1] = unsortedArray[j];
				j--;
			}
			unsortedArray[j + 1] = currentValue;
		}

	}

	void MergeSort(int[] unsortedArray) {
		int length = unsortedArray.length;
		MS(unsortedArray, 0, length - 1);

	}

	void MS(int[] unsortedArray, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			MS(unsortedArray, left, mid);
			MS(unsortedArray, mid + 1, right);
			Merge(unsortedArray, left, mid, right);
		}

	}

	void Merge(int[] unsortedArray, int left, int mid, int right) {
		int[] arr1 = new int[mid - left + 1];
		int[] arr2 = new int[right - mid];

		for (int i = 0; i <= mid - left; i++) {
			arr1[i] = unsortedArray[left + i];
		}
		for (int i = 0; i < right - mid; i++) {
			arr2[i] = unsortedArray[mid + 1 + i];
		}
		
		int check_arr1 = 0;
		int check_arr2 = 0;
		int check_arr = left;
		while(check_arr1<mid - left + 1&&check_arr2<right - mid)
		{
			if(arr1[check_arr1]<arr2[check_arr2])
			{
				unsortedArray[check_arr] = arr1[check_arr1];
				check_arr1++;
				
			}
			else
			{
				unsortedArray[check_arr] = arr2[check_arr2];
				check_arr2++;
			}
			check_arr++;
		}
		while(check_arr1<mid - left + 1)
		{
			unsortedArray[check_arr] = arr1[check_arr1];
			check_arr1++;
			check_arr++;
		}
		while(check_arr2<right - mid)
		{
			unsortedArray[check_arr] = arr2[check_arr2];
			check_arr2++;
			check_arr++;
		}

	}

	void QuickSort(int[] unsortedArray) {

	}

	void HeapSort(int[] unsortedArray) {

	}

	void ShellSort(int[] unsortedArray) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] unsortedArray = new int[] { 10, 7, 8, 9, 5, 1, 4, 3, 6, 2 };
		// new Sorting().SelectionSort(unsortedArray);
		new Sorting().MergeSort(unsortedArray);

		for (int i = 0; i < unsortedArray.length; i++) {
			System.out.print(unsortedArray[i] + " ");
		}
	}

}
