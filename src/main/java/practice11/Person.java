package practice11;

public class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object otherObject) {
        // a quick test to see if the objects are identical
        if (this == otherObject)
            return true;

        // must return false if the explicit parameter is null
        if (otherObject == null)
            return false;

        // if the classed don't match,they can't be equal
        if (getClass() != otherObject.getClass())
            return false;

        Person other = (Person) otherObject;
        // test whether the fields hava identical values
        return id == other.getId();

    }

    public String introduce() {
        return "My name is " + name + ". I am " + age + " years old.";
    }
}
