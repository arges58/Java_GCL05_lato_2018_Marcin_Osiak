import com.lab10.Controller.PictureController;
import com.lab10.Entity.Picture;
import com.lab10.Main;
import com.lab10.Service.PictureService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class PictureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PictureService pictureService;

   // Picture picture = new Picture(1, "garniak.jpg", "1200x1600", 456710, "2018-05-14T18:56:04.673237Z");
   // Picture picture2 = new Picture(2, "janush.jpg", "1920x1080", 343033, "2018-05-14T18:54:18.718816Z");

    @Test
    public void testGet() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/gallery/pictures").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{1:{index:1,name:garniak.jpg,resolution:1200x1600,size:456710,created:2018-05-14T18:56:04.673237Z}," +
                           "2:{index:2,name:janush.jpg,resolution:1920x1080,size:343033,created:2018-05-14T18:54:18.718816Z}}";
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }
}
