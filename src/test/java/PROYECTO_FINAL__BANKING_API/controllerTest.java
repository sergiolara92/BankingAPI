package PROYECTO_FINAL__BANKING_API;

import PROYECTO_FINAL__BANKING_API.DTO.AccountDTO;
import PROYECTO_FINAL__BANKING_API.DTO.AccountHolderDTO;
import PROYECTO_FINAL__BANKING_API.LocalDate.LocalDateDeserializer;
import PROYECTO_FINAL__BANKING_API.LocalDate.LocalDateSerializer;
import PROYECTO_FINAL__BANKING_API.Models.Accounts.Account;
import PROYECTO_FINAL__BANKING_API.Models.Users.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class controllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    User user;
    Account account;

    GsonBuilder gsonBuilder = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
            .registerTypeAdapter(LocalDate.class, new LocalDateSerializer());

    Gson gson = gsonBuilder.setPrettyPrinting().create();

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        objectMapper.findAndRegisterModules();
    }

    @Test
    void createAccount_test() throws Exception {
        AccountDTO account = new AccountDTO(new BigDecimal("2000"), "secretkey", "checking");
        String body = gson.toJson(account);
        System.out.println(body);
        MvcResult mvcResult = mockMvc.perform(post("/create-account-one-holder?holderId=1")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("sergio11"));
    }

    @Test
    void createHolder_test() throws Exception {
        AccountHolderDTO accountHolderDTO = new AccountHolderDTO("test88", "password", "Testeo", LocalDate.of(2000, 3, 29), "calle", 8, 8015, "Barcelona", "Espania", "calle correo", 88, 8025, "ciudad correo", "pais correo");
        String body = gson.toJson(accountHolderDTO);
        System.out.println(body);
        MvcResult mvcResult = mockMvc.perform(post("/create-holder")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("test88"));
    }





}
