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