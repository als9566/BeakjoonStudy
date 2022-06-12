import java.util.Scanner;

public class BJ5585 {

	public static void main(String[] args) {
		
		Scanner SC = new Scanner(System.in);
			
		int iChange = 1000-SC.nextInt();
		int count = 0;	
		
		int[] HaveMoney = {500,100,50,10,5,1}; 
		
		for(int coin : HaveMoney){
           
			if (coin > iChange)
                continue;
            count += iChange / coin;
            iChange %= coin;

        }
		
		/*for (int i = 0; i < HaveMoney.length; i++) {
			if(iChange > HaveMoney[i]) {
				count += iChange/HaveMoney[i];
				iChange %= HaveMoney[i];
			}
		}*/	
		
		System.out.println(count);

	}

}
