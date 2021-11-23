package App.LineaFactura;

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
public class LineaFacturaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testLineaFacturaById_equalResponse() throws Exception {
        String expectedResponse = "{" +
                "\"codigo\":\"1\"," +
                "\"cantidad\":2," +
                "\"descripcion\":\"GoldFish\"," +
                "\"precio\":5.0," +
                "\"codigo_factura\":1" +
                "}";
        String responseString = mvc.perform(AppTest.testRequest("/lineas_facturas/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals(expectedResponse, responseString, "Response does not match");
    }

    @Test
    public void testLineaFacturaAll_responseOk() throws Exception {
        mvc.perform(AppTest.testRequest("/lineas_facturas"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

    @Test
    public void testLineaFacturaAll_responseForbidden() throws Exception {
        mvc.perform(get("/lineas_facturas"))
                .andExpect(status().isForbidden());
    }
}
