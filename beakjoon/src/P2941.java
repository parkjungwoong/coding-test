import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        int croatiaWordCnt = 0;
        String[] croatiaWord = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        int lo = 0;
        while (lo != -1){
            for(int i=0; croatiaWord.length>i; i++){
                lo = input.indexOf(croatiaWord[i]);

                if(lo != -1) {
                    croatiaWordCnt++;
                    if(lo > 0) {
                        String temp = input.substring(0,lo);
                        input = temp+"|"+input.substring(lo+croatiaWord[i].length());
                    } else {
                        input = input.substring(lo+croatiaWord[i].length());
                    }
                    break;
                }
            }
        }

        input = input.replace("|","");
        System.out.println(croatiaWordCnt+input.length());
    }
}
