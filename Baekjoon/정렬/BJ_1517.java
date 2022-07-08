import java.util.*;
import java.io.*;

public class BJ_1517 {
	public static int[] A, tmp;
	public static long result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());  // 정렬할 수 개수
		A= new int[N + 1];                        // 정렬할 배열
		tmp = new int[N + 1];                     // 정렬할 때 잠시 사용하는 임시 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		result = 0;
		merget_sort(1, N);  // 병합정렬
		System.out.println(result);
	}
	
	// 병합정렬
	private static void merget_sort(int s, int e) { // s 시작점, e 종료점, m 중간점
		if (e - s < 1)
			return;
		int m = s + (e - s) / 2;
		// 재귀 함수 형태로 구현
		merget_sort(s, m);
		merget_sort(m + 1, e);
		for (int i = s; i <= e; i++) {
			tmp[i] = A[i];
		}
		int k = s;
		int index1 = s;         // 앞쪽 그룹 시작점
		int index2 = m + 1;     // 뒤쪽 그룹 시작점
		while (index1 <= m && index2 <= e) { // 두 그룹을 병합하는 로직
			if (tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
				result = result + index2 - k;  // 뒤쪽 데이터 값이 작은 경우 result 업데이트
				k++;
				index2++;
			} else {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while (index1 <= m) {
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		while (index2 <= e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}

}
