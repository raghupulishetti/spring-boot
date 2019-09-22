package com.raghu.bean;

import org.springframework.stereotype.Component;

@Component("messageService")
public class MessageServiceImpl implements MessageService {

	public MessageServiceImpl() {
		System.out.println("Consteructor executed.");
	}

	@Override
	public void sendMessage(String email) {
		System.out.println("************** Sending email to ====>" + email);
	}

}
