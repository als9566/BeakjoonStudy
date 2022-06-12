import java.util.Scanner;

public class BJ11047 {
	public static void main(String[] args) {
		
		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		int K = SC.nextInt();
		
		int[] coin = new int[N];
		
		//동전의 종류 N개만큼 입력받음
		for(int i = 0; i < N; i++) {
			coin[i] = SC.nextInt();
		}
		
		int count = 0;
		
		for (int i = N - 1; i >= 0; i--) {
			if(coin[i] <= K) {
				count += (K / coin[i]);
				K = K % coin[i];
			}
		}
		System.out.println(count);
		
	}
}
