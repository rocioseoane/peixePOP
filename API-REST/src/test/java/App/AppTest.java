package App;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AppTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    // Test para comprobar que el root path de la API responde adecuadamente.
    @Test
    public void rootPathResponse() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api",
                String.class)).contains("API Running - PeixePOP");
    }

    // Configurar el X-API-KEY para las tests
    public static MockHttpServletRequestBuilder testRequest(String url) {
        return MockMvcRequestBuilders.get(url)
                .header("X-API-KEY", "TgGJrf2EdN1y4VrM79fzZoYP5Q1C89sM");
    }

}