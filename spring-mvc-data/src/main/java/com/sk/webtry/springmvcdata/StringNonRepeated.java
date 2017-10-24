package com.sk.webtry.springmvcdata;

import java.util.HashMap;
import java.util.Map;

public class StringNonRepeated {

	public static void main(String[] args) {
		Map<Character, Integer> test = new HashMap<Character, Integer>();
		String str = "asdasdma asdfsdgfsd sdfgdfogerg";
		Integer count = 0;
		char[] chararr = str.toCharArray();
		for (int i = 0; i < chararr.length; i++) {
			if (chararr[i] != ' ') {
				count = test.get(chararr[i]);
				if (count == null) {
					count = 0;
				}
				count++;
				test.put(chararr[i], count);
			}
		}
		char nonRepeatedChar = 0;
		for (char c : chararr) {
			if (test.get(c) != null && test.get(c) == 1) {
				nonRepeatedChar = c;
				break;
			}
		}
		System.out.println("First non repeated char is " + nonRepeatedChar);
	}
}
