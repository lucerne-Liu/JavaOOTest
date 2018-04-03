package practice10;


import com.sun.deploy.util.StringUtils;

import java.util.*;

public class Teacher extends Person {
    public static final String SUFFIX = ".";
    public final String PREFIX = super.introduce() + " I am a Teacher. I ";
    private Set<Klass> classes = new HashSet<>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Set<Klass> classes) {
        super(id, name, age);
        this.classes = new HashSet<>(classes);
    }


    public Set<Klass> getClasses() {
        return classes;
    }

    public void setClasses(Set<Klass> classes) {
        this.classes = new HashSet<>(classes);
    }

    @Override
    public String introduce() {
        String content = "No Class";
        if (classes.size() > 0) {
            List<String> classList = new ArrayList<>();
            classes.stream().forEach(item -> classList.add(String.valueOf(item.getNumber())));
            content = "Class " + StringUtils.join(classList, ", ");
        }
        return PREFIX + "teach " + content + SUFFIX;
    }

    public String introduceWith(Student student) {
        String text = "";
        if (!isTeaching(student)) {
            text = "don't ";
        }
        return PREFIX + text + "teach " + student.getName() + SUFFIX;
    }

    public boolean isTeaching(Student student) {
        for (Klass klass : classes) {
            if (klass.isIn(student)) {
                return true;
            }
        }
        return false;
    }
}
