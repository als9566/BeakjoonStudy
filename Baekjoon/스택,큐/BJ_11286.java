import java.io.*;
import java.util.*;

public class BJ_11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 큐의 정렬기준을 직접 정의 [절대값이 가장 작은수가 출력될 수 있도록]
		PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1,o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if (first_abs == second_abs)
				return o1 > o2 ? 1 : -1; // 절댓값이 같으면 음수 우선 정렬
			else
				return first_abs - second_abs; // 절댓값 기준으로 절렬
		});
		
		// 연산의 개수만큼 정수x를 받는다.
		for (int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine()); // 정수 x
			if (request == 0) {                            // x가 0 일때
				if (MyQueue.isEmpty())                     // 큐가 비어있다면 "0"출력
					System.out.println("0");
   				else									   // 큐가 비어있지 않다면 큐의 front 부분 데이터를 출력 및 삭제
					System.out.println(MyQueue.poll());
			} else                     // x가 0이 아니라면
				MyQueue.add(request);  // 큐에 삽입
		}		

	}

}
