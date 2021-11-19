package App.Cliente;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testClientedById() throws Exception {
        String expectedResponse = "{\"codigo\":\"323419092000\",\"nombre\":\"Lucas\",\"direccion\":\"Ourense\",\"telefono\":\"888888888\"}";
        String responseString = mvc.perform(get("/clientes/323419092000"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals(expectedResponse, responseString, "Response does not match");
    }

    @Test
    public void testClienteFindAll() throws Exception {
        mvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }
}
