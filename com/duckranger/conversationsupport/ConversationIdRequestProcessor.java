package com.duckranger.conversationsupport;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.support.RequestDataValueProcessor;

/**
 * This processor is used to add the conversation id as a hidden field on the
 * form If the conversation id exists on the request.
 * 
 * @author nimo
 * 
 */
public class ConversationIdRequestProcessor implements RequestDataValueProcessor {

    @Override
    public String processAction(HttpServletRequest request, String action) {
	return action;
    }

    @Override
    public String processFormFieldValue(HttpServletRequest request, String name, String value, String type) {
	return value;
    }

    @Override
    public Map<String, String> getExtraHiddenFields(HttpServletRequest request) {
	Map<String, String> hiddenFields = new HashMap<String, String>();
	if (request.getAttribute(ConversationalSessionAttributeStore.CID_FIELD) != null) {
	    hiddenFields.put(ConversationalSessionAttributeStore.CID_FIELD,
		    request.getAttribute(ConversationalSessionAttributeStore.CID_FIELD).toString());
	}
	return hiddenFields;
    }

    @Override
    public String processUrl(HttpServletRequest request, String url) {
	return url;
    }

}
