import java.util.*;

public class BJ_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<>();
		
		int N = sc.nextInt(); // ��ü ī�� ��
		
		for (int i = 0; i < N; i++) { //ī�带 ť�� ����
			myQueue.add(i+1);
		} 
		
		while (myQueue.size() > 1) { //ī�尡 ���峲�������� �ݺ�
			myQueue.poll(); //������ ī�����
			myQueue.add(myQueue.poll()); // ������ ī�带 ���� ������ ����
		}
		//while���� ���������� ������ ������ ���´�.
		System.out.println(myQueue.poll()); // ���峲���� ���

	}

}
