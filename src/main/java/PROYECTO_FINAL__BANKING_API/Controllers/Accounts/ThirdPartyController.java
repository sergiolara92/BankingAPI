package PROYECTO_FINAL__BANKING_API.Controllers.Accounts;

import PROYECTO_FINAL__BANKING_API.DTO.ThirdPartyDTO;
import PROYECTO_FINAL__BANKING_API.Models.Users.ThirdParty;
import PROYECTO_FINAL__BANKING_API.Services.User.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ThirdPartyController {

    @Autowired
    ThirdPartyService thirdPartyService;


    @PostMapping("/create-third-party")  // solo admin -- OK
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty createThirdParty(@RequestBody ThirdPartyDTO thirdPartyDTO) {
        return thirdPartyService.createThirdParty(thirdPartyDTO);
    }


}
