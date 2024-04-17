public class Person {
    private String name;
    private String description = "none";
    public Person(String personName){
        name = personName;
    }


    //getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
