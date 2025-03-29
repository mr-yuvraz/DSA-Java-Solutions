class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public CircularQueue(int k) {
        capacity = k;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(3);
        System.out.println(cq.enQueue(1)); // true
        System.out.println(cq.enQueue(2)); // true
        System.out.println(cq.enQueue(3)); // true
        System.out.println(cq.enQueue(4)); // false (full)
        System.out.println(cq.Rear()); // 3
        System.out.println(cq.isFull()); // true
        System.out.println(cq.deQueue()); // true
        System.out.println(cq.enQueue(4)); // true
        System.out.println(cq.Rear()); // 4
    }
}
