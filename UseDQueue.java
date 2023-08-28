import java.util.Scanner;

public class UseDQueue
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Queue : ");
        int s = sc.nextInt();
        DQueue q = new DQueue(s);
        boolean toTerminate = false;
        while(!toTerminate)
        {
            System.out.println("1. Insert Front\n" +
                    "2. Insert Rear\n" +
                    "3. Delete Front\n" +
                    "4. Delete Rear\n" +
                    "5. Get Front\n" +
                    "6. Get Rear\n" +
                    "7. Terminate");
            System.out.print("Enter choice : ");
            int ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.print("Enter value: ");
                    q.insertfront(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    q.insertrear(sc.nextInt());
                    break;
                case 3:
                    q.deletefront();
                    break;
                case 4:
                    q.deleterear();
                    break;
                case 5:
                    System.out.println(q.getFront());
                    break;
                case 6:
                    System.out.println(q.getRear());
                    break;
                case 7:
                    toTerminate = true;
                    break;
            }
        }
    }
}
