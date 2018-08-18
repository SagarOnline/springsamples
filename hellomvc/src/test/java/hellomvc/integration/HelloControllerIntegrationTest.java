package hellomvc.integration;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import hellomvc.root.RootConfig;
import hellomvc.web1.WebMvcConfig;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextHierarchy({
	@ContextConfiguration(classes= {RootConfig.class}),
	@ContextConfiguration(classes= {WebMvcConfig.class})
})
public class HelloControllerIntegrationTest {
	
	@Autowired
	private WebApplicationContext wac = null;
	
	private MockMvc mockMvc = null;
	
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testHelloController() {
		try {
			mockMvc.perform(get("/hi")).andExpect(view().name("hello"))
			.andExpect(request().attribute("to", "Sagar"));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Fialed to execute Integrated Test");
		}
		
	}

}
