package usecase.adddeleteeditcomment;
import entity.CommentableUser;
import entity.CoursePage;
import entity.PostPage;
import usecase.javastorage.AllCourses;
import entity.Comment;
import usecase.javastorage.AllCourses;

public class CommentAdder {
    public static void addHelper(Comment comment ){
        CoursePage coursepage = AllCourses.coursePageHashMap.get(comment.getCourseCode());
        int length = coursepage.getLength();
        PostPage postpage = coursepage.post_page_List.get(length - 1);
        postpage.comments.put(comment.getId(), comment);
        if (comment.getReplyTo().equals(0)){
            postpage.posts.add(comment);
        }
        else{
            postpage.comments.get(comment.getReplyTo()).addReply(comment);
        }


    }

    public static void addComment(CommentableUser user, String course_code, String content, Integer replyto ){
        if (!canChange.canAddComment(course_code, replyto, user)){
            System.out.println("can't add");
        }
        else{
            CoursePage coursepage = AllCourses.coursePageHashMap.get(course_code);
            int length = coursepage.getLength();
            PostPage postpage = coursepage.post_page_List.get(length - 1);
            postpage.refreshID();
            Integer a = postpage.getCurrentID();



            Comment comment = new Comment(user.getUserName(), content, course_code, 0, a);
            addHelper(comment);
            user.getComments().get(course_code).add(comment);
            System.out.println("succeed!");

        }

    }




}

