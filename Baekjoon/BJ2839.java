import java.util.Scanner;

public class BJ2839 {

	public static void main(String[] args) {
		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		int cnt = 0;
		
		while(N > 0) {
			if(N%5 == 0) {
				cnt = N/5 + cnt;
				break;
			}
			N = N-3;
			cnt += 1;
		}
		
		if(N >= 0) 
			System.out.println(cnt);
		else
			System.out.println(-1);
			
	}

}
