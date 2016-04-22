package cyiq002.servlet;

import java.io.InputStream;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) {
		
		URL url1 = URLTest.class.getResource("/");
		URL url2 = URLTest.class.getResource("");
//		URL url3 = URLTest.class.getClassLoader().getResource("/");
		URL url4 = URLTest.class.getClassLoader().getResource("");
		System.out.println("class.getResource(\"/\"):\n"+url1.getPath());
		System.out.println("class.getResource(\"\"):\n" + url2.getPath());
//		System.out.println("class.getClassLoader().getResource(\"/\"):"+url3.getPath());
		System.out.println("class.getClassLoader().getResource(\"\"):\n"+url4.getPath());
		
	}
}
