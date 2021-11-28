package main.entity;

import java.util.ArrayList;

public class CoursePage {
    private ArrayList<PostPage> postPageList;
    private ArrayList<String> students;
    private ArrayList<String> professors;
    private final Course course;

    public CoursePage(Course course) {
        this.course = course;
        this.postPageList = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public PostPage getPostPage(int index){
        return this.postPageList.get(index);
    }

    public void addPostPage(PostPage postpage){ this.postPageList.add(postpage);}

    public boolean isStudent(String username){
        return this.students.contains(username);
    }

    public boolean isProfessor(String username){
        return this.professors.contains(username);
    }

    public int getLength(){
        return this.postPageList.size();
    }

}