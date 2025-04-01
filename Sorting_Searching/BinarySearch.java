import java.util.Scanner;

public class BinarySearch { // Iterative Binary Search public static int binarySearchIterative(int[] arr, int target) { int left = 0, right = arr.length - 1; while (left <= right) { int mid = left + (right - left) / 2; if (arr[mid] == target) return mid; // Target found if (arr[mid] < target) left = mid + 1; else right = mid - 1; } return -1; // Target not found }

// Recursive Binary Search
public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
    if (left > right)
        return -1; // Base case: target not found

    int mid = left + (right - left) / 2;
    if (arr[mid] == target)
        return mid;
    if (arr[mid] < target)
        return binarySearchRecursive(arr, mid + 1, right, target);
    else
        return binarySearchRecursive(arr, left, mid - 1, target);
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of elements: ");
    int n = scanner.nextInt();
    int[] arr = new int[n];

    System.out.println("Enter sorted elements: ");
    for (int i = 0; i < n; i++) {
        arr[i] = scanner.nextInt();
    }

    System.out.print("Enter the target element: ");
    int target = scanner.nextInt();

    int resultIterative = binarySearchIterative(arr, target);
    int resultRecursive = binarySearchRecursive(arr, 0, arr.length - 1, target);

    if (resultIterative != -1)
        System.out.println("Element found at index (Iterative): " + resultIterative);
    else
        System.out.println("Element not found (Iterative)");

    if (resultRecursive != -1)
        System.out.println("Element found at index (Recursive): " + resultRecursive);
    else
        System.out.println("Element not found (Recursive)");

    scanner.close();
}

}
