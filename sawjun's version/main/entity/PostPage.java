package main.entity;

import java.util.HashMap;
import java.util.HashSet;

public class PostPage {
    private HashMap<Integer, Comment> commentList;
    private Integer commentID;
    private final String semester;
    private HashSet<String> students;
    private HashSet<String> professors;

    public PostPage(String semester) {
        this.commentList = new HashMap<>();
        this.semester = semester;
        this.professors = new HashSet<>();
        this.students = new HashSet<>();
        this.commentID = 1;
        }

    public String getSemester(){
        return this.semester;
    }

    public void addComment(Comment c){
        this.commentList.put(this.commentID, c);
        this.commentID += 1;
    }

    public boolean isStudent(String username){
        return this.students.contains(username);
    }

    public boolean isProfessor(String username){
        return this.professors.contains(username);
    }

    public HashMap<Integer, Comment> getCommentList(){return this.commentList;}
}
