package goorm.korprecard;

import java.util.regex.Pattern;

/**
 *
 대부분의 온라인 서비스는 사용자의 회원가입을 요구하게 된다. 회원가입 뿐만 아니라 서비스제공에 필요한 정보를 사용자로부터 입력 받을 때에는 항상 번거로운 유효성 검사가 필요하다. 일반적으로 입력 창에 사용자에게 요구하는 형식을 명시하지만, 꼭 이런 형식을 지키지 않는 유저가 존재하기 때문이다. 그렇기에 유효성 검사는 번거롭지만 필수적인 과정이다.

 신규 서비스 론칭을 위해 열심히 코딩을 하고 있는 당신의 사수 개발자 동이는 당신에게 아이디와 비밀번호 유효성 검사를 구현해주기를 부탁했다. 사용자가 입력한 아이디, 비밀번호, 확인용 비밀번호가 입력으로 주어진다. 사용자가 아래의 세 가지 규칙에 맞게 정보를 입력했는지 확인하는 프로그램을 작성해주자.

 아이디는 3글자 이상, 20글자 이하의 문자열이어야 하며 알파벳 소문자와 숫자만을 사용해야 한다.
 비밀번호는 8글자 이상, 20글자 이하여야 하며 알파벳 대/소문자, 숫자, 특수기호(!@#$)를 사용할 수 있다.
 알파벳, 숫자, 특수기호는 각각 하나 이상은 반드시 사용되어야 한다.
 비밀번호와 확인용 비밀번호는 일치해야 하며 모두 위의 비밀번호 규칙을 만족해야 한다.


 입력 형식
 입력 데이터는 세 줄로 주어진다.

 첫 줄에는 사용자가 입력한 아이디가 주어진다.

 두 번째 줄에는 사용자가 입력한 비밀번호가 주어진다.

 세 번째 줄에는 사용자가 입력한 확인용 비밀번호가 주어진다.

 모든 정보는 알파벳, 숫자, 특수기호(!@#$)로만 이루어져 있으며 공백을 포함하지 않는다.

 입력 데이터가 100글자를 넘어가는 경우는 존재하지 않는다.



 출력 형식
 사용자가 입력한 정보가 유효한 정보라면 pass를 출력한다. 그렇지 않다면 fail을 출력한다.


 입/출력 예시
 ⋇ 입출력 형식을 잘 지켜주세요.
 ␣ : 공백
 ↵ : 줄바꿈
 −⇥ : 탭
 보기 입력 1
 armygo
 1q2w3e4r!!
 1q2w3e4r!!
 출력 1
 pass

 보기 입력 2
 qlqjs1234Babo
 1234
 1234
 출력 2
 fail

 보기 입력 3
 abc
 Chocolate123!
 Chocolatel23!
 출력 3
 fail

 보기 입력 4
 lovelyz
 jisoo.seo94
 jisoo.seo94
 출력 4
 fail

 *
 */
public class Two {
    public static void main(String[] args) {
        System.out.println(checkId("") && checkPw("","") ? "pass" : "fail");
    }

    public static boolean checkId(String id) {
        //소문자 or 숫자 and 3이상 20이하
        final String ID_PATTERN = "((?=.*[a-z])|(?=.*[0-9])).{3,20}";
        return Pattern.compile(ID_PATTERN).matcher(id).find();
    }

    public static boolean checkPw(final String pw1, final String pw2) {
        if(!pw1.equals(pw2)) return false;

        final String PW_PATTERN = "(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$]).{8,20}";
        return Pattern.compile(PW_PATTERN).matcher(pw1).find()
                && Pattern.compile(PW_PATTERN).matcher(pw2).find();
    }
}
