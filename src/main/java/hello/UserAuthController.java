package hello;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/userauth")
    @ResponseBody
    public String sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
		return name;
        //return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    //@RequestMapping(value = "processing", method = RequestMethod.GET)
     
    @GetMapping("/user")
    @ResponseBody
    public  String processData
    (@RequestParam("name") final String name,
        @RequestParam("pass") final String pass, HttpServletRequest request) {

    	String s = "name: " + name + " \n pass: " + pass + "\n remote Address: " + request.getRemoteAddr();
    	
    	s += "\n localAddr= " + request.getLocalAddr();
    	
    	System.out.println(s) ;
    	return s;
            // some other code
        }
     

}
