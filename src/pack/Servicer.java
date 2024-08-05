package pack;

public class Servicer {
    //Проверка департамента
    public boolean checkDepartment(Employee employee1){
        return (employee1.getDepartment() >= 1 && employee1.getDepartment() <= 5);
    }
    //Проверка зп
    public boolean checkSalary(Employee employee1){
        return (employee1.getSalary() > 0);
    }
}
