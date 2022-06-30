import java.io.*;
import java.util.*;

public class BJ_17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] A = new int[n];         // 수열 배열 생성
		int[] ans = new int[n];       // 정답 배열 생성
		String[] str = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(str[i]);   // 수열 배열에 들어갈 값 받기
		}
		
		Stack<Integer> myStack = new Stack<>();   // 스택생성
		myStack.push(0);     // 처음에는 항상 스택이 비어있으므로 최초값 초기화
		for (int i = 1; i < n; i++) {  //위에서 0을 스택에 push했으므로 1부터 시작
			// 스택이 비어있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
			while (!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
				ans[myStack.pop()] = A[i]; // 정답배열에 오큰수를 현재 수열로 저장
			}
			myStack.push(i); // 신규 데이터 push
		}
		
		while (!myStack.empty()) {   // 반복문을 다 돌고 나서도 스택이 비어 있지 않다면 오큰수는 -1 
			ans[myStack.pop()] = -1; // 정답배열에 -1을 넣어준다.
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			bw.write(ans[i] + " "); // 출력
		}
		bw.write("\n");
		bw.flush();
	}

}
