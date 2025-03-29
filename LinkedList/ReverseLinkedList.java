class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next; // Store next node
            current.next = prev; // Reverse link
            prev = current; // Move prev forward
            current = nextNode; // Move current forward
        }
        return prev; // New head of reversed list
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList reverser = new ReverseLinkedList();
        System.out.println("Original List:");
        printList(head);

        ListNode reversedHead = reverser.reverseList(head);
        System.out.println("Reversed List:");
        printList(reversedHead);
    }
}
