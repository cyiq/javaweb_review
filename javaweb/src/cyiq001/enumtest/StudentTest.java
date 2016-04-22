package cyiq001.enumtest;

public class StudentTest {
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("aaa");
		student.setGrade(Grade.A);
		System.out.println(student.getGrade().getLocalString());
	}
}
