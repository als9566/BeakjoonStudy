import java.util.Arrays;
import java.util.Scanner;

public class BJ2217 {

	public static void main(String[] args) {
		Scanner SC = new Scanner(System.in);
		
		//로프의 개수
		int N = SC.nextInt(); 
		
		//각각의 로프가 들 수 있는 물체의 중량 배열 
		int[] arr = new int[N];
		
		//N개의 로프 중량을 입력받음.
		for (int i = 0; i < N; i++) {
			arr[i] = SC.nextInt();
		}
		
		//순서를 정렬
		Arrays.sort(arr);
		
		int maxKg = 0;
		
		/*
		루프가 들 수 있는 중량보다 큰 루프와 함께 사용해야 큰 중량을 들 수 있다.
		for문을 거꾸로 실행하였다. 
		EX) 10 20 30 
		30보다 큰 중량은 없으므로 30*1=30
		20보다 큰 중량은 30이 있으므로 20,30루프로 이용하면 20*2=40
		10보다 큰 중량은 20,30이 있으므로 10,20,30루프를 이용하면 10*3=30
		*/
		for (int i = N-1; i >= 0; i--) {
			if(maxKg < arr[i]*(N-i)) {
				maxKg = arr[i]*(N-i); 
			}
		}
		
		System.out.println(maxKg);

	}

}
