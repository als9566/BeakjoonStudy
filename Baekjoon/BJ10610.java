import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ10610 {

	public static void main(String[] args) {
		
		Scanner SC = new Scanner(System.in);
		
		// N는 최대 10의5승개의 숫자로 구성되어있으므로
		// String 타입으로 받을 수 밖에 없다.
		String N = SC.next();
		// 받은 숫자를 담을 Integer 배열
		Integer[] Arr = new Integer[N.length()];
		
		int sum = 0;
		
		// String으로 받은 숫자를 Integer배열에 담아준다.
		for (int i = 0; i < Arr.length; i++) {
			Arr[i] = Integer.parseInt(N.substring(i, i+1));
			sum += Arr[i];
		}
		
		// 내림차순 정렬
		Arrays.sort(Arr, Collections.reverseOrder());
		
		//1. 마지막 자리수가 0이 아니면 30의 배수가 될 수 없음.
		//2. 모든 자리수의 합이 3의 배수가 아니면 30의 배수가 될 수 없음.
		if (Arr[Arr.length-1] != 0 || sum % 3 != 0) {
			System.out.println("-1");
			return;
		}
		
		// 출력
		for (int i = 0; i < Arr.length; i++) {
			System.out.print(Arr[i]);
		}

	}

}
