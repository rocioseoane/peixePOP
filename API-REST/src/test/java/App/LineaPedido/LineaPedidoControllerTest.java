package App.LineaPedido;

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
public class LineaPedidoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testLineaPedidodById() throws Exception {
        String expectedResponse = "{\"codigo\":\"1\",\"codigo_articulo\":\"6765caon6869\",\"cantidad\":3,\"precio\":100.4,\"codigo_pedido\":2}";
        String responseString = mvc.perform(get("/lineas_pedidos/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals(expectedResponse, responseString, "Response does not match");
    }

    @Test
    public void testLineaPedidoFindAll() throws Exception {
        mvc.perform(get("/lineas_pedidos"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }
}
