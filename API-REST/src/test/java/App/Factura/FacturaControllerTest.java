package App.Factura;

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

    @Test
    public void testFacturadById() throws Exception {
        String expectedResponse = "{\"codigo\":\"1\",\"codigo_cliente\":\"874306062006\",\"fecha\":\"2020-05-08T14:09:39.000+00:00\",\"importe_total\":207.75,\"pagada\":1}";
        String responseString = mvc.perform(get("/facturas/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals(expectedResponse, responseString, "Response does not match");
    }

    @Test
    public void testFacturaFindAll() throws Exception {
        mvc.perform(get("/facturas"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }
}
