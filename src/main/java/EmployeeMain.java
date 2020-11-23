import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.Employee.Config.DBConfig;
import com.tcs.Employee.Model.Department;
import com.tcs.Employee.Model.Employee;
import com.tcs.Repository.DepartmentRepository;
import com.tcs.Repository.EmployeeRepository;

public class EmployeeMain {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		
		
		DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		
		Department department = new Department(1,1, "Computer Science",null);
		departmentRepository.save(department);
		
		employeeRepository.save(new Employee (1,1,1, "Joan White", 22, "Trainer", department));
		employeeRepository.save(new Employee (2,2,2, "betty Boo", 29, "Trainee", department));
		employeeRepository.save(new Employee (2,2,2, "Jane Doe", 22, "Trainer", department));
		employeeRepository.save(new Employee (2,2,2, "Paul White", 22, "Trainer", department));
		
		
		
		
		
	
		context.close();
	}
	
	
	
}
