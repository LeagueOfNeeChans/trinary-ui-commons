package com.trinary.ui.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Range {
	protected static Pattern numberRegex = Pattern.compile("[0-9]+");
	protected static Pattern rangeRegex  = Pattern.compile("([0-9]+)-([0-9]+)");
	protected static Pattern xyRegex  = Pattern.compile("([0-9]+)-*([0-9]+)*:([0-9]+)-*([0-9]+)*");
	
	protected ArrayList<Integer> ranges = new ArrayList<Integer>();
	
	protected Integer cols, rows;
	
	public Range(String range, Integer cols, Integer rows) {
		this.cols = cols;
		this.rows = rows;
		
		String[] elements = range.split(",");
		
		for (int i = 0; i < elements.length; i++) {
			String element = elements[i].trim();
			
			if (xyRegex.matcher(element).matches()) {
				Matcher match = xyRegex.matcher(element);
				if (match.matches()) {
					this.ranges.addAll(getXYRange(
							match.group(1), 
							match.group(2), 
							match.group(3), 
							match.group(4)));
				}
			} else if (rangeRegex.matcher(element).matches()) {
				Matcher match = rangeRegex.matcher(element);
				if (match.matches()) {
					this.ranges.addAll(getRange(
							match.group(1), 
							match.group(2)));
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
		
		if (fromIndex < toIndex) {
			for (int i = fromIndex; i <= toIndex; i++) {
				numbers.add(i);
			}
		} else {
			for (int i = toIndex; i >= fromIndex; i--) {
				numbers.add(i);
			}
		}
		
		return numbers;
	}
	
	protected ArrayList<Integer> getXYRange(String xFrom, String xTo, String yFrom, String yTo) {
		Integer xm = xFrom != null ? Integer.parseInt(xFrom) : null;
		Integer xn = xTo != null ? Integer.parseInt(xTo) : null;
		Integer ym = yFrom != null ? Integer.parseInt(yFrom) : null;
		Integer yn = yTo != null ? Integer.parseInt(yTo) : null;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		if (xFrom != null && xTo != null && yFrom != null && yTo == null) {			// From column m to n at row p
			for (int i = xm; i <= xn; i++) {
				numbers.add(((ym - 1) * this.cols) + i);
			}
		} else if (xFrom != null && xTo == null && yFrom != null && yTo != null) {	// From row m to n at column p
			for (int i = ym - 1; i < yn; i++) {
				numbers.add((i * this.cols) + xm);
			}
		} else if (xFrom != null && xTo == null && yFrom != null && yTo == null) {  // Row m at column p
			numbers.add(((ym - 1) * this.cols) + xm);
		}
		
		return numbers;
	}
	
	public List<Integer> getIndexes() {
		return ranges;
	}
	
	public String toString() {
		return ranges.toString();
	}
}
