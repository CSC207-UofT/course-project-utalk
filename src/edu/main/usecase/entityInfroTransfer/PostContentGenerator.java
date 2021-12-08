package usecase.entityInfroTransfer;

import entity.Comment;
import entity.PostPage;

import java.util.ArrayList;

public class PostContentGenerator {
    /**
     * @param pg PostPage
     * @return comments in the PostPage pg
     */
    public static ArrayList<Comment> commentTransfer(PostPage pg) {
        return pg.posts;
    }

}
