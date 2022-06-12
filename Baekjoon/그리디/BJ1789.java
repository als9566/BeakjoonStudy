import java.util.Scanner;

public class BJ1789 {

	public static void main(String[] args) {
		
		Scanner SC = new Scanner(System.in);
		long N = SC.nextLong();
		long sum = 0;
		int cnt = 0;
		
		for(int i=1; ; i++) {
			if(sum > N)	break;
			sum += i;
			cnt ++;
		}
		System.out.println(cnt-1);
	}

}
