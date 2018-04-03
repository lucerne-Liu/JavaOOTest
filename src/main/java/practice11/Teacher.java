package practice11;

//import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Teacher extends Person {
    public final String PREFIX = super.introduce() + " I am a Teacher. I ";
    public static final String SUFFIX = ".";
    private Set<Klass> classes = new HashSet<>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Set<Klass> classes) {
        super(id, name, age);
        this.classes = new HashSet<>(classes);
        //add observers
        classes.stream().forEach(item -> item.attach(this));
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

            //更改为不使用StringUtils.join()
//            classes.stream().mapToInt(item -> item.getNumber()).sorted().forEach(item -> classList.add(String.valueOf(item)));
//            content = "Class " + StringUtils.join(classList, ", ");

            content = "Class " + join(classes.stream().mapToInt(item -> item.getNumber()).sorted().toArray(), ", ");
        }
        return PREFIX + "teach " + content + SUFFIX;
    }

    //替代org.apache.commons.lang3.StringUtils的join方法
    public String join(int[] array, String separator) {
        int len = array.length;
        StringBuilder buf = new StringBuilder(len * 16);
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                buf.append(separator);
            }
            buf.append(array[i]);
        }
        return buf.toString();
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

    //Observers update,flag = 0 for joining in the class, flag = 1 for becoming the leader
    public void update(Student student, Klass klass, int flag) {
        final String STARTTEXT = "I am Tom. I know " + student.getName();
        final String ENDTEXT = " Class " + klass.getNumber() + ".\n";
        String content = "";
        if (flag == 0) {
            content = " has joined";
        } else {
            content = " become Leader of";
        }
        System.out.print(STARTTEXT + content + ENDTEXT);
    }

}
