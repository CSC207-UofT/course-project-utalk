package usecase.createupdate;

import usecase.javastorage.AllCourses;

public class CourseCreatorTest{
    public static void main(String[] args){
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.containsKey("csc207");
        CourseCreator.createCourse("csc207", "software design", "fall 2021");
        assert AllCourses.coursePageHashMap.size() == 1;
    }


        }