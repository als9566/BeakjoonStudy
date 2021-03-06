import java.util.*;

public class BJ_2343 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[N];
		int start = 0;
		int end = 0;
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			if (start < A[i]) start = A[i]; // 레슨 최댓값을 시작 인덱스로 저장
			end += A[i];               // 모든 레슨의 총합을 종료 인덱스로 저장
		}
		while (start <= end) {
			int middle = (start + end) / 2;
			int sum = 0;
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (sum + A[i] > middle) {
					count++;
					sum = 0;
				}
				sum += A[i];
			}
			if (sum != 0)             // 탐색 후 sum이 0이 아니면 블루레이가 1개 더 필요
				count++;
			if (count > M) 
				start = middle + 1;
			else
				end = middle - 1;
			//System.out.println(count);
		}
		System.out.println(start);

	}

}
