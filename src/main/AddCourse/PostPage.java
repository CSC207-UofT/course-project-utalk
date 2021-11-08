package AddCourse;

import basics.Comment;

import java.util.ArrayList;

public class PostPage {
    ArrayList<Comment> comment_list;
    String semester;

    public PostPage(String semester) {
        this.comment_list = new ArrayList<>();
        this.semester = semester;
    }

    public String getSemester(){
        return this.semester;
    }

    public void addComment(Comment c){
        this.comment_list.add(c);
    }

    public boolean deleteComment(Comment c){
        if(this.comment_list.contains(c)){
            c.editComment("deleted");
            return true;
        }
        else{
            for(Comment cmt: this.comment_list){
                if (cmt.deleteReply(c)){
                    return true;
                }
            }
            return false;
        }
    }
}
