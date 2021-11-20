package App.Pedido;

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
public class PedidoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testPedidodById() throws Exception {
        String expectedResponse = "{" +
                    "\"codigo\":\"1\"," +
                    "\"fecha\":\"12:05:50\"," +
                    "\"recibido\":1" +
                "}";
        String responseString = mvc.perform(get("/pedidos/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals(expectedResponse, responseString, "Response does not match");
    }

    @Test
    public void testPedidoFindAll() throws Exception {
        mvc.perform(get("/pedidos"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }
}
