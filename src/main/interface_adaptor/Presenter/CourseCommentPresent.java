package interface_adaptor.Presenter;

import entity.CoursePage;
import entity.PostPage;
import use_case.JavaStorage.AllCourses;


import java.util.ArrayList;

public class CourseCommentPresent {
    public void CourseCommentPresenter(String course) {
        CoursePage cour = AllCourses.coursePageHashMap.get(course);
        ArrayList<PostPage> post_list = cour.post_page_List;
        PostPagePrint postprint = new PostPagePrint();
        for(PostPage page: post_list){
            postprint.PagePrinter(page);
        }
    }
}
