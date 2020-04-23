package ctgu.edu.com;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @Title: TelephoneBillJunitTest
 * @Package: ctgu.edu.com
 * @Descripate: TelephoneBill测试类
 * @author: yizhaosan
 */
// 参数化运行器
@RunWith(Parameterized.class)
public class TelephoneBillJunitTest {
	
	private String startTime, endTime;
	private String bill;
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	public TelephoneBillJunitTest(String startTime, String endTime, String bill) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.bill = bill;
	}
	
	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			{"20200317150000", "20200317150100", "0.05"},
			{"20170102030405", "20170102030425", "0.05"},
			{"20200317150000", "20200317150200", "0.10"},
			{"20200317150000", "20200318205900", "178.90"},
			{"20200317150000", "20200318210000", "179.00"},
			{"20200317150000", "20200318210100", "时间错误"},
			{"20200317150000", "20200317150001", "0.05"},
			{"20200317150000", "20200317151900", "0.95"},
			{"20200317150000", "20200317152000", "1.00"},
			{"20200317150000", "20200317152100", "1.10"},
			
			{"20200329010000", "20200329015900", "4.90"},
			{"20200329010000", "20200329020000", "5.00"},
			{"20200329010000", "20200329020100", "5.10"},
			{"20200329010000", "20200329025900", "10.90"},
			{"20200329010000", "20200329030000", "5.00"},
			{"20200329010000", "20200329030100", "5.10"},
			
			{"20200328010000", "20200329050000", "167.00"},
			
			{"20200329015900", "20200329040000", "5.10"},
			{"20200329020000", "20200329040000", "11.00"},
			{"20200329020100", "20200329040000", "10.90"},
			{"20200329025900", "20200329040000", "5.10"},
			{"20200329030000", "20200329040000", "5.00"},
			{"20200329030100", "20200329040000", "4.90"},
			
			{"20200329020100", "20200329025900", "4.80"},
			
			{"20200328020000", "20200329015900", "142.90"},
			{"20200328020000", "20200329020000", "143.00"},
			{"20200328020000", "20200329020100", "143.10"},
			{"20200328020000", "20200329025900", "148.90"},
			{"20200328020000", "20200329030000", "149.00"},
			{"20200328020000", "20200329030100", "149.10"},
			
			{"20200328020000", "20200329040000", "155.00"},
			
			{"20201025010000", "20201025015900", "4.90"},
			{"20201025010000", "20201025020000", "5.00"},
			{"20201025010000", "20201025030100", "11.10"},
			
			{"20201025015900", "20201025040000", "11.10"},
			{"20201025020000", "20201025040000", "17.00"},
			{"20201025020100", "20201025040000", "16.90"},
			
			{"20201025020100", "20201025025900", "10.80"},
			
			{"20201024020000", "20201025025900", "154.90"},
			{"20201024020000", "20201025030000", "149.00"},
			{"20201024020000", "20201025030100", "149.10"}
		});
	}
	
	@Test
    public void testJunitTelephoneBill() {
        extracted();
    }

	@SuppressWarnings("deprecation")
	private void extracted() {
		assertEquals(this.bill, TelephoneBill.getTelephoneBill(startTime, endTime));
	}
	
//	public static void main(String[] args) {
//		Result result = JUnitCore.runClasses(TelephoneBill.class);
//		
//		for (org.junit.runner.notification.Failure failure : result.getFailures()) {
//			System.out.println(failure.toString());
//		}
//		System.out.println(result.wasSuccessful());
//	}

}
