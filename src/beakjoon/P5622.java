import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalTime = 0;

        int input = br.read();

        while (input != 10) {
            if('A' <= input && 'C' >= input ){
                totalTime += 3;
            } else if('D' <= input && 'F' >= input){
                totalTime += 4;
            } else if('G' <= input && 'I' >= input){
                totalTime += 5;
            } else if('J' <= input && 'L' >= input){
                totalTime += 6;
            } else if('M' <= input && 'O' >= input){
                totalTime += 7;
            } else if('P' <= input && 'S' >= input){
                totalTime += 8;
            } else if('T' <= input && 'V' >= input){
                totalTime += 9;
            } else if('W' <= input && 'Z' >= input){
                totalTime += 10;
            }
            input = br.read();
        }
        br.close();
        System.out.println(totalTime);
    }
}
