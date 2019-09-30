package goorm.wadiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제)
 *
 * 동전 N개가 랜덤하게 앞(H) 뒤(T)로 놓여져 있을 때, 연속된 K개의 동전을 동시에 뒤집어서 모든 동전이 앞면(H)으로 나오는 최소한의 뒤집기 회수를 출력하시오.
 *
 *
 *
 * 입출력)
 *
 * 입력
 *
 * 각 라인은 문자열과 K값이 comma로 구분된다
 * 문자열은 동전 앞/뒤를 표시하는 H/T로 구성된 길이 N의 문자열이다.
 * K값은 한번에 뒤집어야 하는 연속된 동전의 숫자를 의미한다.
 * 여러 개의 문제가 입력이 가능하여야 한다.
 * 출력
 *
 * 주어진 문제항목을 만족하는 최소 뒤집기 회수를 출력한다.
 * 문제항목이 이미 모두 앞면일 경우 0을 출력한다.
 * 문제항목으로 모두 앞면이 나오는 것이 불가능 할 경우 대문자 X를 출력한다.
 * 입력된 문제의 개수만큼 출력이 되어야 한다.
 * 설명)
 *
 * 주어진 문자열이 TTTHTHHT 이고, K 값이 3일 경우
 *
 * 처음 3개의 동전을 뒤집는다. 결과 = HHHHTHHT
 * 다섯번째부터 3개의 동전을 뒤집는다. 결과 = HHHHHTTT
 * 맨 끝의 동전 3개를 뒤집는다. 결과 = HHHHHHHH
 * 모든 동전이 앞면이므로 최소 뒤집기 회수 3을 출력한다.
 * 주어진 문자열이 HHHHH 이고, K 값이 4 일 경우
 *
 * 이미 모든 동전이 앞면이므로 최소 뒤집기 회수 0을 출력한다.
 * 주어진 문자열이 THTHT 이고 K의 값이 4일 경우
 *
 * 처음 4개의 동전을 뒤집는다. 결과 = HTHTT
 * 두번째 동전을 뒤집는다고 해도 세번째 동전을 뒤집을 수가 없다. 결과 = HHTHH
 * 문제 해결이 불가능 하므로 X를 출력한다.
 *
 *
 * [입력]
 *
 * TTTHTHHT,3
 *
 * HHHHH,4
 *
 * THTHT,4
 *
 *
 *
 * [출력]
 *
 * 3
 *
 * 0
 *
 * X
 */
public class One {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<char[]> coinList = new ArrayList<>();
        List<Integer> kList = new ArrayList<>();

        while (true) {
            String input = br.readLine();
            if(input == null || input.trim().length() == 0) break;

            String[] inputs = input.split(",");
            coinList.add(inputs[0].toCharArray());
            kList.add(Integer.parseInt(inputs[1]));
        }

        br.close();

        for(int i=0; i<coinList.size(); i++) {
            new One().solution(coinList.get(i), kList.get(i));
        }
    }

    public void solution(char[] coins, final int K) {
        int flipCnt = 0;
        boolean xFlag = false;
        for(int i=0; i<coins.length; i++) {

            if(coins[i] == 'T' && coins.length >= i+K) {
                xFlag = false;
                int chCnt = K;

                //K만큼 연속 뒤집기
                for(int j=i; j<coins.length && chCnt>0; j++) {
                    coins[j] = coins[j] == 'T' ? 'H' : 'T';
                    chCnt--;
                    if(coins[j] == 'T') xFlag = true;
                }
                flipCnt++;
            }
            if(coins[i] == 'T') xFlag = true;
        }

        System.out.println(xFlag ? "X" : flipCnt);
    }
}
