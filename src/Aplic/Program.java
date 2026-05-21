package Aplic;


import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;


import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities_enums.WorkerLevel;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formMonthAndYear = DateTimeFormatter.ofPattern("MM/yyyy");
		
		System.out.print("Enter Department name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level:");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("How many contract to this worker: ");
		int numberContract = sc.nextInt();
		
		
		for(int i = 1; i <= numberContract; i++) {
			sc.nextLine();
			System.out.println("Enter contract #"+ i);
			System.out.print("Date (DD/MM/YYYY): ");
			String dateDigitada = sc.nextLine();
			LocalDate date = LocalDate.parse(dateDigitada, formDate);
			System.out.print("Value per hour: ");
			Double perHour = sc.nextDouble();
			System.out.print("Duration (hours) : ");
			Integer hours = sc.nextInt();
			
			HourContract workerContracts = new HourContract(date, perHour, hours);
			worker.addContracts(workerContracts);
		}
		sc.nextLine();
		System.out.print("Enter month  and year to calculate income (MM/YYYY): ");
		YearMonth dateCalculate = YearMonth.parse(sc.nextLine(), formMonthAndYear);
		
		
		System.out.print("Name: "+ worker.getName());
		System.out.print("\nDepartment: "+ worker.getDerpartament());
		System.out.printf("\nIncome For %s : %.2f",dateCalculate.format(formMonthAndYear), worker.income(dateCalculate));
		
		sc.close();

	}

}
