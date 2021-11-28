package main.entity;

import java.util.HashMap;

public class CoursePageMap {

    private HashMap<String, CoursePage> map;

    public CoursePageMap(){
        this.map = new HashMap<>();
    }

    public HashMap<String, CoursePage> getMap(){return this.map;}
}
