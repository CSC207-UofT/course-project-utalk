package interfaceadaptor.readers;

import entity.*;
import interfaceadaptor.CsvReader;
import usecase.creator.CommentableUserCreater;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static outerlayer.userinterface.FilePathHelper.FILEPATH;

public class AllReader {
    public static void readAll(){
        ArrayList<ArrayList<String>> users = CsvReader.readCsv(FILEPATH + "/user.csv");
        ArrayList<ArrayList<String>> courses = CsvReader.readCsv(FILEPATH + "/courses.csv");
        ArrayList<ArrayList<String>> commentableUsers = CsvReader.readCsv(FILEPATH + "/commentableuser.csv");
        ArrayList<ArrayList<String>> comments = CsvReader.readCsv(FILEPATH + "/comments.csv");
        for (ArrayList<String> user: users){
            String name = user.get(1);
            HashMap<String, CommentableUser> curr = AllCommentableUser.getAllCommentableUsers();
            if (Objects.equals(user.get(3), "student")){
                Student student = new Student(user.get(0), user.get(1), user.get(2));
                curr.put(name, student);
            } else if (Objects.equals(user.get(3), "professor")){
                Professor professor = new Professor(user.get(0), user.get(1), user.get(2));
                curr.put(name, professor);
            }
            AllCommentableUser.setAllCommentableUsers(curr);
        }
        CourseReader.readCourse(courses);
        CommentableUserCreater.readUser(commentableUsers);
        
        HashMap<String, ArrayList<String>> read = new HashMap<>();


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
            if (AllCommentableUser.getAllCommentableUsers().containsKey(author)){
                AllCommentableUser.getAllCommentableUsers().get(author).addCommentToList(courseCode, newComment);
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
                postPage.setCurrentID(postPage.getComments().size());
            }
        }

    }
}
