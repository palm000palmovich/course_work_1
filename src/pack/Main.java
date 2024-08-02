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

        for (int i = 0; i < 2; i++){
            System.out.println('\n');

        ///////////////////////////////////////////
        }        System.out.println("ПОВЫШЕННЫЙ УРОВЕНЬ СЛОЖНОСТИ");
        System.out.println("Индексация зп");
        for (int i = 0; i < employee.length; i++){
            indexSalary(16, employee[i]);
            System.out.println(soutMan(employee[i]));
        }

        System.out.println("Действия с персоналом по номеру отдела");
        System.out.println(minSalaryDepartment(3,employee));
    }

    //2 УРОВЕНЬ
    public static String minSalaryDepartment(int department, Employee[] employees){
        int min = 1000000;
        Employee dudeee = new Employee(new Fio("fsv" , "sfsf", "sfsf"), 1,1200);
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getDepartment() == department && employees[i].getSalary() < min){
                min = employees[i].getSalary();
                dudeee = employees[i];
            }
        }
        return "В отделе " + dudeee.getDepartment()+ " самая маленькая зп у " + dudeee.getFio().getLastName() + " " + dudeee.getFio().getFirstName() + " " +
                dudeee.getFio().getMiddleName() + " размером в " + min + " руб." ;
    }

    //Индексация зп
    public static void indexSalary(int percent, Employee dude){
        if (percent >= -100 && percent <= 100){
            dude.setSalary(dude.getSalary() + dude.getSalary() * percent/100);
        } else{
            throw new IllegalArgumentException("Недопустимое значение индекса!");
        }
    }


    //1 УРОВЕНЬ
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
