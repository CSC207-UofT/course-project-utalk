package interface_adaptor.Presenter;
import use_case.JavaStorage.AllCourses;
import entity.CoursePage;
import entity.PostPage;

import java.util.ArrayList;

public class CourseCommentPresenter {
    public void CourseCommentPresenter(String course) {
        CoursePage cour = AllCourses.coursePageHashMap.get(course);
        ArrayList<PostPage> post_list = cour.post_page_List;
        PostPagePrinter postprint = new PostPagePrinter();
        for(PostPage page: post_list){
            postprint.PagePrinter(page);
        }
    }
}
