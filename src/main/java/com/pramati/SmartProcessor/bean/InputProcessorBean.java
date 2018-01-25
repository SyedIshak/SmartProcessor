package com.pramati.SmartProcessor.bean;

import java.util.LinkedHashMap;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.pramati.SmartProcessor.model.MessageModel;


@Component("inputProcessorBean")
public class InputProcessorBean {

	private Logger log = LoggerFactory.getLogger(InputProcessorBean.class);

    /**
     * This method processes incoming messages and return responses.
     *
     * @param message a message coming from a human user in a chat
     * @return the reply of the bot.
     * @throws Exception if the input is null.
     */
    public MessageModel process(Exchange e) throws Exception {
	String message = (String) e.getIn().getBody(LinkedHashMap.class).get("message");
	MessageModel msgModel = new MessageModel();
        if (message == null || StringUtils.isEmpty(message)) {
            msgModel.setMessage("Please send some message");
            return msgModel;
        }
        log.info("Received message: {}", message);
        return msgModel;
    }
}
