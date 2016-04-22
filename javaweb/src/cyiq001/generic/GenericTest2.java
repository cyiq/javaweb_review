package cyiq001.generic;

import java.util.ArrayList;
import java.util.List;
/**
 * 泛型保证传入数据的正确性
 * 程序运行结果：
 * 1
 * 3
 * 
 * @author cyiq
 * @param <T>
 */
public class GenericTest2<T>{
	public static void main(String[] args) {
		GenericTest2<Integer> g = new GenericTest2<Integer>();
		List<Integer> list = new ArrayList<Integer>();
//		list.add("1");	//错误，编译时报错
		list.add(1);
		list.add(3);
		g.print(list);
	}
	
	public void print(List<T> list){
		for(T t:list){
			System.out.println(t);
		}
	}
}
