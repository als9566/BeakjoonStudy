import java.util.Scanner;

public class BJ10162 {

	public static void main(String[] args) {
		Scanner SC = new Scanner(System.in);
		
		int T = SC.nextInt();
		
		int[] arr = {300,60,10};
		
		int[] btnArr = new int[3];
		
		for (int i = 0; i < 3; i++) {
			if(T >= arr[i]) {
				btnArr[i] = T/arr[i];
				T = T%arr[i];
			}		
		}
		
		if(T > 0) {
			System.out.println(-1);
		}
		else {
			for (int i = 0; i < 3; i++) {
				System.out.print(btnArr[i]);
			}
		}

	}

}
