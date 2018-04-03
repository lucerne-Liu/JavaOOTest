package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> members = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void attach(Teacher teacher){
        teachers.add(teacher);
    }
    public String getDisplayName() {
        return "Class " + number;
    }

    //notify the change to the observers
    public void notifyTeachers(Student student, int flag) {
        for (Teacher teacher : teachers) {
            teacher.update(student, this, flag);
        }
    }

    public void appendMember(Student student) {
        members.add(student);
        notifyTeachers(student,0);
    }

    public void assignLeader(Student student) {
        if (members.contains(student)) {
            this.leader = student;
            notifyTeachers(student,1);
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public boolean isIn(Student student) {
        return members.contains(student) || number == student.getKlass().getNumber();
    }
}
