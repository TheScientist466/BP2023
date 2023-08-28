import java.util.LinkedList;
import java.util.Scanner;

public class Polynomial {
    private static Scanner sc;
    private static final char[] superScript = {'\u2070', '\u00b9', '\u00b2', '\u00b3', '\u2074', '\u2075', '\u2076', '\u2077', '\u2078', '\u2079'};
    private LinkedList<Integer> l;
    int degree = 0;

    public Polynomial() {
        degree = 0;
        l = new LinkedList<Integer>();
    }

    public Polynomial(int degree){
        this.degree = degree;
        l = new LinkedList<Integer>();
        for(int i = 0; i < degree; i++)
            l.add(0);
    }

    public void getInputs() {
        System.out.println("Enter the coefficients of the polynomial.\nEnter \"done\" when done.");
        while(true) {
            System.out.print("Enter coefficient for x" + getSuperScript(degree) + " : ");
            String str = sc.next();
            if(str.equals("done"))
                return;
            try {
                int num = Integer.parseInt(str);
                l.add(num);
                degree++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
        }
    }

    public void display() {
        for(int i = degree - 1; i >= 0; i--) {
            int coff = l.get(i);
            if(coff != 0) {
                if(i < degree - 1 || coff < 0)
                    System.out.print(coff < 0 ? " - " : " + ");
                if(coff != 1)
                    System.out.print(Math.abs(coff));
                if(i >= 1)
                    System.out.print("x");
                if(i > 1)
                    System.out.print(getSuperScript(i));
            }
        }
        System.out.println();
    }

    private static String getSuperScript(int x) {
        String str = Integer.toString(x);
        for(int i = 0; i < 10; i++) {
            str = str.replaceAll(Integer.toString(i), Character.toString(superScript[i]));
        }
        return str;
    }

    public static Polynomial add(Polynomial left, Polynomial right) {
        Polynomial out = new Polynomial(Math.max(left.degree, right.degree));
        for(int i = 0; i < Math.max(left.degree, right.degree); i++) {
            if(i < left.degree)
                out.l.set(i, out.l.get(i) + left.l.get(i));
            if(i < right.degree)
                out.l.set(i, out.l.get(i) + right.l.get(i));
        }
        return out;
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Polynomial p1 = new Polynomial(), p2 = new Polynomial();
        p1.getInputs();
        System.out.println("\n\n\n");
        p2.getInputs();
        p1.display();
        p2.display();
        add(p1, p2).display();
        sc.close();
    }
}