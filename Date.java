import java.util.Scanner;
import java.util.StringTokenizer;

public class Date {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first date (DD/MM/YYYY): ");
        String dateInput1 = scanner.nextLine();

        System.out.print("Enter the second date (DD/MM/YYYY): ");
        String dateInput2 = scanner.nextLine();

        int[] date1 = parseDate(dateInput1);
        int[] date2 = parseDate(dateInput2);

        int daysBetween = calculateDaysBetween(date1, date2);

        System.out.println("Number of days between the two dates: " + Math.abs(daysBetween));
    }

    // Parse date string into an array of integers [year, month, day]
    private static int[] parseDate(String dateStr) {
        StringTokenizer t = new StringTokenizer(dateStr, "/");
        int day = Integer.parseInt(t.nextToken());
        int month = Integer.parseInt(t.nextToken());
        int year = Integer.parseInt(t.nextToken());
        return new int[]{year, month, day};
    }

    // Calculate the difference in days between two dates
    private static int calculateDaysBetween(int[] date1, int[] date2)
    {
        int daysInMonth[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int days1 = date1[2] + (date1[1] - 1) * daysInMonth[date1[1]] + date1[0] * 365;
        if (date1[1] <= 2)
        {
            date1[0]--;
            days1 += countLeapYears(date1[0]);
        }
        else
            days1 += countLeapYears(date1[0] + 1);


        int days2 = date2[2] + (date2[1] - 1) * daysInMonth[date2[1]] + date2[0] * 365;
        if (date2[1] <= 2)
        {
            date2[0]--;
            days2 += countLeapYears(date2[0]);
        }
        else
            days2 += countLeapYears(date2[0] + 1);

        return days2 - days1;
    }

    // Count the number of leap years before a given year
    private static int countLeapYears(int year) {
        return year / 4 - year / 100 + year / 400;
    }
}
