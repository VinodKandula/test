/**
 * 
 */
package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinod
 *
 */
public class WebsiteAnalyzer {
	
	private static List<String> webpageList = new ArrayList<>();
	
	 public void reportPageAccess(String pageUrl) {
		 if (pageUrl != null && pageUrl.length() > 0) {
			 synchronized (webpageList) {
				 webpageList.add(pageUrl);
			}
		 }
	 }
	 
	 public List<String> getTopNPages(int n) {
		 if (n > 0 && n <= webpageList.size()) {
			 return new ArrayList<String>(webpageList.subList(0, n));
		 }
		 return null;
	 }

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

