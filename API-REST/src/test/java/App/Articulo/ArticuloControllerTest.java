package App.Articulo;


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
public class ArticuloControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void testArticuloById_equalResponse() throws Exception {
        String expectedResponse = "{" +
                "\"codigo\":\"6567acfo7182\"," +
                "\"descripcion\":\"Acondicionador para agua del grifo\"," +
                "\"stock\":9,"+
                "\"precio\":3.49," +
                "\"tipo_articulo\":4" +
                "}";
        String responseString = mvc.perform(AppTest.testRequest("/articulos/6567acfo7182"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals(expectedResponse, responseString, "Response does not match");
    }

    @Test
    public void testArticuloAll_responseOk() throws Exception {
        mvc.perform(AppTest.testRequest("/articulos"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

    @Test
    public void testArticuloAll_responseForbidden() throws Exception {
        mvc.perform(get("/articulos"))
                .andExpect(status().isForbidden());
    }
}