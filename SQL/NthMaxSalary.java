package SQL;

public class NthMaxSalary {

    public static void main(String[] args) {
        System.out.println("select * from Emp e1 where n-1 = (select count(Distinct) from Emp e2 where e2.salary>e1.salary)");

    }
}
