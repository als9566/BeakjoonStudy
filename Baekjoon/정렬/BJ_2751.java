import java.io.*;

public class BJ_2751 {
	
	public static int[] A, tmp;
	public static long result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());       // 정렬할 수 개수
		A = new int[N+1];     // 정렬할 배열
		tmp = new int[N+1];   // 정렬할 때 잠시 사용할 임시 배열
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		merget_sort(1,N);
		for (int i = 1; i <= N; i++) {      // 결과값
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();		
	}
	
	// 병합정렬
	private static void merget_sort(int s, int e) {
		// s:시작점, e:종료점, m:중간점
		if (e - s < 1)
			return;
		int m = s+ (e - s) / 2;
		// 재귀함수로 구현
		merget_sort(s,m);
		merget_sort(m+1, e);
		for (int i = s; i <= e; i++) {
			tmp[i] = A[i];
		}
		int k = s;
		int index1 = s;    // index1 : 앞쪽 그룹 시작점
		int index2 = m+1;  // index2 : 뒤쪽 그룹 시작점
		while (index1 <= m && index2 <= e) {  //두 그룹을 병합하는 로직
		// 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은수를 선택해 배열에 저장하고,
		// 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기
			if (tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
				k++;
				index2++;
			} else {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while (index1 <= m) {   // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리하기
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		while (index2 <= e) {
			A[k] =tmp[index2];
			k++;
			index2++;
		}
	}
	
}
