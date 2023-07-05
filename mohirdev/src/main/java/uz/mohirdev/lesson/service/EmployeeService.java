package uz.mohirdev.lesson.service;

import org.springframework.stereotype.Service;
import uz.mohirdev.lesson.entity.Employee;
import uz.mohirdev.lesson.repository.EmployeeRepository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository){

        this.employeeRepository = employeeRepository;
    }
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee findById(Long id){
        //Employee employee = employeeRepository.findById(id).get();
        //return employee;
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    public List<Employee> findAll(String name, String lastName){
        //List<Employee> employees = employeeRepository.findAllByNameAndLastName(name, lastName);
        List<Employee> employees = employeeRepository.findAll(name);
        return employees;
    }

    public List<Employee> findByQueryParam(String name){

        return employeeRepository.findAllByNameLikeJPQL(name);
    }
    public void delete(Long id){

        employeeRepository.deleteById(id);
    }
}
