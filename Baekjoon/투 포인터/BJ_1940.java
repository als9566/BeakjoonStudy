import java.util.*;
public class BJ_1940 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 재료의 개수
		int M = sc.nextInt(); // 갑옷을 만드는데 필요한 수
		int[] A = new int[N]; // 재료배열
		
		for (int i = 0; i < N; i++) { // 재료배열에 재료를 입력받음
			A[i] = sc.nextInt();
		}
		
		Arrays.sort(A); // 재료배열 오름차순 정렬
		
		int i = 0;      // 재료정렬배열 첫번째인덱스 
		int j = N-1;    // 재료정렬배열 마지막인덱스 
		int count = 0;  // 갑옷생산 개수
		
		while(i < j) {  // i와j가 크로스 하기전까지 반복
			if (A[i] + A[j] < M) {        // 합이 M보다 작다면 더큰 합이 나올 수 있도록 i++
				i++;
			} else if (A[i] + A[j] > M) { // 합이 M보다 크다면 작은 합이 나올 수 있도록 j--;
				j--;
			} else {                      // 합이 M과 같다면 갑옷을 생산할 수 있으므로
				count++;                  // count++, 양쪽 포인터 이동
				i++;
				j--;
			}
		}
		
		System.out.println(count);

	}

}
