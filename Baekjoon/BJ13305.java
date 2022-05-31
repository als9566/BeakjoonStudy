import java.util.Scanner;

public class BJ13305 {

	public static void main(String[] args) {
		
		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		
		long[] kmArr = new long[N-1];		
		long[] coinArr = new long[N];
		
		for (int i = 0; i < N-1; i++) {
			kmArr[i] = SC.nextInt();
		}
		for (int i = 0; i < N; i++) {
			coinArr[i] = SC.nextInt();
		}
		
		long tempCoin = coinArr[0];
		long minCoin = coinArr[0]*kmArr[0];
		
		for (int i = 1; i < N-1; i++) {
			if(tempCoin > coinArr[i]) {
				tempCoin = coinArr[i];
			}
			minCoin += tempCoin*kmArr[i];
		}
		
		System.out.println(minCoin);

	}

}
