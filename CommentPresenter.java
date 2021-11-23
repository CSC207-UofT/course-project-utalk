package AddCourse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class CommentPresenter implements Presenter {

    @Override
    public String present_info(Object O) {
        HashMap<String, CoursePage> mp = (HashMap<String, CoursePage>) ;
        Iterator<Map.Entry<String, CoursePage>> it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            CoursePage coursepage = AllCourses.coursePageHashMap.get(Course_code);
            coursepage.post_page_List.get(-1).comments.put(comment.id, comment);
        }
    }
}
