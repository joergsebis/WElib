package de.tum.in.wwwmatthes.stm.preprocessing;

import java.util.List;

public class StopWords {
	
	public static List<String> getStopWords() {
		List<String> list = org.deeplearning4j.text.stopwords.StopWords.getStopWords();
		list.add("shall");
		//list.add("s");
		//list.add("c");
		//list.add("may");
		//list.add("can");
		return list;
	}

}
