package ctgu.edu.com.triangle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @Title: TriangleJUnitTest
 * @Package: ctgu.edu.com.triangle
 * @Descripate: �����β�����
 *
 */
// ������������
@RunWith(Parameterized.class)
class TriangleJUnitTest {
	private int a, b, c;
	private String type;

	@Before
	private void setUp() throws Exception {
		// TODO Auto-generated method stub

	}

	public TriangleJUnitTest(int a, int b, int c, String type) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
		this.c = c;
		this.type = type;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(
				new Object[][] {
					{101, 120, 45, "�������"},
					{10, 20, 30, "��������"},
					{2, 2, 2, "�ȱ�������"},
					{0, 0, 0, "��������" }, 
					{4, 3, 5, "һ��������" },
					{3, 3, 4, "����������" }, 
					{4, 4, 5, "����������" }, 
					{1, 0, 0, "��������" }, 
					{1, 1, 1, "�ȱ�������" },
				}
		);
	}

	@Test
	public void test() {
		assertEquals(this.type, Triangle.triangleCalculate(a, b, c));
	}

}
