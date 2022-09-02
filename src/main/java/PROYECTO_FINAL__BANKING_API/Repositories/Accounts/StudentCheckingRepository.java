package PROYECTO_FINAL__BANKING_API.Repositories.Accounts;

import PROYECTO_FINAL__BANKING_API.Models.Accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Long> {


}
