import java.util.Scanner;

class FactorialBacktracking {
    public static int factorial(int n, int product) {
        if (n == 1 || n == 0) return product;  // Base case
        return factorial(n - 1, product * n);  // Recursive call with backtracking
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Factorial of " + num + " is: " + factorial(num, 1));
        sc.close();
    }
}
