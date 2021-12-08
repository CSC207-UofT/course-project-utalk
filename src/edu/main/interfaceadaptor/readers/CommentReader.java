package interfaceadaptor.readers;

import entity.Comment;
import entity.CoursePage;
import entity.PostPage;
import usecase.javastorage.AllCommentableUser;
import usecase.javastorage.AllCourses;

import java.util.ArrayList;
import java.util.HashMap;

public class CommentReader {
    /**read all the comment and store them into the HashMap
     * @param comments all comment info stored in ArrayList<ArrayList<String>>
     */
    public static void readComment(ArrayList<ArrayList<String>> comments) {
        HashMap<String, ArrayList<String>> read = new HashMap<>();

// TODO: extract the first part and create a CommentCreator class.
        for (ArrayList<String> comment : comments) {

            String courseCode = comment.get(0);
            String semester = comment.get(1);
            Integer ID = Integer.valueOf(comment.get(2));
            String author = comment.get(3);
            String content = comment.get(4);
            Integer replyID = Integer.valueOf(comment.get(5));
            boolean status = comment.get(6).equals("true");
            Integer replyTo = Integer.valueOf(comment.get(7));
            CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
            if (!read.containsKey(courseCode)) {
                ArrayList<String> initial = new ArrayList<>();
                read.put(courseCode, initial);
            } else {
                if (!read.get(courseCode).contains(semester)) {
                    PostPage postPage = new PostPage(semester);
                    coursepage.post_page_List.add(postPage);
                }
            }
            Comment newComment = new Comment(author, content, courseCode, replyTo, ID);
            newComment.setReplyID(replyID);
            newComment.setStatus(status);
            HashMap<String, PostPage> map = coursepage.postPageHashMap();
            map.get(semester).getComments().put(ID, newComment);
            if (AllCommentableUser.getAllCommentableUsers().containsKey(author)) {
                AllCommentableUser.getAllCommentableUsers().get(author).addCommentToList(courseCode, newComment);
            }

        }
        for (String courseCode : read.keySet()) {
            CoursePage coursepage = AllCourses.coursePageHashMap.get(courseCode);
            for (PostPage postPage : coursepage.getPost_page_List()) {
                for (Comment comment : postPage.getComments().values()) {
                    if (comment.getReplyTo().equals(0)) {
                        postPage.posts.add(comment);
                    } else {
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
