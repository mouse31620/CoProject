import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import com.uch.vo.FoodOrderInfo;
import com.uch.vo.Item;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item t2 = new Item();
		
		for(int i =0;i<10;i++) {
			System.out.println(i);
			
			
		
		
		}
		
		

	}
	public static String getTime() {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
	}
	public static String creatActive() {
		return getTime()+Integer.toHexString(new Random().nextInt(900)+100);
	}

}
