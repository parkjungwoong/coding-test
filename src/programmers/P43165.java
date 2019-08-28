package programmers;
//타켓 넘버, https://programmers.co.kr/learn/courses/30/lessons/43165
public class P43165 {

    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int index, int num) {
        if(index == numbers.length) {
            if(num == target) answer ++;
        } else {
            dfs(numbers, target, index+1, num + numbers[index]);
            dfs(numbers, target, index+1, num - numbers[index]);
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2,3,7};
        int target = 8;

        int answer = new P43165().solution(numbers, target);
        System.out.println("answer -> "+answer);
    }
}
