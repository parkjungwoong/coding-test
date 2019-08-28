import java.util.Scanner;

public class P1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        double[] scores = new double[count];

        double maxScore = 0;

        for(int i=0; count>i; i++){
            scores[i] = sc.nextDouble();
            if(scores[i] >= maxScore) maxScore = scores[i];
        }

        double sum = 0;

        for(int i=0; count>i; i++){
            sum += (scores[i]/maxScore)*100;
        }

        System.out.println(sum/count);


    }
}
