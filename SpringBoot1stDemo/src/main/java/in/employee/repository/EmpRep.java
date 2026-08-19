package in.employee.repository;

import in.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpRep extends JpaRepository<Employee , Integer> {

    Optional<Employee> findByIdAndDeletedFalse(Integer id);

    List<Employee> findByDeletedFalse();

    boolean existsByEmail(String email);
    
   Optional<Employee> findByIdAndDeletedTrue(Integer id);
}
