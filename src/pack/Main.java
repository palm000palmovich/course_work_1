package pack;

import java.security.Provider;

public class Main {
    public static void main(String[] args) {

        Servicer service1 = new Servicer();
        Employee[] employee = new Employee[10];

        //Работники
        employee[0] = new Employee(new Fio("Мужик" , "Мужикович" , "Мужиков"),
                1, 12000);
        employee[1] = new Employee(new Fio("Муж" , "Мужович" , "Мужов"),
                2, 1200);
        employee[2] = new Employee(new Fio("Чувак", "Чувакович", "Чуваков"),
                1, 13000);
        employee[3] = new Employee(new Fio("Герасим","Антонинович","Соболев"), 3, 34000);
        employee[4] = new Employee(new Fio("Семен","Андреевич","Королёв"), 5, 34050);
        employee[5] = new Employee(new Fio("Вацлава","Вячеславовна","Корапетян"), 2, 30000);
        employee[6] = new Employee(new Fio("Вячеслав","Ильич","Калинин"), 3, 69060);
        employee[7] = new Employee(new Fio("Елисей","Эдуардович","Калинин"), 4, 60060);
        employee[8] = new Employee(new Fio("Екатерина","Семеновна","Петка"), 4, 70060);
        employee[9] = new Employee(new Fio("Максим","Васильевич","Погодин"), 3, 69060);

        for (int i = 0; i < employee.length; i++){
            if (service1.checkDepartment(employee[i]) == true && service1.checkSalary(employee[i]) == true){
                System.out.println(soutMan(employee[i]));
            } else{
                throw new IllegalArgumentException("Недопустимое значение!");
            }

        }
        int minSalary = 0;
        //Массив с зарплатамми
        int[] all_salarys = new int[10];
        for (int i =0; i < employee.length; i++){
            all_salarys[i] = employee[i].getSalary();
        }

        System.out.println("Сумма всех ЗП");
        System.out.println(sumSalary(all_salarys) + " руб");

        System.out.println("Минимальная ЗП");
        minSalary = isMin(all_salarys);
        String people = "";
        for (int i = 0; i < employee.length; i++){
            if (employee[i].getSalary() == minSalary){
                people+= employee[i].getFio().getLastName() + " " + employee[i].getFio().getFirstName() + " " +
                        employee[i].getFio().getMiddleName();
            }
        }
        System.out.println("Самую маленькую ЗП получает " + people + " размером в " + minSalary + "  рублей.");

        System.out.println("Максимальная ЗП");
        int maxSalary = isMax(all_salarys);
        String people1 = "";
        for (int i = 0; i < employee.length; i++){
            if (employee[i].getSalary() == isMax(all_salarys)){
                people1+= employee[i].getFio().getLastName() + " " + employee[i].getFio().getFirstName() + " " +
                        employee[i].getFio().getMiddleName();
            }
        }
        System.out.println("Самую большую ЗП получает " + people1 + " размером в " + maxSalary + "  рублей.");

        System.out.println("Средняя ЗП");
        System.out.println(middleSalary(all_salarys.length, sumSalary(all_salarys)));
        System.out.println("ФИО всех сотрудников");
        for (int i = 0; i < employee.length; i++){
            allEmployees(employee[i].getFio());
        }
    }



    //Метод выводит информацию о работниках
    public static Employee soutMan(Employee man){
        return man;
    }

    //Сумма затрат в месяц на ЗП.
    public static int sumSalary(int[] mas){
        int sum = 0;
        for (int i = 0; i < mas.length; i++){
            sum+=mas[i];
        }
        return sum;
    }
    //сотрудник с минимальной ЗП
    public static int isMin(int[] salarys){
        int min = 1000000000;
        for (int i = 0; i < salarys.length; i++){
            if (salarys[i] < min){
                min = salarys[i];
            }

        }
        return min;
    }

    //сотрудник с максимальной ЗП
    public static int isMax(int[] salarys){
        int max = 0;
        for (int i = 0; i < salarys.length; i++){
            if (salarys[i] > max){
                max = salarys[i];
            }
        }

        return max;
    }

    //средняя ЗП
    public static float middleSalary(int x, int sum){
        return sum / x;

    }
    //ФИО всех сотрудников
    public static void allEmployees(Fio fio1){
        System.out.println(fio1.getLastName() + " " + fio1.getFirstName() + " " + fio1.getMiddleName());
    }
 }