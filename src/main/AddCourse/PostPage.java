package AddCourse;

import basics.Comment;

import java.util.ArrayList;

public class PostPage {
    ArrayList<Comment> comment_list;
    String semester;

    PostPage(String semester_1) {
        this.comment_list = new ArrayList<>();
        semester = semester_1;
    }

    public String getSemester(){
        return this.semester;
    }

    public void addComment(Comment c){
        this.comment_list.add(c);
    }
    public void swapComment(Comment c, Comment d){
        int i = this.comment_list.indexOf(c);
        this.comment_list.remove(i);
        this.comment_list.add(i, d);
    }

    public void deleteComment(Comment c){
        this.comment_list.remove(c);
    }

    /** Think we should move Faculty, PostPage, CoursePage into basics
    public void deleteReply(Comment c, Comment reply){
        int i = this.comment_list.indexOf(c);
        Comment d = this.comment_list.get(i);
        d.replies.remove(reply);
    }
    */
}
