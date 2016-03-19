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
	
	private static List<String> _WEB_PAGE_LIST = new ArrayList<>();
	
	 public void reportPageAccess(String pageUrl) {
		 if (pageUrl != null && pageUrl.length() > 0) {
			 synchronized (_WEB_PAGE_LIST) {
				 _WEB_PAGE_LIST.add(pageUrl);
			}
		 }
	 }
	 
	 public List<String> getTopNPages(int n) {
		 if (n > 0 && n <= _WEB_PAGE_LIST.size()) {
			 return new ArrayList<String>(_WEB_PAGE_LIST.subList(0, n));
		 }
		 return null;
	 }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebsiteAnalyzer websiteAnalyzer = new WebsiteAnalyzer();
		websiteAnalyzer.reportPageAccess("google.com");
		websiteAnalyzer.reportPageAccess("facebook.com");
		websiteAnalyzer.reportPageAccess("amazon.com");
		websiteAnalyzer.reportPageAccess("toovia.com");
		websiteAnalyzer.reportPageAccess("flipkart.com");
		
		System.out.println("Top webpages list : "+websiteAnalyzer.getTopNPages(3));
	}

}

