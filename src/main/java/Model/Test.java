package Model;

import java.util.Objects;

public class Test {
    private String name;
    private boolean employed;

    public Test(){
        name="Doe";
        employed=false;
    }

    public boolean isEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return employed == test.employed &&
                Objects.equals(name, test.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employed);
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", employed=" + employed +
                '}';
    }
}
