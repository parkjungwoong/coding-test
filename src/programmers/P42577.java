package programmers;

/**
 * 전화번호 목록
 */
public class P42577 {
    public static void main(String[] args) {

    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        for(String p : phone_book) {
            for(String p2 : phone_book) {
                if(!p.equals(p2) && p.startsWith(p2)) {
                    return false;
                }
            }
        }

        return answer;
    }

}
