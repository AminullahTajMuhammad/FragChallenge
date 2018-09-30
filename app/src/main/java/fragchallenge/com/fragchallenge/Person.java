package fragchallenge.com.fragchallenge;

public class Person {
    private String name;
    private String number;
    private String modelName;

    public Person(String name, String number, String modelName) {
        this.name = name;
        this.number = number;
        this.modelName = modelName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
