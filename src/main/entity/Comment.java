package entity;

import java.util.HashSet;

public class Comment {
    public HashSet<Comment> replies;
    public String user_name;
    public boolean status;
    public String content;
    public Integer id;

    public void Print_Comment(int i) {
    }
    // in our previous implementation comment is recursively implemented, I suggest to use tree data structure to
    // implement, maybe AVL tree is better, but it's still a binary tree data structure.

}
