package basics;

import AddCourse.AllCourses;
import AddCourse.CoursePage;
import AddCourse.PostPage;

import java.util.ArrayList;
import java.util.HashMap;

public class Professor extends CommentableUser{

    private ArrayList<CoursePage> taughtCourses;
    private HashMap<String, ArrayList<Comment>> comments;


    Professor(String identifier, String userName, String password) {
        super(identifier, userName, password);
        this.comments = new HashMap<>();
        this.taughtCourses = new ArrayList<>();
    }

    public String deleteComment(int commentId, String courseCode) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
        if (!coursepage.professor_list.contains(this)) {
            return "You are not professor of this course";
        } else {
            int index = coursepage.post_page_List.size();
            PostPage postpage = coursepage.post_page_List.get(index - 1);
            if (commentId > postpage.current_id) {
                return "Wrong id";
            } else {
                postpage.comments.get(commentId).status = false;
                return "Deleted successfully";
            }
        }
    }

    public void enrollCourse(String courseCode) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
        taughtCourses.add(coursepage);
        coursepage.professor_list.add(this);
        ArrayList<Comment> comment = new ArrayList<>();
        comments.put(courseCode, comment);
    }

    public void deleteCourse(String courseCode) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
        taughtCourses.remove(coursepage);
        coursepage.professor_list.remove(this);

    }
    @Override
    public void user_comment(String course) {
        for(Comment comment: this.comments.get(course)) {
            comment.Print_Comment(0);
        }
    }
}