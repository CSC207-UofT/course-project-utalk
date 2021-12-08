package usecase.entityInfroTransfer;

import entity.Course;
import entity.CoursePage;
import entity.PostPage;

import java.util.ArrayList;
import java.util.HashMap;

public class CoursePageInfoGenerator {
    public static ArrayList<String> studentList(CoursePage cp) {
        return cp.studentList();
    }
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
    public Course getCourse(CoursePage cp){
        return cp.course;
    }
    public String getInfoAdd(CoursePage cp){
        return cp.info_added;
    }
    public static int getLength(CoursePage cp){
        return cp.getLength();
    }
}
