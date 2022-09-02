package PROYECTO_FINAL__BANKING_API.Services.User;

import PROYECTO_FINAL__BANKING_API.DTO.ThirdPartyDTO;
import PROYECTO_FINAL__BANKING_API.Models.Users.Role;
import PROYECTO_FINAL__BANKING_API.Models.Users.ThirdParty;
import PROYECTO_FINAL__BANKING_API.Models.Users.User;
import PROYECTO_FINAL__BANKING_API.Repositories.Users.RoleRepository;
import PROYECTO_FINAL__BANKING_API.Repositories.Users.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyService {

    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    @Autowired
    RoleRepository roleRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();




    public ThirdParty createThirdParty(ThirdPartyDTO thirdPartyDTO) {
        ThirdParty newThirdParty = new ThirdParty(thirdPartyDTO.getUsername(), passwordEncoder.encode(thirdPartyDTO.getPassword()), thirdPartyDTO.getName(), thirdPartyDTO.getHashedKey());
        thirdPartyRepository.save(newThirdParty);
        Role role = new Role("THIRD PARTY", newThirdParty);
        roleRepository.save(role);
        return newThirdParty;
    }
}
