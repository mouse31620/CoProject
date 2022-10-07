import java.text.SimpleDateFormat;
import java.util.Date;

public class test2 {

	public class OrderCode{
        public static final String PREFIX = "D";
        private static long code;
        public static synchronized String getOrderCode(){
        	code++;
        	String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
        	long m = Long.parseLong(str)*10000;
        	m += code;
        	return PREFIX+m;
        }

        
    }

    public static void main(String[] args) {
        
        int i = 0;
        while(i<100) {
        	System.out.println(OrderCode.getOrderCode());
        	i++;
        }
        
        
    }
}
