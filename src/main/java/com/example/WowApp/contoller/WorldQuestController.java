package com.example.WowApp.contoller;

import java.io.IOException;

import ch.qos.logback.core.CoreConstants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WorldQuestController {

	@GetMapping("/wq")
	public void getWorldQuest() throws IOException {
		String html = "";
		Document doc = Jsoup.connect("https://www.wowhead.com/quest=48725/venomtail-skyfin").get();
		Element li = doc.getElementsByTag("li").first();
		System.out.println(li.html());

//		Document doc = Jsoup.connect("https://www.wowhead.com/quest=48725/venomtail-skyfin").get();
//		Element li = doc.selectFirst("#infobox-contents-0 > ul > li:nth-child(6) > div");
//		html = li.html();
//		System.out.println(html.toString());
	}

}
