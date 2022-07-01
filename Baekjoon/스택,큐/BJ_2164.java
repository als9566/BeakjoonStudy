import java.util.*;

public class BJ_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<>();
		
		int N = sc.nextInt(); // 전체 카드 수
		
		for (int i = 0; i < N; i++) { //카드를 큐에 저장
			myQueue.add(i+1);
		} 
		
		while (myQueue.size() > 1) { //카드가 한장남을때까지 반복
			myQueue.poll(); //맨위의 카드삭제
			myQueue.add(myQueue.poll()); // 맨위의 카드를 제일 밑으로 보냄
		}
		//while문을 빠져나오면 마지막 한장이 남는다.
		System.out.println(myQueue.poll()); // 한장남은걸 출력

	}

}
