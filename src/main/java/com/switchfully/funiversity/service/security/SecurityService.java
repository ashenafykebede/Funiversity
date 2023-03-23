package com.switchfully.funiversity.service.security;

import com.switchfully.funiversity.domain.Feature;
import com.switchfully.funiversity.domain.Professor;
import com.switchfully.funiversity.domain.ProfessorRepository;
import com.switchfully.funiversity.webapi.exceptions.AccessLevelException;
import com.switchfully.funiversity.webapi.exceptions.PasswordDoesntMatchException;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class SecurityService {
    private final ProfessorRepository profRepo;

    public SecurityService(ProfessorRepository profRepo) {
        this.profRepo = profRepo;
    }
    public void validateCredentials(String authorization, Feature feature) {
        Credential credential = decodeAuth(authorization);
        Professor professor = profRepo.getProfessorByEmail(credential.getEmail());
        if (!professor.isCorrectPassword(credential.getPassword())) {
            throw new PasswordDoesntMatchException("Password is not correct");
        }
//        login(credential);
        if (!professor.hasAccessTo(feature)){
            throw new AccessLevelException("You have no access to perform this operation !");
        }
    }
    private Credential decodeAuth(String authorization) {
        String decodedCredential = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedCredential.substring(0,decodedCredential.indexOf("-"));
        String password = decodedCredential.substring(decodedCredential.indexOf("-")+1);

        return new Credential(username,password);
    }
}

