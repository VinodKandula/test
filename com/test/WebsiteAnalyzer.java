/**
 * 
 */
package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author vinod
 *
 */
public class WebsiteAnalyzer {

	private static SortedSet<Website> orderedSet = new TreeSet<>();

	private static Map<String, Website> _websiteMap = new ConcurrentHashMap<>();

	public void reportPageAccess(String pageUrl) {
		if (pageUrl != null && pageUrl.length() > 0) {
			Website website = _websiteMap.get(pageUrl);
			if (website == null) {
				website = new Website();
				website.setWebpage(pageUrl);
				website.setCounter(1);
				_websiteMap.put(pageUrl, website);
				orderedSet.add(website);
			} else {
				website.setCounter(website.getCounter() + 1);
				_websiteMap.put(pageUrl, website);
			}
		}
	}

	public List<Website> getTopNPages(int n) {
		System.out.println("Ordered Set : "+orderedSet);

		if (n > 0 ) {
			return new ArrayList<Website>(orderedSet).subList(0, orderedSet.size() > n ? n : orderedSet.size());
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
		websiteAnalyzer.reportPageAccess("google.com");
		websiteAnalyzer.reportPageAccess("facebook.com");
		websiteAnalyzer.reportPageAccess("amazon.com");
		websiteAnalyzer.reportPageAccess("toovia.com");
		websiteAnalyzer.reportPageAccess("flipkart.com");
		websiteAnalyzer.reportPageAccess("flipkart.com");
		websiteAnalyzer.reportPageAccess("flipkart.com");
		websiteAnalyzer.reportPageAccess("flipkart.com");
		websiteAnalyzer.reportPageAccess("google.com");
		websiteAnalyzer.reportPageAccess("google.com");
		websiteAnalyzer.reportPageAccess("google.com");
		websiteAnalyzer.reportPageAccess("google.com");

		System.out.println("Top webpages list : " + websiteAnalyzer.getTopNPages(10));
	}

	static class WebsiteComp implements Comparator<Website> {
		
		@Override
		public int compare(Website site1, Website site2) {
			if (site1.getCounter() > site2.getCounter()) {
				return 1;
			} else {
				return -1;
			}
		}

	}

	class Website implements Comparable<Website> {
		private String webpage;
		private int counter;

		public String getWebpage() {
			return webpage;
		}

		public void setWebpage(String webpage) {
			this.webpage = webpage;
		}

		public int getCounter() {
			return counter;
		}

		public void setCounter(int counter) {
			this.counter = counter;
		}

		@Override
		public String toString() {
			return "Website [webpage=" + webpage + ", counter=" + counter + "]";
		}

		@Override
		public int compareTo(Website o) {
			if (this.getCounter() > o.getCounter()) {
				return 1;
			} else {
				return -1;
			}
		}
	}

}

