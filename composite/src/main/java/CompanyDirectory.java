import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDirectory implements Employee {
    private List<Employee> employees = new ArrayList<>();

    @Override
    public void showEmployeeDetails() {
        employees.forEach(Employee::showEmployeeDetails);
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void removeEmployee(Employee emp) {
        employees.remove(emp);
    }
}
