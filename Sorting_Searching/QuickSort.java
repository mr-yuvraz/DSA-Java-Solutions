import java.util.Scanner;

public class QuickSort { // QuickSort function public static void quickSort(int[] arr, int low, int high) { if (low < high) { int pivotIndex = partition(arr, low, high);

// Recursively sort elements before and after partition
        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }
}

// Partition function
public static int partition(int[] arr, int low, int high) {
    int pivot = arr[high]; // Choosing the last element as pivot
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return i + 1;
}

// Swap function
public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter number of elements: ");
    int n = scanner.nextInt();
    int[] arr = new int[n];

    System.out.println("Enter the elements: ");
    for (int i = 0; i < n; i++) {
        arr[i] = scanner.nextInt();
    }

    quickSort(arr, 0, n - 1);

    System.out.println("Sorted array: ");
    for (int num : arr) {
        System.out.print(num + " ");
    }
    scanner.close();
}

}
