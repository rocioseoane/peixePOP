package App.Estanque;

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
public class EstanqueControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testEstanqueById_equalResponse() throws Exception {
        String expectedResponse = "{" +
                "\"codigo\":\"esel6578exno\"," +
                "\"tipo\":\"Externo\"," +
                "\"nombre\":\"Estanque de Angel\"," +
                "\"codigo_sala\":\"exor7869samo\"" +
                "}";
        String responseString = mvc.perform(AppTest.testRequest("/estanques/esel6578exno"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals(expectedResponse, responseString, "Response does not match");
    }

    @Test
    public void testEstanqueAll_responseOk() throws Exception {
        mvc.perform(AppTest.testRequest("/estanques"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

    @Test
    public void testEstanqueAll_responseForbidden() throws Exception {
        mvc.perform(get("/estanques"))
                .andExpect(status().isForbidden());
    }
}
