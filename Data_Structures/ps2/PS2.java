/********************************
Name: Solomon Lisk
Username: ua110
Problem Set: PS2
Due Date: Sept 10, 2018
********************************/

public class PS2 {
	public static void run() {
		UAEmployee u1 = new UAEmployee(" Andrew ", " Mackey ", 123, "CS");
		UASalaryEmployee u2 = new UASalaryEmployee("Andrew ,Mackey ,456 , MATH,50000");
		UACommissionEmployee u3 = new UACommissionEmployee(" Andrew ", " Mackey", 123, "CS");
		u3.setCommissionRate((float) 1.25);
		u3.setGrossSales(55000);

		UAHourlyEmployee u4 = new UAHourlyEmployee();

		u4.setWage((float) 20.50);
		u4.setNumHoursWorked(20);

		UABaseWithCommissionEmployee u5 = new UABaseWithCommissionEmployee();
		u5.setFirstName(" Andrew ");
		u5.setLastName(" Mackey ");
		u5.setCommissionRate((float) 1.25);
		u5.setGrossSales(155000);
		u5.setDepartment("CS");
		u5.setBaseSalary(123000);

		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);
		System.out.println(u4);
		System.out.println(u5);

		System.out.println();

		UAEmployee u6 = u2;
		UAEmployee u7 = u3;
		UAEmployee u8 = u4;
		UAEmployee u9 = u5;

		System.out.println(u6);
		System.out.println(u7);
		System.out.println(u8);
		System.out.println(u9);
	}

}
