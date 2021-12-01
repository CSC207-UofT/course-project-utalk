package interfaceadaptor.readers;

import entity.Professor;
import entity.Student;
import interfaceadaptor.CsvReader;
import usecase.creator.ProfessorCreator;
import usecase.creator.StudentCreator;
import usecase.javastorage.AllProfessors;
import usecase.javastorage.AllStudents;

import java.util.ArrayList;
import java.util.Objects;

public class AllReader {
    public static void readAll(){
        ArrayList<ArrayList<String>> users = CsvReader.readCsv("/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/user.csv");
        ArrayList<ArrayList<String>> students = CsvReader.readCsv("/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/students.csv");
        ArrayList<ArrayList<String>> professors = CsvReader.readCsv("/Users/hanqizhang/Desktop/CSC207/course-project-utalk11/src/main/outerlayer/database/professors.csv");
        for (ArrayList<String> user: users){
            if (Objects.equals(user.get(3), "student")){
                Student student = new Student(user.get(0), user.get(1), user.get(2));
                AllStudents.StundetHashMap.put(user.get(1), student);
            } else if (Objects.equals(user.get(3), "professor")){
                Professor professor = new Professor(user.get(0), user.get(1), user.get(2));
                AllProfessors.ProfessorHashMap.put(user.get(1), professor);
            }
        }
        CourseReader.readCourse();
        StudentCreator.createStudent(students);
        ProfessorCreator.createProfessor(professors);
        
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
