package cyiq001.property;

import java.util.ResourceBundle;

public class ReadProperty {
	public static void main(String[] args) {
		ResourceBundle r = ResourceBundle.getBundle("cyiq001/data");
		System.out.println(r.getString("name"));
		System.out.println(r.getString("age"));
	}
}
