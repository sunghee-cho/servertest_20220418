package edu.multi.boot1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
@RequestMapping("/helloboot")
public ModelAndView hello() {
	ModelAndView mv= new ModelAndView();
	mv.addObject("model", "헬로우부트프로젝트");
	mv.setViewName("hello");
	return mv;
}
	
}
