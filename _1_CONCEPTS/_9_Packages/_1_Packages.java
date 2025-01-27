import employees.*;

public class _1_Packages {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Developer developer = new Developer();
        Tester tester = new Tester();
        HR hr = new HR();
        Intern intern = new Intern();


        manager.displayRole();
        developer.displayRole();
        tester.displayRole();
        hr.displayRole();
        intern.displayRole();
    }
}
