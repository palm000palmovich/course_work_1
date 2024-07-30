package pack;

public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[2];
        employee[0] = new Employee(new Fio("Мужик" , "Мужикович" , "Мужиков"),
                1, 12000);
        employee[1] = new Employee(new Fio("Муж" , "Мужович" , "Мужов"),
                2, 1200);

        /*for (int i = 0; i < employee.length; i++){
            System.out.println(employee[i]);
        }*/

    }
}