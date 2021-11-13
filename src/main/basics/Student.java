
package basics;

import AddCourse.AllCourses;
import AddCourse.CoursePage;
import AddCourse.PostPage;

import java.util.ArrayList;
import java.util.HashMap;

public class Student extends CommentableUser{
    private ArrayList<String> studentCourse;
    private String password;
    private HashMap<String, ArrayList<Comment>> studentComments;

    public Student(String student_name, String identifier, String password) {
        super(student_name, identifier, password);
        this.password = password;
        this.studentComments= new HashMap<>();
        this.studentCourse = new ArrayList<>();
    }

    public String deleteComment(int commentId, String courseCode) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
        PostPage postPage = coursepage.post_page_List.get(coursepage.post_page_List.size() - 1);
        Comment comment = postPage.comments.get(commentId);
        if (comment.user_name.equals(user_name)) {
            comment.status = false;
            return "Deleted successfully";
        } else {
            return "You can not delete this comment";
        }
    }

    public void enrollCourse(String courseCode) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
        studentCourse.add(courseCode);
        coursepage.student_list.add(this);
        ArrayList<Comment> comments = new ArrayList<>();
        studentComments.put(courseCode, comments);
    }

    public void deleteCourse(String courseCode) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
        studentCourse.remove(coursepage);
        coursepage.student_list.remove(this);

    }


    public boolean passwordMatches(String password) {
        return password.equals(this.password);
    }
    @Override
    public void user_comment(String course) {
        for(Comment comment: this.studentComments.get(course)) {
            comment.Print_Comment(0);
        }
    }
}
