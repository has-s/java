/**
 * Класс, представляющий сущность "Человек" с персональными данными.
 * Включает поля для идентификации, имени, пола, отдела, зарплаты и даты рождения.
 */
public class Person {
    private int id;
    private String name;
    private String gender;
    private Department department;
    private double salary;
    private String birthDate;

    public Person() {
        this.id = 0;
        this.name = "";
        this.gender = "";
        this.department = null;
        this.salary = 0.0;
        this.birthDate = "";
    }

    public Person(int id, String name, String gender, Department department, double salary, String birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public Department getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
    public String getBirthDate() {
        return birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' +
                ", gender='" + gender + '\'' + ", department=" + department +
                ", salary=" + salary + ", birthDate='" + birthDate + '\'' + '}';
    }
}
