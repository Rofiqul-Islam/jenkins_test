package sarjan.jpa.dataModel.model;

/**
 * @author Sarjan Kabir
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



public class Example2Test extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

//    @Test
//    public void getProductsList() throws Exception {
//        String uri = "/products";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        Product[] productlist = super.mapFromJson(content, Product[].class);
//        assertTrue(productlist.length > 0);
//    }

    /**
     * Creates a successful applicant
     * @throws Exception
     */
    @Test
    public void createApp() throws Exception {
        String uri = "/apps/apply/";
        App app1 = new App();
        app1.setName("Sarjan");
        app1.setGender("Female");
        app1.setPassword("1234567899");
        app1.setEmail("sarjan_kabir1@baylor.edu");
        app1.setAge(40);
        app1.setStatus(App.Status.PENDING);

        String inputJson = super.mapToJson(app1);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }
    /**
     * Creates an  applicant of age >57
     * @throws Exception
     */
    @Test
    public void createUnsuccessfulApp() throws Exception {
        String uri = "/apps/apply/";
        App app1 = new App();
        app1.setName("John");
        app1.setGender("Male");
        app1.setPassword("1234567899");
        app1.setEmail("sarjan_kabir1@baylor.edu");
        app1.setAge(80);
        app1.setStatus(App.Status.PENDING);

        String inputJson = super.mapToJson(app1);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }
    /**
     * Creates a female app with note
     * @throws Exception
     */
    @Test
    public void createFemaleApp() throws Exception {
        String uri = "/apps/apply/";
        App app1 = new App();
        app1.setName("Sarah");
        app1.setGender("Female");
        app1.setPassword("22232222121");
        app1.setEmail("sarjan_kabir1@baylor.edu");
        app1.setAge(70);
        app1.setStatus(App.Status.PENDING);

        String inputJson = super.mapToJson(app1);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

}