package main.presenter;

import main.entity.Comment;
import main.usecase.CommentPresenter;

import java.util.Scanner;

public class CommentInterface {
    public CommentInterface() {
    }

    public void printCommentInterface(Comment comment){
        CommentPresenter cp = new CommentPresenter(comment);
        System.out.println(cp.getComments());
        System.out.println("What would you like to do?");
        System.out.print("1: Add Comment 2: Edit Comment 3: Delete Comment 4: View Comment");
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        switch (str1){
            case "1" -> {
                System.out.print("Please enter your comment: ");
                String str2 = sc.nextLine();
                //get the instance variables for the method somehow
                //get the user somehow
                //call the Comment adder
            }
            case "2" -> {
                System.out.print("Please enter the index of the comment you would like to edit: ");
                int index = sc.nextInt();
                //get the instance variables for the method somehow
                //get the user somehow
                //call the CommentEditor
            }
            case "3" -> {
                System.out.print("Please enter the index of the comment you would like to delete: ");
                int index = sc.nextInt();
                //get the instance variables for the method somehow
                //get the user somehow
                //call the CommentEditor
            }
            case "4" -> {
                System.out.print("Please enter the index of the comment you would like to view: ");
                int index = sc.nextInt();
                Comment newc = comment.getReply(index);
                this.printCommentInterface(newc);

            }
            //add back function case.
            default -> {
                System.out.println("Invalid command please try again.");

            }
        }

    }

}
