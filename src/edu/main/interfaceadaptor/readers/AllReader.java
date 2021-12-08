package interfaceadaptor.readers;

import entity.*;
import usecase.creator.CommentableUserCreater;
import usecase.javastorage.AllCommentableUser;
import usecase.userfactory.UserFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static outerlayer.userinterface.FilePathHelper.FILEPATH;

public class AllReader {
    /**
     * read all the information in the user courses commentableuser and comments csv files
     */
    public static void readAll(){
        ArrayList<ArrayList<String>> users = CsvReader.readCsv(FILEPATH + "/user.csv");
        ArrayList<ArrayList<String>> courses = CsvReader.readCsv(FILEPATH + "/courses.csv");
        ArrayList<ArrayList<String>> commentableUsers = CsvReader.readCsv(FILEPATH + "/commentableuser.csv");
        ArrayList<ArrayList<String>> comments = CsvReader.readCsv(FILEPATH + "/comments.csv");
        HashMap<String, CommentableUser> curr = new HashMap<>();
        for (ArrayList<String> user: users){
            String name = user.get(1);
            if (!(Objects.equals(user.get(3),"Faculty"))){
            String[] input = new String[] {user.get(0), user.get(1), user.get(2),user.get(3)};
            curr.put(name, (CommentableUser) UserFactory.create(input)); }
        }
        AllCommentableUser.setAllCommentableUsers(curr);
        CourseReader.readCourse(courses);
        CommentableUserCreater.readUser(commentableUsers);
        CommentReader.readComment(comments);

        }

    }
