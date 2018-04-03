package practice07;

public class Teacher extends Person {
    public static final String SUFFIX = ".";
    public final String PREFIX = super.introduce() + " I am a Teacher. I ";
    private Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return PREFIX + "teach " + (klass != null ? klass.getDisplayName() : "No Class") + SUFFIX;
    }

    public String introduceWith(Student student) {
        String text = "";
        if (student.getKlass().getNumber() != klass.getNumber()) {
            text = "don't ";
        }
        return PREFIX + text + "teach " + student.getName() + SUFFIX;
    }

}


