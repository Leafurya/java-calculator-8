package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구성
        // 기능 1: 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
        // 기능 2: 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
        // 기능 3: 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
        /* 세부 기능
         * 숫자 추출
         * 덧셈
         * 커스텀 구분자 추출
         * */
        StringCalculator calc = new StringCalculator();

        Console.readLine();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        ArrayList<Integer> numbers = calc.extractNumbers(str);
        int result = calc.addElements(numbers);

        System.out.println("결과 : " + result);
        Console.close();
    }
}

class StringCalculator {
    public static void main(String[] args) {

    }

    private int byteToInt(ArrayList<Byte> buffer) {
        byte[] arr = new byte[buffer.size()];
        for (int i = 0; i < buffer.size(); i++) {
            arr[i] = buffer.get(i);
        }
        return Integer.parseInt(new String(arr));
    }

    public ArrayList<Integer> extractNumbers(String str) {
        // 커스텀 구분자를 추가할 것 까지 생각해서
        byte[] strBytes = str.getBytes();
        ArrayList<Byte> buffer = new ArrayList<Byte>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (byte strByte : strBytes) {
            if (strByte == ',' || strByte == ':') {
                result.add(byteToInt(buffer));
                buffer.clear();
            } else {
                buffer.add(strByte);
            }
        }
        if (!buffer.isEmpty()) {
            result.add(byteToInt(buffer));
        }

        return result;
    }

    public int addElements(ArrayList<Integer> arr) {
        int result = 0;
        for (int num : arr) {
            result += num;
        }
        return result;
    }
}