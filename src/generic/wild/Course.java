package generic.wild;

public class Course<T> {
	private String name;//과정명
	private T[] students;//과정 하나에 여러 수강생 가능
	
	
	public Course(String name, int capacity) {
		this.name = name;
		//타입 t로 결정되지 않아서 new 연산자 사용 불가
		students = (T[])(new Object[capacity]);
	}
	public String getName() {return name;}
	public T[] getStudents() {return students;}
	//배열에 비어있는 원소를 찾아서 수강생을 추라
	public void add(T st) {
		for(int i=0;i<students.length;i++) {
			if(students[i] ==null) {
				students[i] = st;
				break;
			}
		}
	}
	
}
