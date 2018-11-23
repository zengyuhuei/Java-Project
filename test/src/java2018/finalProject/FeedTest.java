package java2018.finalProject;

import java.util.ArrayList;
import java.util.Collections;

public class FeedTest {



	public static void main(String[] args) {
		ArrayList<Feed> feed = new ArrayList<Feed>();
		feed.add(new SimpleSeed());
		feed.add(new GeneralSeed());
		feed.add(new AdvancedSeed());
		feed.add(new SimpleSeed());
		
		int a = 0;
		for(Feed fd: feed)
		{
			if(fd.getName() == "低級飼料")
				a++;
		}
		
		System.out.println(a);
	}

}
