import java.util.Scanner;

public class UseQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Queue : ");
        int s = sc.nextInt();
        Queue q = new Queue(s);
        boolean toTerminate = false;
        while(!toTerminate) {
            System.out.println("1. EnQueue\n2. DeQueue\n3. Display\n4. Terminate");
            System.out.print("Enter choice : ");
            int ch = sc.nextInt();
            switch(ch) {
                case 1:
                    System.out.print("Enter value to enqueue : ");
                    q.enQueue(sc.nextInt());
                    break;
                case 2:
                    System.out.println(q.deQueue());
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    toTerminate = true;
                    break;
            }
        }
    }
}
