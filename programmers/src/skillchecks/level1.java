package skillchecks;

public class level1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(new Solution2().solution(arr));
    }

    static class Solution {
        public String solution(int num) {
            return num%2 == 0 ? "Even" : "Odd";
        }
    }

    static class Solution2 {
        public double solution(int[] arr) {
            int sum = 0;
            for(int a : arr) {
                sum+=a;
            }
            return (double)sum/arr.length;
        }
    }
}
