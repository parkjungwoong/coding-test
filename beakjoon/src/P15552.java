import java.io.*;

public class P15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bf.readLine());

        String numbers;

        for(int i=0; T>i; i++){
            numbers = bf.readLine();
            int a = Integer.parseInt(numbers.split(" ")[0]);
            int b = Integer.parseInt(numbers.split(" ")[1]);
            bw.write(a+b+"\n");
        }

        bw.flush();
        bw.close();
        bf.close();

    }
}
