package entities;

import java.time.LocalDate;

public class HourContract {
	
	private LocalDate Date;
	private Double PerHour;
	private Integer Hours;
	
	
	public HourContract(LocalDate date, Double perHour, Integer hours) {
		Date = date;
		PerHour = perHour;
		Hours = hours;
	}

	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		Date = date;
	}
	public Double getPerHour() {
		return PerHour;
	}
	public void setPerHour(Double perHour) {
		PerHour = perHour;
	}
	public Integer getHours() {
		return Hours;
	}
	public void setHours(Integer hours) {
		Hours = hours;
	}
	public Double totalValue() {
		return PerHour * Hours;
	}
}
