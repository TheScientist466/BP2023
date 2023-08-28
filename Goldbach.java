import java.util.Scanner;

public class Goldbach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int k = sc.nextInt();
        if (k % 2 != 0 || k < 3 + 3) {
            System.out.println("not Goldbatch number.");
            System.exit(0);
        }
        for (int i = 3; i <= k / 2; i += 2) {
            if (isPrime(i) && isPrime(k - i)) {
                System.out.println("(" + i + ", " + (k - i) + ")");
            }
        }
    }

    static boolean isPrime(int x) {
        if(x < 2)
            return false;
        if(x == 2)
            return true;
        if(x % 2 == 0)
            return false;
        for(int i = 3; i <= Math.sqrt(x); i += 2) {
            if(x % i == 0)
                return false;
        }
        return true;
    }
}
