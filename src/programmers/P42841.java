package programmers;

/**
 * 숫자 야구
 * https://programmers.co.kr/learn/courses/30/lessons/42841
 */
public class P42841 {
    public static void main(String[] args) {

        int[][] baseball = new int[][]{ {123,1,1}, {356,1,0}, {489,0,1} };

        int solution = new P42841().solution(baseball);

        System.out.println("s => "+solution);
    }

    public int solution(int[][] baseball) {
        int answer = 0;
        //모든 경우의 수를 대입해서 카운트 후 반환
        for(int a=1; a<10; a++) {
            for(int b=1; b<10; b++) {
                for(int c=1; c<10; c++) {
                    //모든 자리수가 다를 때
                    if(a != b && b != c && a != c) {
                        answer += isAnswer(a*100+b*10+c, baseball) ? 1 : 0;
                    }
                }
            }
        }

        return answer;
    }

    boolean isAnswer(int num, int[][] baseball) {
        int cnt = 0;

        for(int[] e : baseball) {

            int q = e[0];
            int s = e[1];
            int b = e[2];
            cnt +=  strike(num, q) == s && ball(num, q) == b ? 1 : 0;
        }

        return cnt == baseball.length;
    }

    //숫자와 자리까지 모두 맞을 때 카운트
    int strike(int num, int q) {
        int cnt = 0;

        cnt += (num/100)%10 == (q/100)%10 ? 1 : 0;
        cnt += (num/10)%10 == (q/10)%10 ? 1 : 0;
        cnt += num%10 == q%10 ? 1 : 0;

        return cnt;
    }

    //숫자만 맞아도 카운트
    int ball(int num, int q) {
        int cnt = 0;

        int[] qArr = new int[3];
        qArr[0] = (q/100)%10;
        qArr[1] = (q/10)%10;
        qArr[2] = q%10;

        int[] nArr = new int[3];
        nArr[0] = (num/100)%10;
        nArr[1] = (num/10)%10;
        nArr[2] = num%10;

        for(int i=0; i<qArr.length; i++) {
            for(int j=0; j<nArr.length; j++) {
                if(i != j && qArr[i] == nArr[j]) cnt ++;
            }
        }

        return cnt;
    }

}
