package com.ei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class SentenceController {

	@Autowired
	LoadBalancerClient client;

	@RequestMapping("/sentence")
	public @ResponseBody String getSentence() {
		// return String.format("%s %s %s %s %s.", getWord("LAB-4-SUBJECT"),
		// getWord("LAB-4-VERB"),
		// getWord("LAB-4-ARTICLE"), getWord("LAB-4-ADJECTIVE"),
		// getWord("LAB-4-NOUN"));
		return String.format("%s %s %s.", getWord("LAB-4-ARTICLE"), getWord("LAB-4-ADJECTIVE"), getWord("LAB-4-NOUN"));
	}

	public String getWord(String service) {
		ServiceInstance instance = client.choose(service);
		return (new RestTemplate()).getForObject(instance.getUri(), String.class);
	}

}
