package pack;


import java.util.Objects;


public class Fio {
    private String firstName, middleName, lastName;

    //Конструктор
    public Fio(String firstName, String middleName, String lastName){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    //Геттеры
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fio fio = (Fio) o;
        return Objects.equals(firstName, fio.firstName) && Objects.equals(middleName, fio.middleName) && Objects.equals(lastName, fio.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }

    @Override
    public String toString() {
        return firstName + middleName + lastName;
    }
}


