import java.util.*;

public class BJ_11659 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		//int[] Narr = new int[N];
		long[] sumArr = new long[N+1];
		
		/* [시간초과] 
		for (int i = 0; i < N; i++) {
			Narr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < M; i++) {
			int iStart = sc.nextInt();
			int iEnd = sc.nextInt();
			int sum = 0;
			for (int j = iStart-1; j < iEnd; j++) {
				sum += Narr[j];
			}
			sumArr[i] = sum;	
		}
		
		for (int i = 0; i < M; i++) {
			System.out.println(sumArr[i]);
		}
		*/
		
		for (int i = 1; i <= N; i++) {
			if(i == 1)
				sumArr[i] = sc.nextLong();
			else
				sumArr[i] = sumArr[i-1] + sc.nextLong();
		}
		
		for (int i = 0; i < M; i++) {
			int iStart = sc.nextInt();
			int iEnd = sc.nextInt();
			System.out.println(sumArr[iEnd]-sumArr[iStart-1]);
		}
		
	}

}
