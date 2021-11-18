package App.Trabajador;

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
public class TrabajadorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testTrabajadordById() throws Exception {
        String expectedResponse = "{\"codigo\":\"432509081997\",\"nombre\":\"Herodes\",\"direccion\":\"Jerusalen\",\"telefono\":\"000000000\",\"salario\":1000.0}";
        String responseString = mvc.perform(get("/trabajadores/432509081997"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals(expectedResponse, responseString, "Response does not match");
    }

    @Test
    public void testTrabajadorFindAll() throws Exception {
        mvc.perform(get("/trabajadores"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }
}
