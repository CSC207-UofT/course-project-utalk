package usecase.entityInfroTransfer;

import entity.Comment;
import entity.PostPage;

import java.util.ArrayList;

public class postContentGenerator {
    public static ArrayList<Comment> commentTransfer(PostPage pg) {
        return pg.posts;
    }

}
