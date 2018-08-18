package hellomvc.unit;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ViewResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import hellomvc.controller.HelloController;

public class HelloControllerStandaloneTest{
	
	@Test
	public void testHello() {
		HelloController controller = new HelloController();
		MockMvc mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hiAll");
		ViewResultMatchers view = MockMvcResultMatchers.view();
		try {
			mockmvc.perform(requestBuilder).andExpect(view.name("hello"))
			.andExpect(request().attribute("to", "All"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error");
		}
	}

}
