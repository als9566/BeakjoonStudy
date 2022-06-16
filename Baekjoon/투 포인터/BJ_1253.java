import java.util.*;

public class BJ_1253 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] numArr = new long[N];
		long count = 0;
		
		for (int i = 0; i < N; i++) {
			numArr[i] = sc.nextLong();
		}
		
		Arrays.sort(numArr);
		
		for (int k = 0; k < N; k++) {
			long find = numArr[k];
			int i = 0;
			int j = N - 1;
			
			while(i < j) {
				if(numArr[i]+numArr[j] == find) {
					if (i != k && j != k) {
						count++;
						break;
					} else if(i == k) {
						i++;
					} else if(j == k) {
						j--;
					}
				} else if(numArr[i]+numArr[j] < find) {
					i++;
				} else {
					j--;
				}
			}
		}
		
		System.out.println(count);

	}

}
