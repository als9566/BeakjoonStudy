import java.io.*;
import java.util.*;

public class BJ_11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// ť�� ���ı����� ���� ���� [���밪�� ���� �������� ��µ� �� �ֵ���]
		PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1,o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if (first_abs == second_abs)
				return o1 > o2 ? 1 : -1; // ������ ������ ���� �켱 ����
			else
				return first_abs - second_abs; // ���� �������� ����
		});
		
		// ������ ������ŭ ����x�� �޴´�.
		for (int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine()); // ���� x
			if (request == 0) {                            // x�� 0 �϶�
				if (MyQueue.isEmpty())                     // ť�� ����ִٸ� "0"���
					System.out.println("0");
   				else									   // ť�� ������� �ʴٸ� ť�� front �κ� �����͸� ��� �� ����
					System.out.println(MyQueue.poll());
			} else                     // x�� 0�� �ƴ϶��
				MyQueue.add(request);  // ť�� ����
		}		

	}

}
