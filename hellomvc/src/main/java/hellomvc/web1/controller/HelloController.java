/**
 * 
 */
package hellomvc.web1.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hellomvc.root.service.ProfileService;
import hellomvc.web1.service.PersonService;

/**
 * @author chopa
 *
 */
@Controller
public class HelloController {
	
	@Autowired
	private PersonService service = null;
	
	@Autowired
	private ProfileService profile = null;
	
	
	@RequestMapping(value="hi", method=RequestMethod.GET)
	public String hi(HttpServletRequest request) {
		String person = service.getPerson();
		String profileName = profile.getProfileName();
		request.setAttribute("to", person);
		request.setAttribute("profile", profileName);
		return "hello";
	}
	
	
	@RequestMapping(value="hiAll", method=RequestMethod.GET)
	public String hiAll(HttpServletRequest request) {
		request.setAttribute("to", "All");
		return "hello";
	}

}
