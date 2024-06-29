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