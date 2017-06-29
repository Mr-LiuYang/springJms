package springJmsReceive.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springJmsReceive.entity.Message;
import springJmsReceive.service.MessageService;

@RestController
@RequestMapping("home")
public class HomeController {

	@Autowired
	private MessageService messageService;
	@Autowired
	private ThreadHandler threadHandler;

	@RequestMapping("send")
	public void send(){
		messageService.send(new Message("李四","考试不及格"));
		}

	@RequestMapping("thread")
	public void thread(){
		for (int i = 0; i < 10; i++) {
			threadHandler.sout(i);
			threadHandler.sout1(i);
		}
	}
}
