import java.io.*;

public class P2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int loopCount = Integer.parseInt(bf.readLine());

        for(int i=0; loopCount>i; i++) {
            String[] inputs = bf.readLine().split(" ");
            int strLoopCount = Integer.parseInt(inputs[0]);

            char[] chars = inputs[1].toCharArray();
            for(char c : chars) {
                for(int j=0; strLoopCount>j; j++) {
                    bw.write(c);
                }
            }
            bw.write("\n");
        }

        bf.close();
        bw.flush();
        bw.close();
    }
}
