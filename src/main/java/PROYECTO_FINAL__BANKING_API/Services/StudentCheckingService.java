package PROYECTO_FINAL__BANKING_API.Services;

import PROYECTO_FINAL__BANKING_API.Models.Accounts.StudentChecking;
import PROYECTO_FINAL__BANKING_API.Repositories.Accounts.StudentCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class StudentCheckingService {


    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    public List<StudentChecking> allStudentAccounts() {
        return studentCheckingRepository.findAll();
    }


}
