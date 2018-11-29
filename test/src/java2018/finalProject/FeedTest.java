package java2018.finalProject;

import java.util.ArrayList;
import java.util.Collections;

public class FeedTest {



	public static void main(String[] args) {
		ArrayList<Feed> feed = new ArrayList<Feed>();
		feed.add(new SimpleFeed());
		feed.add(new GeneralFeed());
		feed.add(new AdvancedFeed());
		feed.add(new SimpleFeed());
		
		int a = 0;
		for(Feed fd: feed)
		{
			if(fd.getName() == "低級飼料")
				a++;
		}
		
		System.out.println(a);
	}

}
