import java.util.Scanner;

public class P1924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String[] DATE = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int x = sc.nextInt();
        int y = sc.nextInt();

        final int[] totalDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int dayCount = 0;
        for(int i=1; x>i; i++){
            dayCount += totalDay[i-1];
        }

        dayCount += y;

        System.out.println(DATE[dayCount%7]);

    }
}
