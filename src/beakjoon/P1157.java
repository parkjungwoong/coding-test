import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 *
 * 입력
 * 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
 *
 * 출력
 * 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 */
public class P1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //65~90 / 97 ~112, 대소문자 차이는 +32
        int[] alphabets = new int[91];

        int input = 0;

        //10은 개행
        while (input != 10) {
            input = br.read();

            if(input >= 97) input -= 32;

            alphabets[input]++;
        }

        br.close();

        int max = alphabets[65];
        int maxAplhabet = 65;

        for(int i=66; 91>i; i++){
            if(alphabets[i] > max){
                max = alphabets[i];
                maxAplhabet = i;
            } else if(alphabets[i] == max){
                maxAplhabet = 63;
            }
        }

        System.out.println((char)maxAplhabet);
    }
}
