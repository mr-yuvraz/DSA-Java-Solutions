import java.util.Scanner;

public class MergeSort { // Merge Sort function public static void mergeSort(int[] arr, int left, int right) { if (left < right) { int mid = left + (right - left) / 2;

// Recursively divide the array
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        
        // Merge sorted halves
        merge(arr, left, mid, right);
    }
}

// Merge function
public static void merge(int[] arr, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    // Copy data to temp arrays
    for (int i = 0; i < n1; i++)
        leftArray[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
        rightArray[j] = arr[mid + 1 + j];

    // Merge the arrays
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (leftArray[i] <= rightArray[j]) {
            arr[k] = leftArray[i];
            i++;
        } else {
            arr[k] = rightArray[j];
            j++;
        }
        k++;
    }

    // Copy remaining elements
    while (i < n1) {
        arr[k] = leftArray[i];
        i++;
        k++;
    }
    while (j < n2) {
        arr[k] = rightArray[j];
        j++;
        k++;
    }
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

    mergeSort(arr, 0, n - 1);

    System.out.println("Sorted array: ");
    for (int num : arr) {
        System.out.print(num + " ");
    }
    scanner.close();
}

}
