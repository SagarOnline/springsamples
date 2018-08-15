/**
 * 
 */
package hellomvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chopa
 *
 */
@Controller
public class HelloController {
	
	@RequestMapping(value="hello", method=RequestMethod.GET)
	public String sayHello() {
		return "hello";
	}

}
