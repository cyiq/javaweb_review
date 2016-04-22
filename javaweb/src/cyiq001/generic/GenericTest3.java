package cyiq001.generic;

import java.util.ArrayList;
import java.util.List;
/**
 * 向一个String类型的List中插入Integer对象
 * 程序运行结果：
 * aaaaa
 * bbbbb
 * java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
 * 
 * @author cyiq
 * @param <T>
 */
public class GenericTest3 {
	public static void main(String[] args) {
		GenericTest3 g = new GenericTest3();
		List<String> list1 = new ArrayList<String>();
		list1.add("aaaaa");
		list1.add("bbbbb");
//		list1.add(2);	//错误：类型不匹配
		//如何向list1中插入数字？
		List list2 = list1;
		list2.add(2);	
		g.print(list2);
	}
	public void print(List<String> list){
		for(String s:list){
			System.out.println(s);
		}
	}
}
