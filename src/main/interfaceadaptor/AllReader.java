package interfaceadaptor;

import entity.*;
import usecase.createupdate.CourseCreator;
import usecase.enrolldropcourse.CourseEnroller;
import usecase.javastorage.AllCourses;
import usecase.javastorage.AllProfessors;
import usecase.javastorage.AllStudents;
import java.util.HashMap;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class AllReader {
    public static void readAll(){
        ArrayList<ArrayList<String>> users = CsvReader.readCsv("/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/user.csv");
        ArrayList<ArrayList<String>> courses = CsvReader.readCsv("/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/courses.csv");
        ArrayList<ArrayList<String>> students = CsvReader.readCsv("/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/students.csv");
        ArrayList<ArrayList<String>> professors = CsvReader.readCsv("/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/professors.csv");
        ArrayList<ArrayList<String>> comments = CsvReader.readCsv("/Users/lizeyuan/IdeaProjects/course-project-utalk/course-project-utalk/src/main/outerlayer/database/comments.csv");
        for (ArrayList<String> user: users){
            if (Objects.equals(user.get(3), "student")){
                Student student = new Student(user.get(0), user.get(1), user.get(2));
                AllStudents.StudentHashMap.put(user.get(1), student);
            } else if (Objects.equals(user.get(3), "professor")){
                Professor professor = new Professor(user.get(0), user.get(1), user.get(2));
                AllProfessors.ProfessorHashMap.put(user.get(1), professor);
            }
        }
        for (ArrayList<String> course: courses){
            CourseCreator.createCourse(course.get(0), course.get(1), course.get(2));
        }
        for (ArrayList<String> student: students){
            String studentName = student.get(0);
            for (String course:student){
                CourseEnroller.enrollCourse(course, AllStudents.StudentHashMap.get(studentName));
            }
        }
        for (ArrayList<String> professor: professors){
            String professorName = professor.get(0);
            for (String course: professor){
                CourseEnroller.enrollCourse(course, AllProfessors.ProfessorHashMap.get(professorName));
            }
        }

        HashMap<String, ArrayList<String>>  read = new HashMap<>();
        for (ArrayList<String> comment: comments){

            String courseCode = comment.get(0);
            String semester = comment.get(1);
            Integer ID = Integer.valueOf(comment.get(2));
            String author = comment.get(3);
            String content = comment.get(4);
            Integer replyID = Integer.valueOf(comment.get(5));
            boolean status = comment.get(6).equals("true");
            Integer replyTo = Integer.valueOf(comment.get(7));
            CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
            if(!read.containsKey(courseCode)){
                ArrayList<String> initial = new ArrayList<>();
                read.put(courseCode, initial);
            }else{
                if(! read.get(courseCode).contains(semester)){
                    PostPage postPage = new PostPage(semester);
                    coursepage.post_page_List.add(postPage);
                }
            }
            Comment newComment = new Comment(author, content, courseCode, replyTo, ID);
            newComment.setReplyID(replyID);
            newComment.setStatus(status);
            HashMap<String, PostPage> map = coursepage.postPageHashMap();
            map.get(semester).getComments().put(ID, newComment);
            if (AllProfessors.ProfessorHashMap.containsKey(author)){
                AllProfessors.ProfessorHashMap.get(author).addCommentToList(courseCode, newComment);
            }
            if (AllStudents.StudentHashMap.containsKey(author)){
                AllStudents.StudentHashMap.get(author).addCommentToList(courseCode, newComment);
            }

        }
        for (String courseCode: read.keySet()){
            CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
            for(PostPage postPage: coursepage.getPost_page_List()){
                for(Comment comment : postPage.getComments().values()){
                    if (comment.getReplyTo().equals(0)){
                        postPage.posts.add(comment);
                    }
                    else {
                        Integer a = comment.getReplyTo();
                        Comment commentToReply = postPage.getComments().get(a);
                        commentToReply.addReply(comment);
                    }

                }
            }
        }


    }
}
