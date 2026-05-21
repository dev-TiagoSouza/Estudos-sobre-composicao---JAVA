package entities;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import entities_enums.WorkerLevel;

public class Worker {

	private String Name;
	private WorkerLevel Level;
	private Double BaseSalary;
	
	private Department Departament;
	private List<HourContract> Contracts = new ArrayList<>();
	
	public Worker() {}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department departament) {
		Name = name;
		Level = level;
		BaseSalary = baseSalary;
		Departament = departament;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public WorkerLevel getLevel() {
		return Level;
	}

	public void setLevel(WorkerLevel level) {
		Level = level;
	}

	public Double getBaseSalary() {
		return BaseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		BaseSalary = baseSalary;
	}

	public Department getDerpartament() {
		return Departament;
	}

	public void setDerpartament(Department derpartament) {
		Departament = derpartament;
	}

	public List<HourContract> getContracts() {
		return Contracts;
	}

	public void addContracts(HourContract Contract) {
		Contracts.add(Contract);
	}
	
	public void removeContracts(HourContract contract) {
		Contracts.remove(contract);
	}
	
	public double income(YearMonth AnoMes) {
		double soma = BaseSalary;
		for(HourContract contratoAtual : Contracts) {
			if(AnoMes.equals(YearMonth.from(contratoAtual.getDate()))) { //o metodo ".equals" faz a comparação, porque == não pode ser usado para String e Listas
							// o YearMonth.from(c.getDate())) ele faz a questão de um filtro, para só pegar o mes e o ano.
				soma += contratoAtual.totalValue();
			}
	}
		return soma;
	}
}
