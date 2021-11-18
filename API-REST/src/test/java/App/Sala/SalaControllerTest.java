package App.Sala;


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
public class SalaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testSaladById() throws Exception {
        String expectedResponse = "{\"codigo\":\"exor7869samo\",\"nombre\":\"Sala Nemo\",\"tipo\":\"Exterior\"}";
        String responseString = mvc.perform(get("/salas/exor7869samo"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals(expectedResponse, responseString, "Response does not match");
    }

    @Test
    public void testSalaFindAll() throws Exception {
        mvc.perform(get("/salas"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

}