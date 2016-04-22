package cyiq001.jUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *	-@Test:测试方法
 *	-@Ignore: 被忽略的测试方法
 *	-@Before: 在每个测试方法执行之前都要执行一次。
 *	-@After: 在每个测试方法执行之后要执行一次。 
 *	-@BeforeClass: 所有测试开始之前运行 static
 *	-@AfterClass: 所有测试结束之后运行 static
 * @author cyiq
 */
public class JUnitTest {
	@BeforeClass
	public static void beforeClassTest(){
		System.out.println("@BeforeClass");
	}
	@Before
	public void beforeTest(){
		System.out.println("@Before");
	}
	@Test
	/*
	 *  Run As JUnitTest
	 *  结果：
	 *  @BeforeClass
	 *	@Before
	 *	@Test
	 *	@After
	 *	@AfterClassTest
	 */
	public void testTest(){
		System.out.println("@Test");
	}
	@Ignore
	@Test
	/*
	 *  Run As JUnitTest
	 *  结果：
	 *  @BeforeClass
	 *	@AfterClassTest
	 */
	public void ignoreTest(){
		System.out.println("@Ignore");
	}
	@After
	public void afterTest(){
		System.out.println("@After");
	}
	@AfterClass
	public static void afterClassTest(){
		System.out.println("@AfterClass");
	}
}
