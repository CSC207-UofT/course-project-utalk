package interfaceadaptor.readers;

import entity.*;
import usecase.creator.CommentableUserCreater;
import usecase.javastorage.AllCommentableUser;

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
        CommentReader.readComment(comments);

        }

    }
