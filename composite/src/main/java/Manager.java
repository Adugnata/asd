import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager implements Employee{
    private long empId;
    private String name;
    private String position;
    @Override
    public void showEmployeeDetails() {
        System.out.println(empId+" " +name);
    }
}
