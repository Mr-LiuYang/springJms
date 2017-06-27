package springJmsReceive.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springJmsReceive.entity.Message;
import springJmsReceive.service.MessageService;

@RestController
@RequestMapping("home")
public class HomeController {

	@Autowired
	private MessageService messageService;

	@RequestMapping("send")
	public String send(){
		long time1=System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
		messageService.send(new Message("李四","考试不及格"));
		}
		System.out.println(System.currentTimeMillis()-time1);
		return String.valueOf(System.currentTimeMillis()-time1);
	}

}
