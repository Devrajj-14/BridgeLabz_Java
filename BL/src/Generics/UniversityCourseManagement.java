package Generics;

import java.util.ArrayList;
import java.util.List;

abstract class CourseType{
    String name;
    CourseType(String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}
class ExamCourse extends CourseType{
    ExamCourse(String name) {
        super(name);
    }
}
class Assignment extends CourseType{
    Assignment(String name){
        super(name);
    }
}
class Research extends CourseType{
    Research(String name){
        super(name);
    }
}

class Courses<T extends CourseType>{
    List<T> course =new ArrayList<>();

    void addCourse(T courseName){
        course.add(courseName);
    }
    List<T> all(){
        return course;
    }
}

class Show{
    static void show(List<? extends CourseType>listt){
        for(CourseType c : listt){
            System.out.println(c);
        }
    }
}


public class UniversityCourseManagement {
    public static void main(String[] args){
        Courses<Research> c = new Courses<>();
        c.addCourse(new Research("AIML"));
        Courses<Assignment> a = new Courses<>();
        a.addCourse(new Assignment("Java"));

        Show.show(c.all());
        Show.show(a.all());
    }
}
