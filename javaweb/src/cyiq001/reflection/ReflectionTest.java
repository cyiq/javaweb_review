package cyiq001.reflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 输入类，打印类的结构
 * 字段，构造方法，方法
 * @author cyiq
 */
public class ReflectionTest {
	
	public static void main(String[] args) {
		String name;
		if(args.length > 0){
			name = args[0];
		}else{
			Scanner in = new Scanner(System.in);
			System.out.println("请输入类 (例如： java.util.Date):");
			name = in.next();
		}

		try {
			Class c1 = Class.forName(name);
			Class superc1 = c1.getSuperclass();
			String modifiers = Modifier.toString(c1.getModifiers());
			System.out.println(name+" 类信息如下");
			if(modifiers.length()>0){
				System.out.printf(modifiers + " ");
			}
			System.out.printf("class " + name);
			if(superc1!=null && superc1 != Object.class){
				System.out.printf("extends :" + superc1.getName());
			}
			System.out.printf("{\n");
			printFields(c1);
			System.out.println();
			printConstructors(c1);
			System.out.println();
			printMethods(c1);
			System.out.println("}");
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到类，程序终止！");
		}
	}
	/*
	 * 打印类的构造器
	 */
	public static void printConstructors(Class c1){
		Constructor[] constructors = c1.getDeclaredConstructors();
		for(Constructor c : constructors){
			String name = c.getName();
			System.out.printf("\t");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length()>0){
				System.out.printf(modifiers + " ");
			}
			System.out.printf(name + "(");
			Class[] paramType = c.getParameterTypes();
			for(int j = 0; j < paramType.length;j++){
				if(j>0){
					System.out.printf(",");
				}
				System.out.printf(paramType[j].getName());
			}
			System.out.println(");");
		}
	}
	/*
	 * 打印类的方法
	 */
	public static void printMethods(Class c1){
		Method [] methods = c1.getDeclaredMethods();
		for(Method m : methods){
			Class returnType = m.getReturnType();
			String name = m.getName();
			System.out.printf("\t");
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length()>0){
				System.out.printf(modifiers + " ");
			}
			System.out.printf(returnType.getName() + " "+ name + "(");
			Class[] paramTypes = m.getParameterTypes();
			for(int j = 0; j < paramTypes.length; j++){
				if(j>0){
					System.out.printf(",");
				}
				System.out.printf(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	/*
	 * 打印类的字段
	 */
	public static void printFields(Class c1){
		Field [] fields = c1.getDeclaredFields();
		for(Field f : fields){
			Class type = f.getType();
			String name = f.getName();
			System.out.printf("\t");
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers.length()>0){
				System.out.printf(modifiers + " ");
			}
			System.out.println(type.getName() + " " + name + ";");
		}
	}
}
