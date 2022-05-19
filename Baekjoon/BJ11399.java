import java.util.Arrays;
import java.util.Scanner;

public class BJ11399 {

	public static void main(String[] args) {
		
		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		
		int[] P = new int[N];
		
		for (int i = 0; i < N; i++) {
			P[i] = SC.nextInt();
		}
		
		Arrays.sort(P);
		
		int sum = 0;
		int temp = 0;
		
		for (int i = 0; i < P.length; i++) {		
			temp += P[i];			
			sum += temp;					
		}
		
		System.out.println(sum);

	}

}
