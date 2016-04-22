package cyiq001.generic;

import java.util.ArrayList;
import java.util.List;
/**
 * 泛型只存在于编译阶段，运行时擦除
 * 程序运行结果：
 * 1
 * 2
 * 
 * @author cyiq
 * @param <T>
 */
public class GenericTest1<T>{
	public static void main(String[] args) {
		GenericTest1<Integer> g = new GenericTest1<Integer>();
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		g.print(list);
	}
	
	public void print(List<T> list){
		for(T t:list){
			System.out.println(t);
		}
	}
	
	
}
