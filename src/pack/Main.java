package pack;


public class Main {
    public static void main(String[] args) {
        System.out.println("");
        Servicer service1 = new Servicer();
        Employee[] employee = new Employee[10];

        //Работники
        employee[0] = new Employee(new Fio("Мужик" , "Мужикович" , "Мужиков"),
                1, 120000);
        employee[1] = new Employee(new Fio("Муж" , "Мужович" , "Мужов"),
                2, 1200);
        employee[2] = new Employee(new Fio("Чувак", "Чувакович", "Чуваков"),
                3, 13000);
        employee[3] = new Employee(new Fio("Герасим","Антонинович","Соболев"), 5, 34000);
        employee[4] = new Employee(new Fio("Семен","Андреевич","Королёв"), 5, 34050);
        employee[5] = new Employee(new Fio("Вацлава","Вячеславовна","Корапетян"), 2, 3000);
        employee[6] = new Employee(new Fio("Вячеслав","Ильич","Калинин"), 3, 69060);
        employee[7] = new Employee(new Fio("Елисей","Эдуардович","Калинин"), 4, 60060);
        employee[8] = new Employee(new Fio("Екатерина","Семеновна","Петка"), 4, 70060);
        employee[9] = new Employee(new Fio("Максим","Васильевич","Погодин"), 3, 69080);

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

        ////////////////////////////////////////////
        System.out.println("ПОВЫШЕННЫЙ УРОВЕНЬ СЛОЖНОСТИ");
        System.out.println("Индексация зп");
        indexSalary(15,employee);
        System.out.println("ЗП персонал после индексации:");
        for (int i = 0; i < employee.length; i++){
            System.out.println(soutMan(employee[i]));
        }
        int dep = 3;
        int index = 16;
        int param = 34000;
        System.out.println("Действия с персоналом по номеру отдела");
        System.out.println(minSalaryDepartment(dep,employee));
        System.out.println(maxSalaryDepartment(dep,employee));
        System.out.println("Сумма затрат на зп в отделе " + dep + " равна " + sumSalaryDepartment(dep, employee));
        System.out.println("Средняя ЗП на " + dep +  " отдел " + middleSalaryDepartment(dep,employee));
        indexSalaryDepartment(dep, index, employee);
        printDepartment(dep,employee);
        System.out.println("\n");
        differringSalary(param, employee);
    }

    //2 УРОВЕНЬ

    //сравнение всех ЗП с параметром
    public static void differringSalary(int param, Employee[] employees){
        System.out.println("Меньше параметра = " + param + ":");
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getSalary() < param){
                System.out.println("id: " + employees[i].getId() + " " + employees[i].getFio().getLastName() + " " +
                        employees[i].getFio().getFirstName() + " " +
                        employees[i].getFio().getMiddleName() + " ЗП: " + employees[i].getSalary());
            }
        }
        System.out.println("\n");
        System.out.println("Больше или равно параметру = " + param + ":");
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getSalary() >= param){
                System.out.println("id: " + employees[i].getId() + " " + employees[i].getFio().getLastName() + " " +
                        employees[i].getFio().getFirstName() + " " +
                        employees[i].getFio().getMiddleName() + " ЗП: " + employees[i].getSalary());
            }
        }
    }

    //Печать всех сотрудников
    public static void printDepartment(int department, Employee[] employees){
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getDepartment() == department){
                System.out.println("id: " + employees[i].getId() + " " + employees[i].getFio().getLastName() + " " +
                        employees[i].getFio().getFirstName() + " " +
                        employees[i].getFio().getMiddleName() + " ЗП: " + employees[i].getSalary());
            }
        }

    }

    //индексация ЗП в отделе
    public static void indexSalaryDepartment(int department, int index, Employee[] employees){
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getDepartment() == department) {
                if (index > -100 && index < 100) {
                    employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() * index / 100);
                }else{
                    throw new IllegalArgumentException("Недопустимое значение!");
                }
            }
        }
    }

    //средняя ЗП на отдел
    public static float middleSalaryDepartment(int department, Employee[] employees){
        int quantity = 0;
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getDepartment() == department){
                quantity++;
            }
        }
        return sumSalaryDepartment(department, employees) / quantity;
    }

    //Сумма затрат на ЗП по отделу
    public static int sumSalaryDepartment(int department, Employee[] employees){
        int sum = 0;
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getDepartment() == department){
                sum+=employees[i].getSalary();
            }
        }
        return sum;
    }

    //Максимальная ЗП в отделе
    public static String maxSalaryDepartment(int department, Employee[] employees){
        int max = -1000000;
        Employee dudeee = new Employee(new Fio("" , "", ""), 0,0);
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getDepartment() == department && employees[i].getSalary() > max){
                max = employees[i].getSalary();
                dudeee = employees[i];
            }
        }
        return "В отделе " + dudeee.getDepartment()+ " самая большая зп у " + dudeee.getFio().getLastName() + " " + dudeee.getFio().getFirstName() + " " +
                dudeee.getFio().getMiddleName() + " размером в " + max + " руб." ;
    }

    //Минимальная ЗП в отделе
    public static String minSalaryDepartment(int department, Employee[] employees){
        int min = 1000000;
        Employee dudeee = new Employee(new Fio("" , "", ""), 0,0);
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
    public static void indexSalary(int percent, Employee[] dude){
        for (int i = 0; i < dude.length; i++){
            if (percent >= -100 && percent <= 100){
                dude[i].setSalary(dude[i].getSalary() + dude[i].getSalary() * percent/100);
            } else{
                throw new IllegalArgumentException("Недопустимое значение индекса!");
            }
        }
    }
/////////////////////////////////

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