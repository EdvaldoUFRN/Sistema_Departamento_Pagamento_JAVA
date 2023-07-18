import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class Worker {
    
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }
    
    public Double getBaseSalary() {
        return baseSalary;
    }
    public List<HourContract> getContracts() {
        return contracts;
    }
    public Department getDepartment() {
        return department;
    }
    public WorkerLevel getLevel() {
        return level;
    }
    public String getName() {
        return name;
    }
    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setLevel(WorkerLevel level) {
        this.level = level;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public Double income(int year, int month) {
        Double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts) {
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if (year == c_year && month == c_month) {
                sum += c.totalValue();
            }
        }
        return sum;
    } 


}
