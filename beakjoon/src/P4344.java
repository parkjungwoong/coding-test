import java.util.Scanner;

public class P4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalTestCount = sc.nextInt();

        for(int i=0; totalTestCount>i; i++){
            int rowTestCount = sc.nextInt();

            double[] scores = new double[rowTestCount];
            int scoreSum = 0;

            for(int j=0; rowTestCount>j; j++){
                scores[j] = sc.nextDouble();
                scoreSum += scores[j];
            }

            //get avg
            double avg = (double)scoreSum/rowTestCount;

            double overAvgCount = 0;

            for(int j=0; rowTestCount>j; j++){
                if(scores[j] > avg) overAvgCount++;
            }

            System.out.printf("%.3f", 100.0 * overAvgCount / rowTestCount);
            System.out.println("%");
        }
    }
}
