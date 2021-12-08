package usecase.adddeleteeditcomment;
import entity.CommentableUser;
import entity.CoursePage;
import entity.PostPage;
import usecase.javastorage.AllCourses;
import entity.Comment;



public class CommentAdder {
    /**
     * add comment to the comment list in postpage
     * @param comment the comment to add
     */
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
    public static Comment commentConstructor(String username, String comment, String course_code, Integer replyTo, Integer id){
        return new Comment(username, comment, course_code, replyTo, id);
    }

    /**
     * add comment
     * @param user user making comment
     * @param course_code course code of comment
     * @param content the content of comment
     * @param replyto the id of comment user is replying to, if reply to nothing, input is 0
     * @return string indicate whether they add it successfully
     */

    public static String addComment(CommentableUser user, String course_code, String content, Integer replyto ){
        if (!CanChange.canAddComment(course_code, replyto, user)){
            return "Sorry, you can't add that comment.";
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
            return "Your comment has been post.";

        }

    }




}

