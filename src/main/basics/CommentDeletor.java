package basics;

import AddCourse.AllCourses;
import AddCourse.CoursePage;
import AddCourse.PostPage;

public class CommentDeletor {
    CommentableUser commentableUser;

    public CommentDeletor(CommentableUser commentableUser){
        this.commentableUser = commentableUser;
    }

    public String deleteComment(int commentId, String courseCode) {
        CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
        if (!coursepage.professor_list.contains((Professor)this.commentableUser)) {
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
}
