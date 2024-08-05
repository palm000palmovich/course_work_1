package pack;


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
        employee[3] = new Employee(new Fio("Герасим","Антонинович","Соболев"), 5, 34000);
        employee[4] = new Employee(new Fio("Семен","Андреевич","Королёв"), 5, 34050);
        employee[5] = new Employee(new Fio("Вацлава","Вячеславовна","Корапетян"), 2, 30000);
        employee[6] = new Employee(new Fio("Вячеслав","Ильич","Калинин"), 3, 69060);
        employee[7] = new Employee(new Fio("Елисей","Эдуардович","Калинин"), 4, 60060);
        employee[8] = new Employee(new Fio("Екатерина","Семеновна","Петка"), 4, 70060);
        employee[9] = new Employee(new Fio("Максим","Васильевич","Погодин"), 3, 69060);

        //вывод инфы о всех сотрудниках
        for (int i = 0; i < employee.length; i++){
            System.out.println(soutMan(employee[i]));
        }


        int[] allSalarys = new int[10];   //Массив с зарплатамми
        for (int i =0; i < employee.length; i++){
            allSalarys[i] = employee[i].getSalary();
        }
        //сумма всех зп
        System.out.println("Сумма всех ЗП");
        System.out.println(sumSalary(allSalarys) + " руб");

        //минимальная ЗП
        System.out.println(isMin(employee));

        //максимальная зп
        System.out.println(isMax(employee));

        //средняя зп
        System.out.println(middleSalary(employee.length, sumSalary(allSalarys)));
        for (int i = 0; i < 2; i++){
            System.out.println('\n');

        }

        //все фио
        for (int i = 0; i < employee.length; i++){
            allEmployees(employee[i].getFio());

        }
        

    //1 УРОВЕНЬ
    //Метод выводит информацию о работниках
    public static Employee soutMan(Employee man){
        Servicer serv = new Servicer();
        Employee chel = new Employee(new Fio("","",""),0,0);
        if (serv.checkDepartment(man) && serv.checkSalary(man)){
            chel = man;
        } else{
            throw new IllegalArgumentException("Недопустимое значение!");
        }
        return chel;
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
    public static String isMin(Employee[] men){
        int[] allSalary = new int[men.length];
        Employee chel = new Employee(new Fio("", "", ""), 0,0);

        for (int i = 0; i < men.length; i++){
            allSalary[i] = men[i].getSalary();
        }
        int min = allSalary[0];
        for (int i = 0; i < men.length; i++){
            if (allSalary[i] < min){
                min = allSalary[i];
                chel = men[i];
            }
        }
        return "Минимальная зп у (" + chel + ") " + " в размере: "  + min;
    }

    //сотрудник с максимальной ЗП
    public static String isMax(Employee[] men){
        int[] allSalary = new int[men.length];
        Employee chel = new Employee(new Fio("", "", ""), 0,0);

        for (int i = 0; i < men.length; i++){
            allSalary[i] = men[i].getSalary();
        }
        int max = allSalary[0];
        for (int i = 0; i < men.length; i++){
            if (allSalary[i] > max){
                max = allSalary[i];
                chel = men[i];
            }
        }
        return "Максимальная зп у (" + chel + ") " + " в размере: "  + max;
    }

    //средняя ЗП
    public static String middleSalary(int x, int sum){
        return "Средняя ЗП " + sum / x;

    }
    //ФИО всех сотрудников
    public static void allEmployees(Fio fio1){
        System.out.println(fio1.getLastName() + " " + fio1.getFirstName() + " " + fio1.getMiddleName());
    }

}
