package App.Factura;

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
public class FacturaControllerTest {

    @Autowired
    private MockMvc mvc;

    // !TODO Arreglar test factura (date sql variable)
   /* @Test
    public void testFacturaById_equalResponse() throws Exception {
        String expectedResponse = "{" +
                    "\"codigo\":\"1\"," +
                    "\"codigo_cliente\":\"874306062006\"," +
                    "\"fecha\":\"2020-05-08T14:09:39.000+00:00\"," +
                    "\"importe_total\":207.75," +
                    "\"pagada\":1" +
                "}";
        String responseString = mvc.perform(AppTest.testRequest("/facturas/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals(expectedResponse, responseString, "Response does not match");
    } */

    @Test
    public void testFacturaAll_responseOk() throws Exception {
        mvc.perform(AppTest.testRequest("/facturas"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

    @Test
    public void testFacturaAll_responseForbidden() throws Exception {
        mvc.perform(get("/facturas"))
                .andExpect(status().isForbidden());
    }
}
