import java.util.Arrays;

public class StudentCourseManager {

    class StudentNode {
        int studentId;
        CourseNode courseList;
        StudentNode next;

        StudentNode(int studentId) {
            this.studentId = studentId;
            this.courseList = null;
            this.next = null;
        }
    }

    class CourseNode {
        String courseCode;
        String grade;
        CourseNode nextCourse;
        CourseNode nextStudent;

        CourseNode(String courseCode, String grade) {
            this.courseCode = courseCode;
            this.grade = grade;
            this.nextCourse = null;
            this.nextStudent = null;
        }
    }

    StudentNode headStudent;

    public StudentCourseManager() {
        headStudent = null;
    }

    // Bir öğrenciye yeni bir ders ekleme
    public void addCourseToStudent(int studentId, String courseCode, String grade) {
        StudentNode student = findStudent(studentId);
        if (student == null) {
            student = new StudentNode(studentId);
            student.next = headStudent;
            headStudent = student;
        }
        CourseNode course = new CourseNode(courseCode, grade);
        course.nextCourse = student.courseList;
        student.courseList = course;
    }

    // Bir derse yeni bir öğrenci ekleme
    public void addStudentToCourse(String courseCode, int studentId, String grade) {
        StudentNode student = findStudent(studentId);
        if (student == null) {
            student = new StudentNode(studentId);
            student.next = headStudent;
            headStudent = student;
        }
        CourseNode course = new CourseNode(courseCode, grade);
        course.nextStudent = student.courseList;
        student.courseList = course;
    }

    // Bir öğrencinin bir dersini silme
    public void deleteCourseFromStudent(int studentId, String courseCode) {
        StudentNode student = findStudent(studentId);
        if (student != null) {
            CourseNode prev = null;
            CourseNode current = student.courseList;
            while (current != null && !current.courseCode.equals(courseCode)) {
                prev = current;
                current = current.nextCourse;
            }
            if (current != null) {
                if (prev == null) {
                    student.courseList = current.nextCourse;
                } else {
                    prev.nextCourse = current.nextCourse;
                }
            }
        }
    }

    // Bir dersteki bir öğrenciyi silme
    public void deleteStudentFromCourse(String courseCode, int studentId) {
        StudentNode student = findStudent(studentId);
        if (student != null) {
            CourseNode prev = null;
            CourseNode current = student.courseList;
            while (current != null && !current.courseCode.equals(courseCode)) {
                prev = current;
                current = current.nextStudent;
            }
            if (current != null) {
                if (prev == null) {
                    student.courseList = current.nextStudent;
                } else {
                    prev.nextStudent = current.nextStudent;
                }
            }
        }
    }

    // Bir dersteki tüm öğrencileri numara sırasına göre sıralı listeleme
    public void listStudentsInCourse(String courseCode) {
        StudentNode currentStudent = headStudent;
        while (currentStudent != null) {
            CourseNode currentCourse = currentStudent.courseList;
            while (currentCourse != null) {
                if (currentCourse.courseCode.equals(courseCode)) {
                    System.out.println("Student ID: " + currentStudent.studentId);
                }
                currentCourse = currentCourse.nextCourse;
            }
            currentStudent = currentStudent.next;
        }
    }

    // Bir öğrencinin aldığı tüm dersleri ders koduna göre sıralı listeleme
    public void listCoursesForStudent(int studentId) {
        StudentNode student = findStudent(studentId);
        if (student != null) {
            CourseNode[] courses = getAllCourses(student);
            Arrays.sort(courses, (a, b) -> a.courseCode.compareTo(b.courseCode));
            for (CourseNode course : courses) {
                System.out.println("Course Code: " + course.courseCode + ", Grade: " + course.grade);
            }
        }
    }

    private StudentNode findStudent(int studentId) {
        StudentNode current = headStudent;
        while (current != null) {
            if (current.studentId == studentId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private CourseNode[] getAllCourses(StudentNode student) {
        int count = 0;
        CourseNode current = student.courseList;
        while (current != null) {
            count++;
            current = current.nextCourse;
        }
        CourseNode[] courses = new CourseNode[count];
        current = student.courseList;
        int index = 0;
        while (current != null) {
            courses[index++] = current;
            current = current.nextCourse;
        }
        return courses;
    }

    public static void main(String[] args) {
        StudentCourseManager manager = new StudentCourseManager();
        manager.addCourseToStudent(1, "Math101", "A");
        manager.addCourseToStudent(1, "CS101", "B");
        manager.addStudentToCourse("Math101", 2, "C");

        System.out.println("Students in Math101:");
        manager.listStudentsInCourse("Math101");

        System.out.println("Courses for Student 1:");
        manager.listCoursesForStudent(1);
    }
}