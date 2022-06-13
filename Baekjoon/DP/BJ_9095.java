import java.util.*;

public class BJ_9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] testcase = new int[T];
		
		for (int i = 0; i < T; i++) {
			testcase[i] = sc.nextInt();
		}
		
		int[] nCase = new int[12];
		
		
		/*
		 *                  0  1  2  3  4  5  6  7  8
		 *  만들수 있는 방법    0  1  2  4  7    
		 */   
		
		
		nCase[0] = 0;
		nCase[1] = 1;
		nCase[2] = 2;
		nCase[3] = 4;
				
		for (int i = 4; i <= 11; i++) {
			nCase[i] = nCase[i-3] + nCase[i-2] + nCase[i-1];
		}
		
		for (int i = 0; i < T; i++) {
			System.out.println(nCase[testcase[i]]);
		}

	}

}
