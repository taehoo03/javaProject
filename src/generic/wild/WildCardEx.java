package generic.wild;

import java.util.Arrays;

public class WildCardEx {
//수강생 제한 없는 일반 과정
	public static void registerCourse(Course<?> course) { //Course 클래스의 제네릭 파라미터 타입에 제한 ㅇ벗음
		System.out.println(course.getName()+"수강생 : " + 
			Arrays.toString(course.getStudents()));
	}
	
	
	
	//학생 과정
	public static void registerCourseStudent(Course <? extends Student> course) {
		System.out.println(course.getName()+"수강생 : " + 
				Arrays.toString(course.getStudents()));
	}
	
	//직장인 과정
	public static void registerCourseWorker(Course <? super Worker> course) {
		System.out.println(course.getName()+"수강생 : " + 
				Arrays.toString(course.getStudents()));
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Course <Person >personCourse = new Course<Person>("일반인 과정" ,5);
		personCourse.add(new Person("일반인"));
		/*
		 * personCourse.add(new Worker("직장인")); personCourse.add(new Student("학생"));
		 * personCourse.add(new HighStudent("고등학생"));
		 */
		
		
		// ? : 타입 제한 없음(관련된(동일 패키지) 4개의 클래스만 사용)
		
		Course <Worker >workerCourse = new Course<Worker>("직장인 과정" ,5);
		workerCourse.add(new Worker("직장인"));
		Course <Student >StudentCourse = new Course<Student>("학생 과정" ,5);
		personCourse.add(new Student("학생"));
		Course <HighStudent >highstudentCourse = new Course<HighStudent>("고등 학생 과정" ,5);
		personCourse.add(new HighStudent("고등학생"));
		
		
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(StudentCourse);
		registerCourse(highstudentCourse);
		System.out.println();
		
		registerCourseStudent(personCourse);
		registerCourseStudent(workerCourse);
		registerCourseStudent(StudentCourse);
		registerCourseStudent(highstudentCourse);
		System.out.println();
		
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
		registerCourseWorker(StudentCourse);
		registerCourseWorker(highstudentCourse);
		System.out.println();
		

		
	}

}
