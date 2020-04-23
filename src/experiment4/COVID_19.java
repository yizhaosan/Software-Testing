package experiment4;

/**
 * @Title: COVID_19
 * @Package: experiment4
 * @Descripate: 智能辅助新型冠状病毒肺炎问诊量表及判断逻辑说明
 * @author: yizhaosan
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class COVID_19 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			
			// 症状采集
			System.out.println("是否具有以下症状？多选，输入-1结束\n"
					+ "\t1.发热\n"
					+ "\t2.咳嗽\n"
					+ "\t3.腹泻\n"
					+ "\t4.胸闷\n"
					+ "\t5.气急\n"
					+ "\t6.咽喉痛\n"
					+ "\t7.流鼻涕\n"
					+ "\t8.鼻塞\n"
					+ "\t9.呼吸困难\n"
					+ "\t10.全身酸痛\n"
					+ "\t11.乏力\n"
					+ "\t12.都没有\n");
			List<Integer> list1 = new ArrayList<Integer>();
			int temp1 = 0;
			while(true) {
				temp1 = scanner.nextInt();
				if(temp1 != -1) {
					list1.add(temp1);
				} else {
					break;
				}
			}
			
			// 症状时长
			System.out.println("本次不舒服有多久了？\n"
					+ "\t1.14天以内\n"
					+ "\t2.14天以上\n");
//			int temp2 = scanner.nextInt();
			
			// 接触史询问
			System.out.println("近14天有没有以下情况？多选，输入-1结束");
			System.out.println("\t1.有武汉（湖北）等疫区旅游史或居住史");
			System.out.println("\t2.有接触过武汉（湖北）等疫区的人员");
			System.out.println("\t3.有接触过疑似或确诊新型冠状病毒感染者");
			System.out.println("\t4.身边有多人出现发热、乏力、咳嗽、咽痛等？");
			System.out.println("\t5.都没有");
			List<Integer> list2 = new ArrayList<Integer>();
			int temp3 = 0;
			while(true) {
				temp3 = scanner.nextInt();
				if(temp3 != -1) {
					list2.add(temp3);
				} else {
					break;
				}
			}
			
			// 判断逻辑
			int result = 0;
			if(list1.get(0)==1 || list1.get(0)==2 || list1.get(0)==3 || list1.get(0)==4 || list1.get(0)==5 || list1.get(0)==6 || list1.get(0)==7 || list1.get(0)==8 || list1.get(0)==9 || list1.get(0)==10 || list1.get(0)==11) {
				if(list2.get(0)==1 || list2.get(0)==2 || list2.get(0)==3 || list2.get(0)==4) {
					result = 1;
				}
				if(list2.get(0)==5) {
					result = 2;
				}
			} else if(list1.get(0)==12) {
				if(list2.get(0)==1 || list2.get(0)==2 || list2.get(0)==3 || list2.get(0)==4) {
					result = 3;
				}
				if(list2.get(0)==5) {
					result = 4;
				}
			}
			
			// 智能推荐答案列表
			switch (result) {
			case 1:
				System.out.println("建议立刻发热门诊就诊，并佩戴好口罩做好防护。佩戴医用外科口罩或N95口罩，避免乘坐公共交通工具。");
				break;
			case 2:
				System.out.println("结合你提供的病情症状及接触史特点，建议继续在家监测体温，可适当服用治疗感冒的中成药，注意手卫生，多饮水，休息为主。若体温持续不退或体温大于38℃或不适症状加重，及时就诊。");
				break;
			case 3:
				System.out.println("建议你们全家及密切接触者居家隔离至少2周，在家期间建议戴口罩交流，条件允许时，尽量单独居住或居住在通风良好的单人房间。多休息，多饮水，注意手卫生和常用物品卫生消毒。若出现发热及呼吸道症状，需马上前往医院就诊。");
				break;
			case 4:
				System.out.println("建议您戴口罩、勤洗手，避免人群聚集，减少不必要外出。");
				break;
			default:
				break;
			}
		}
		
	}
}
