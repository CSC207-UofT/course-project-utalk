package usecase.entityInfroTransfer;

import entity.Course;
import entity.CoursePage;
import entity.PostPage;

import java.util.ArrayList;
import java.util.HashMap;

public class CoursePageInfoGenerator {
    /**
     * @param cp CoursePage
     * @return student list of cp
     */
    public static ArrayList<String> studentList(CoursePage cp) {
        return cp.studentList();
    }

    /**
     * @param cp CoursePage
     * @return professor list of cp
     */
    public static ArrayList<String> professorList(CoursePage cp) {
        return cp.professorList();
    }

    /**
     * @return A list of string containing all semesters of PostPages in post_page_List,
     */
    public static ArrayList<String> semesterList(CoursePage cp){
        ArrayList<String> lst = new ArrayList<>();
        for(PostPage pg: cp.post_page_List) {
            if (! lst.contains(pg.semesterGetter())) {
                lst.add(pg.semesterGetter());
            }
        }
        return lst;
    }

    /**
     * @return A hashmap containing all PostPage information in post_page_List,
     * use semester as the key and PostPage as value
     */
    public static HashMap<String, PostPage> postPageHashMap(CoursePage cp){
        HashMap<String, PostPage> mp = new HashMap<>();
        for(PostPage pg: cp.post_page_List) {
            mp.put(pg.semesterGetter(), pg);
        }
        return mp;
    }

    /**
     * @param cp CoursePage
     * @return course information of coursePage
     */
    public Course getCourse(CoursePage cp){
        return cp.course;
    }

    /**
     * @param cp CoursePage
     * @return info_added of course page
     */
    public String getInfoAdd(CoursePage cp){
        return cp.info_added;
    }

    /**
     * @param cp CoursePage
     * @return cp's postpage length
     */
    public static int getLength(CoursePage cp){
        return cp.getLength();
    }
}
