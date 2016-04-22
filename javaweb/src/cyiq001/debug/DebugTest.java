package cyiq001.debug;
/**
 * 测试使用debug
 * Step Over(F6):跳过,执行下一步
 * Step Into(F5): 跳入,进入执行的方法内部
 * Step Return(F7):跳出,跳出当前执行的方法
 * Resume(F8)：跳入到下一个断点，如果没有直接结束
 * Terminate (Ctrl+ F2):终止调试，
 * @author cyiq
 */
public class DebugTest {
	int i = 0;
	boolean flag = true;
	public DebugTest(){
		System.out.println("constructor1");
		System.out.println("constructor2");
	}
	public static void main(String[] args) {
		System.out.println("Hello");
		System.out.println("breakpoint");	//breakpoint
		DebugTest d = new DebugTest();
		d.fun1();
		d.fun2(2,false);
		System.out.println("Bye-bye");
	}
	
	public void fun1(){
		System.out.println(i);
		System.out.println(flag);
	}
	public void fun2(int i , boolean flag){
		System.out.println(i);
		System.out.println(flag);
	}
}
