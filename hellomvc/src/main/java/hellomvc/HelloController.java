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
	
	@RequestMapping(value="hi", method=RequestMethod.GET)
	public String sayHello() {
		return "hello";
	}

}
