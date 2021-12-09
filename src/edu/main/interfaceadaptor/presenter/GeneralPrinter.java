package interfaceadaptor.presenter;

import entity.CommentableUser;

/**
 * GeneralPrinter interface containing frequently used presenter methods
 */
public interface GeneralPrinter {
    void presenterRequiresUserInfo(String course, CommentableUser commentableUser);
    void generalPresenter(String course);
}
