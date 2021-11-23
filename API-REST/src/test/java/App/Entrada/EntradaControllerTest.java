package App.Entrada;

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
public class EntradaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testEntradaById_equalResponse() throws Exception {
        String expectedString = "{" +
                    "\"codigo\":\"51\"," +
                    "\"edad\":43," +
                    "\"precio\":15.0," +
                    "\"tipo\":2," +
                    "\"codigo_evento\":null," +
                    "\"fecha\":\"2021-11-08\"," +
                    "\"codigo_cliente\":\"323419092000\"" +
                "}";
        String responseString = mvc.perform(AppTest.testRequest("/entradas/51"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals(expectedString, responseString, "Response does not match");
    }

    @Test
    public void testEntradaAll_responseOk() throws Exception {
        mvc.perform(AppTest.testRequest("/entradas"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

    @Test
    public void testEntradaAll_responseForbidden() throws Exception {
        mvc.perform(get("/entradas"))
                .andExpect(status().isForbidden());
    }
}
