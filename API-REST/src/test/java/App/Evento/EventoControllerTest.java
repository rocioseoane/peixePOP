package App.Evento;

import App.AppTest;
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
public class EventoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testEventoById_equalResponse() throws Exception {
        String expectedString = "{" +
                    "\"codigo\":\"co6779to8479\"," +
                    "\"nombre\":\"conceirto\"," +
                    "\"fecha\":\"2032-02-10\"," +
                    "\"precio\":7.5," +
                    "\"duracion\":1," +
                    "\"requisito_edad\":21," +
                    "\"aforo\":400" +
                "}";
        String responseString = mvc.perform(AppTest.testRequest("/eventos/co6779to8479"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Assertions.assertEquals(expectedString, responseString, "Response does not match");
    }

    @Test
    public void testEventoAll_resposeOk() throws Exception {
        mvc.perform(AppTest.testRequest("/eventos"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

    @Test
    public void testEventoAll_isForbidden() throws Exception {
        mvc.perform(get("/eventos"))
                .andExpect(status().isForbidden());
    }
}
