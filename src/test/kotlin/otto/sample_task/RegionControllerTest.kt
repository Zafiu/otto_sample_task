package otto.sample_task

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get


@SpringBootTest
@AutoConfigureMockMvc
class RegionControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
) {

    @Test
    fun whenGetRequest_thenReturnsTextPlainWithStatus200() {
        mockMvc.get("/region?region=eu")
            .andExpect { status { isOk() } }
            .andExpect { content { contentType(MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8") } }
    }
}