import java.util.Scanner;

public class BJ1541 {

	public static void main(String[] args) {
		
		Scanner SC = new Scanner(System.in);
		
		//'-'로 구분
		String[] strArr = SC.nextLine().split("-");		
	
		//'-'로 구분된 식을 계산한다.
		for (int i = 0; i < strArr.length; i++) {
			int tempSum = 0;
			String[] tempArr =  strArr[i].split("\\+");
			//'+'계산 반복문
			for (int j = 0; j < tempArr.length; j++) {
				tempSum += Integer.parseInt(tempArr[j]);
			}
			strArr[i] = Integer.toString(tempSum);
		}
		
		//계산된 값을 마이너스(-)해준다.
		int iValue = 0;
		for (int i = 0; i < strArr.length; i++) {
			if(i==0) //첫번째는 플러스(+)해야함
				iValue += Integer.parseInt(strArr[i]);
			else
				iValue -= Integer.parseInt(strArr[i]);
		}
		System.out.println(iValue);

	}

}
