package com.mishadoff.randomorg;

import java.io.IOException;
import java.util.ArrayList;

import com.mishadoff.randomorg.util.HTTPUtils;


/**
 * Integer generator part of random.org API.
 * Provides methods for random integer numbers generating.
 * 
 * @author vgmoose
 *
 */
public class DoubleGenerator {
	
	private final static String INTEGER_QUERY = "http://random.org/integers/?format=plain";
	private final static String INT_MIN = "&min=";
	private final static String INT_MAX = "&max=";
	private final static String INT_NUM = "&num=";
	private final static String INT_BASE = "&base=";
	private final static String INT_COL = "&col=";
	
	private final static int BASE = 10;
	private final static int COLS = 1;
	
	/**
	 * Generate <b>count</b> doubles between <b>0</b> and <b>1</b> inclusively.
	 * Similar behavior to Random.nextDouble().
	 *
	 * @param count
	 * @return list of numbers
	 * @throws IOException
	 */
	public ArrayList<Double> generate(int count) throws IOException {
        int min = 0;
        int max = 1000000000;
        
		String query = INTEGER_QUERY 
						+ INT_MIN + min 
						+ INT_MAX + max
						+ INT_NUM + count
						+ INT_BASE + BASE
						+ INT_COL + COLS;
		ArrayList<String> strings = HTTPUtils.get(query);
		ArrayList<Double> numbers = new ArrayList<Double>();
		for (String str : strings) {
			numbers.add((double)(Integer.parseInt(str, BASE)) / (double)(1000000000));
		}
		return numbers;
	}
}
