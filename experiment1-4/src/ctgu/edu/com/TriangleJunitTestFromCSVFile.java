package ctgu.edu.com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * @Title: TriangleJunitTestFromCSVFile
 * @Package: ctgu.edu.com
 * @Descripate: 三角形边界值测试
 * @author: yizhaosan
 */
public class TriangleJunitTestFromCSVFile {
	@ParameterizedTest
	@DisplayName("三角形一般边界测试")
	@CsvFileSource(resources = "/三角形一般边界测试用例.csv", numLinesToSkip = 1)
	public void testNormalBoundary(Integer num, Integer a, Integer b, Integer c, String type) {
		assertEquals(Triangle.triangleCalculate(a, b, c), type);
	}

	@ParameterizedTest
	@DisplayName("三角形最坏情况边界测试")
	@CsvFileSource(resources = "/三角形最坏情况测试用例.csv", numLinesToSkip = 1)
	public void testWorstCaseBoundary(Integer num, Integer a, Integer b, Integer c, String type) {
		assertEquals(Triangle.triangleCalculate(a, b, c), type);
	}

	@ParameterizedTest
	@DisplayName("三角形健壮边界测试")
	@CsvFileSource(resources = "/三角形健壮边界测试用例.csv", numLinesToSkip = 1)
	public void testRobustBoundary(Integer num, Integer a, Integer b, Integer c, String type) {
		assertEquals(Triangle.triangleCalculate(a, b, c), type);
	}

	@ParameterizedTest
	@DisplayName("三角形健壮最坏情况测试")
	@CsvFileSource(resources = "/三角形健壮性最坏情况测试用例.csv", numLinesToSkip = 1)
	public void testRobustWorstCaseBoundary(Integer num, Integer a, Integer b, Integer c, String type) {
		assertEquals(Triangle.triangleCalculate(a, b, c), type);
	}
}
