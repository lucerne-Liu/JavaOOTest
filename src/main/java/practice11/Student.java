package practice11;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
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
        final String PREFIX = super.introduce() + " I am a Student. I am ";
        final String SUFFIX = " " + klass.getDisplayName() + ".";
        String text = "at";
        if (this == klass.getLeader()) {
            text = "Leader of";
        }
        return PREFIX + text + SUFFIX;
    }
}

