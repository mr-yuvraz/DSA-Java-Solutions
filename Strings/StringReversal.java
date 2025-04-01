public class StringReversal {
    // Function to reverse a string
    public static String reverseString(String s) {
        // Using StringBuilder to reverse the string
        StringBuilder reversed = new StringBuilder(s);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println("Original String: " + s);
        System.out.println("Reversed String: " + reverseString(s));
        
        s = "world";
        System.out.println("Original String: " + s);
        System.out.println("Reversed String: " + reverseString(s));
    }
}
