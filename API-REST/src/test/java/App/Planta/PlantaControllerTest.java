package App.Planta;

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
public class PlantaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testPlantaById_equalResponse() throws Exception {
        String expectedResponse = "{" +
                "\"codigo\":\"6589ayca6567\"," +
                "\"medio_de_vida\":\"Acuatico\"," +
                "\"nombre\":\"Ayahuasca\"," +
                "\"codigo_estanque\":\"esel7765inno\"," +
                "\"codigo_sala\":null" +
                "}";
        String responseString = mvc.perform(AppTest.testRequest("/plantas/6589ayca6567"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals(expectedResponse, responseString, "Response does not match");
    }

    @Test
    public void testPlantaAll_responseOk() throws Exception {
        mvc.perform(AppTest.testRequest("/plantas"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

    @Test
    public void testPlantaAll_responseForbidden() throws Exception {
        mvc.perform(get("/plantas"))
                .andExpect(status().isForbidden());
    }
}
