package programmers;

public class P42839 {
    public static void main(String[] args) {
        new P42839().solution("17");
    }

    public int solution(String numbers) {
        int answer = 0;
        int[] nums = new int[numbers.length()];

        for(int i=0; i<numbers.length(); i++) {
            nums[i] = numbers.charAt(i)-48;
            if(checkSosu(nums[i])) answer++;
        }

        return answer;
    }

    boolean checkSosu(int num) {
        for(int i=2; i<num-1; i++) {
            if(num%i == 0) {
                return false;
            }
        }

        return true;
    }

}
