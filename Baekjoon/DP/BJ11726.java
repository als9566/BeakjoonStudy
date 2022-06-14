import java.util.*;

public class BJ11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] way = new int[1001];
		
		way[0] = 0;
		way[1] = 1;
		way[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			way[i] = (way[i-2] + way[i-1])%10007;
		}
		
		
		System.out.println(way[n]);
		
		/*
		 *  처음에 프린트문에서 10007 나머지값을 뿌릴려고 했지만
		 *  틀렸다고 나와 생각해보니 way배열은 int타입이라 데이터 타입을 변경하거나
		 *  10007나머지 값을 넣어줘야 문제가 없었다.
		 *  [데이터 타입에 대해 집중하기!!]
		 */

	}

}
