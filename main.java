package crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class main {
	private final static String address = "http://www.findip.kr/";
	
	public static void main(String[] args) throws Exception{
		Document doc = Jsoup.connect(address).header("User-Agent", "AppleWebkit/536.5").get();
		//System.out.println(doc);
		
		String h1 = doc.select("h1").text();
		String h2 = doc.select("h2").eq(1).text();
		Elements contents = doc.select("p");
		
		System.out.println(h1);
		System.out.println(h2);
		
		
		int idx=0;
		for(Element element : contents) {
			if(0<idx && idx<5) {
				System.out.println(element.text());
			}
			idx++;
		}
	}
}
