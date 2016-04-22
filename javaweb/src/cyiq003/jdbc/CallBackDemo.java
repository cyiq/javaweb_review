package cyiq003.jdbc;

import java.util.List;

/**
 * 回调
 * @author cyiq
 */
public class CallBackDemo {
	public static void main(String[] args) {
		Runner run = new Runner();
		run.query("hello",new RunnerHandler<List<Contact>>(){
			@Override
			public List<Contact> handle(String str) {
				return null;
			}
		});
		System.out.println("over");
	}
}

/*
 *  定义调用类
 */
class Runner{
	public <T>T query(String str , RunnerHandler<T> rh){
		return rh.handle(str);
	}
}
/*
 * 定义回调规范 
 */
interface RunnerHandler<T>{
	public T handle(String str);
}
