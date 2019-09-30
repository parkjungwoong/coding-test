package programmers.kakao2019;

/**
 * 2문제
 *
 */
public class P33724 {
    public static void main(String[] args) {
        String solution = new P33724().solution("))((()");
        System.out.println("so => "+solution);
    }

    final static char L = '(';
    final static char R = ')';

    public String solution(String p) {
        return chStr(p);
    }

    public String chStr(String str) {
        if(str.length() == 0) return str;
        String[] bStr = getBStr(str);
        String u = bStr[0];
        String v = bStr[1];

        if(isOkStr(u)) {
            return u+chStr(v);
        } else {
            v = chStr(v);
            u = u.substring(1, u.length()-1);

            StringBuilder sb = new StringBuilder();
            sb.append(L);
            sb.append(v);
            sb.append(R);

            for(int i=0; i<u.length(); i++) {
                if(u.charAt(i) == L) sb.append(R);
                else sb.append(L);
            }

            return sb.toString();
        }

    }

    static String[] getBStr(String str) {
        int lCnt = 0;
        int rCnt = 0;

        for(int i=0; i<str.length(); i++) {
            if (str.charAt(i) == L) {
                lCnt++;
            } else {
                rCnt++;
            }

            if(lCnt == rCnt) return new String[]{str.substring(0,i+1), str.substring(i+1)};
        }

        return null;
    }

    static boolean isOkStr(String str) {

        if(str == null || str.length() == 0 || str.charAt(0) == R) return false;

        while(str.length() != 0 && str.length() > 1) {
            if(str.charAt(0) == L && str.charAt(1) != R && str.charAt(str.length()-1) == R) {
                str = str.substring(1, str.length()-1);
            }
            else if(str.charAt(0) == L && str.charAt(1) == R) {
                str = str.substring(2);
            }
            else {
                return false;
            }
        }

        return true;
    }


}
