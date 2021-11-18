package App.Tiburon;

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
public class TiburonControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testTiburondById() throws Exception {
        String expectedResponse = "{\"codigo\":\"baro6665time\",\"nombre\":\"TiburÃ³n Basurero\",\"tamano\":\"Mediano\",\"codigo_estanque\":\"esna7765inno\"}";
        String responseString = mvc.perform(get("/tiburones/baro6665time"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals(expectedResponse, responseString, "Response does not match");
    }

    @Test
    public void testTiburonFindAll() throws Exception {
        mvc.perform(get("/tiburones"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }
}
