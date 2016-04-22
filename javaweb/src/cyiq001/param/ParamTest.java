package cyiq001.param;
/**
 * 可变参数
 * 变长的参数为同一类型，且该参数为参数列表的最后一个
 * 程序运行结果：
 * sum = 0
 * then
 * sum = 36
 * @author cyiq
 *
 */
public class ParamTest {
	public static void main(String[] args) {
		sum(0,1,2,3,4,5,6,7,8);
	}
	public static void sum(int sum,int ... ints){
		System.out.println("sum = "+ sum);
		for(int i : ints){
			sum += i;
		}
		System.out.println("then");
		System.out.println("sum = "+ sum);
	}
}
