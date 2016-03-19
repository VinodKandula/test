/**
 * 
 */
package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author vinod
 *
 */
public class WebsiteAnalyzer {

	/*private static SortedSet<Website> orderedSet = new TreeSet<>(new Comparator<Website>() {
        public int compare(Website site1, Website site2) {
    			if (site1.getCounter() < site2.getCounter()) {
    				return 1;
    			}
    			return -1;
        }
    });*/

	private static List<Website> list = new ArrayList<>();
	private static Map<String, Website> _websiteMap = new ConcurrentHashMap<>();

	public void reportPageAccess(String pageUrl) {
		if (pageUrl != null && pageUrl.length() > 0) {
			Website website = _websiteMap.get(pageUrl);
			if (website == null) {
				website = new Website();
				website.setWebpage(pageUrl);
				website.setCounter(1);
				_websiteMap.put(pageUrl, website);
				list.add(website);
			} else {
				website.setCounter(website.getCounter() + 1);
				_websiteMap.put(pageUrl, website);
			}
		}
	}

	public List<String> getTopNPages(int n) {
		Collections.sort(list, new WebsiteComp());
		
		if (n > 0 ) {
			List<Website> webPageList = list.subList(0, list.size() > n ? n : list.size());
			List<String> topWebpages = new ArrayList<>(webPageList.size());
			for (Website website : webPageList) {
				topWebpages.add(website.getWebpage());
			}
			return topWebpages;
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
		//websiteAnalyzer.reportPageAccess("toovia.com");
		websiteAnalyzer.reportPageAccess("flipkart.com");
		websiteAnalyzer.reportPageAccess("flipkart.com");
		websiteAnalyzer.reportPageAccess("flipkart.com");
		websiteAnalyzer.reportPageAccess("flipkart.com");
		websiteAnalyzer.reportPageAccess("google.com");
		websiteAnalyzer.reportPageAccess("google.com");
		websiteAnalyzer.reportPageAccess("google.com");
		websiteAnalyzer.reportPageAccess("google.com");

		System.out.println("Top webpages list : " + websiteAnalyzer.getTopNPages(5));
	}

	class WebsiteComp implements Comparator<Website> {
		
		@Override
		 public int compare(Website site1, Website site2) {
			if (site1.getCounter() < site2.getCounter()) {
				return 1;
			}
			return -1;
        }

	}

	class Website {
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
		
	}

}

