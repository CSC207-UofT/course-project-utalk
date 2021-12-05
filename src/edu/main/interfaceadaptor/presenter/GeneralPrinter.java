package interfaceadaptor.presenter;

import entity.CommentableUser;

/**
 * GeneralPrinter interface containing frequently used presenter methods
 */
public interface GeneralPrinter {
    public void presenterRequiresUserInfo(String course, CommentableUser commentableUser);

    public void generalPresenter(String course);
}
