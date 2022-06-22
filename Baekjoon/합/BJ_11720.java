import java.util.*;

public class BJ_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //숫자의 개수
		String sNum = sc.next(); // N은 최대 100이기 때문에 int,long으로 받을 수 없으므로 String
		char[] cNum = sNum.toCharArray(); // 받은 문자열(숫자)을char 배열로 변환
		
		int sum = 0;
		for (int i = 0; i < cNum.length; i++) {
			sum += cNum[i] -'0'; 
		}
		System.out.println(sum);

	}

}
