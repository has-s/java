/**
 * Класс, представляющий сущность "Отдел" с идентификатором и названием.
 * Используется для организации данных о работников в структурированном виде.
 */
public class Department {
    private int id;
    private String name;

    public Department() {
        this.id = 0;
        this.name = "";
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
