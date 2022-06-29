import java.util.*;
import java.io.*;

public class BJ_1874 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();    // 수열의 개수
		int A[] = new int[N];    // 수열배열
		
		for (int i = 0; i < N; i++) { // 수열배열 입력받기
			A[i] = sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();  // 스택생성
		
		StringBuffer bf = new StringBuffer();  // 출력 문자열버퍼
		int num = 1;  // 오름차순 수
		boolean result = true; // 오름차순 수열 가능여부 변수
		
		for (int i = 0; i < N; i++) {
			int su = A[i];  // 현재 수열의 수
			if (su >= num) {             // 현재 수열 값 >= 오름차순 자연수 일때
				while(su >= num) {       // 값이 같아질때까지 push
					stack.push(num++);   // 스택에 넣어준 후 num 증가
					bf.append("+\n");    // 넣었으면 '+' 출력
				}
				stack.pop();             // 마지막 입력값 빼기
				bf.append("-\n");        // 뺐으면 '-' 출력
			} else {                     // 현재 수열값 < 오름차순 자연수 일때
				int n = stack.pop();     // 스택 맨위에 있는 수
				if (n > su) {            // 맨위에 숫자가 자연수보다 크다면 수열을 출력할 수 없음
					System.out.println("NO");
					result = false;      // 오름차순 수열 불가능으로 false
					break;               // 불가능 이므로 반복문을 빠져나감
				} else {                 // 맨위의 숫자가 자연수보다 작다면 수열을 출력할 수 있음
					bf.append("-\n");    // 위에서 pop으로 뺐으니 '-' 출력
				}
			}
		}
		
		if (result) {  // 오름차순 수열 불가능 없이 반복문을 종료했다면
			System.out.println(bf.toString()); // 문자열 버퍼 출력
		}

	}

}
