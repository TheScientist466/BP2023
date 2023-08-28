// Deque implementation in Java

class DQueue {
    //static final int MAX = 100;
    int arr[];
    int front;
    int rear;
    int size;

    public DQueue(int _size)
    {
        front = -1;
        rear = 0;
        size = _size;
        arr = new int[size];
    } //end of constructor

    boolean isFull()
    {
        return ((front == 0 && rear == size - 1) || front == rear + 1);
    } //end of isFull

    boolean isEmpty() {
        return (front == -1);
    }//end of isEmpty

    void insertfront(int key)
    {
        if (isFull())
        {
            System.out.println("Overflow");
            return;
        }

        if (front == -1)
        {
            front = 0;
            rear = 0;
        }

        else if (front == 0)
            front = size - 1;

        else
            front = front - 1;

        arr[front] = key;
    } //end of insertfront(int)

    void insertrear(int key)
    {
        if (isFull())
        {
            System.out.println(" Overflow ");
            return;
        }

        if (front == -1)
        {
            front = 0;
            rear = 0;
        }

        else if (rear == size - 1)
            rear = 0;

        else
            rear = rear + 1;

        arr[rear] = key;
    } //end of insertrear(int)

    void deletefront()
    {
        if (isEmpty())
        {
            System.out.println("Queue Underflow\n");
            return;
        }

        // Deque has only one element
        if (front == rear)
        {
            front = -1;
            rear = -1;
        } else if (front == size - 1)
            front = 0;

        else
            front = front + 1;
    } //end of delete front

    void deleterear()
    {
        if (isEmpty())
        {
            System.out.println(" Underflow");
            return;
        }

        if (front == rear)
        {
            front = -1;
            rear = -1;
        }
        else if (rear == 0)
            rear = size - 1;
        else
            rear = rear - 1;
    } //end of deleterear()

    int getFront()
    {
        if (isEmpty())
        {
            System.out.println(" Underflow");
            return -1;
        }
        return arr[front];
    }//end of getFront

    int getRear()
    {
        if (isEmpty() || rear < 0)
        {
            System.out.println(" Underflow\n");
            return -1;
        }
        return arr[rear];
    }//end of getRear
}