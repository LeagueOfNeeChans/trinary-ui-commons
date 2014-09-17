package com.trinary.ui.commons;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Range {
	protected static Pattern numberRegex = Pattern.compile("[0-9]+");
	protected static Pattern rangeRegex  = Pattern.compile("([0-9]+)-([0-9]+)");
	
	protected ArrayList<Integer> ranges = new ArrayList<Integer>();
	
	public Range(String range) {
		String[] elements = range.split(",");
		
		for (int i = 0; i < elements.length; i++) {
			String element = elements[i].trim();
			
			if (rangeRegex.matcher(element).matches()) {
				Matcher match = rangeRegex.matcher(element);
				if (match.matches()) {
					this.ranges.addAll(getRange(match.group(1), match.group(2)));
				}
			} else if (numberRegex.matcher(element).matches()) {
				this.ranges.add(Integer.parseInt(element));
			}
		}
	}
	
	protected static ArrayList<Integer> getRange(String from, String to) {
		Integer fromIndex = Integer.parseInt(from);
		Integer toIndex = Integer.parseInt(to);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for (int i = fromIndex; i <= toIndex; i++) {
			numbers.add(i);
		}
		
		return numbers;
	}
	
	public String toString() {
		return ranges.toString();
	}
}
