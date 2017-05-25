package com.ei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ei.dao.*;

@Service
public class SentenceServiceImpl implements SentenceService {

	AdjectiveClient adjectiveService;

	public String buildSentence() {
		String sentence = "There was a problem assembling the sentence!";
		sentence = String.format("%s", 
				adjectiveService.getWord().getString());
		return sentence;
	}

	@Autowired
	public void setAdjectiveService(AdjectiveClient adjectiveService) {
		this.adjectiveService = adjectiveService;
	}

}
