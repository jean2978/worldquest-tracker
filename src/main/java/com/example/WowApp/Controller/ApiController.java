package com.example.WowApp.Controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.WowApp.Model.WorldQuest;

@Controller
@RequestMapping("/v1/api")
public class ApiController {

	@ResponseBody
	@RequestMapping("/wq")
	public WorldQuest getWorldQuest() throws IOException {
		WorldQuest quest = new WorldQuest();

		quest.setVraxthul(vraxthul());
		quest.setVenomfin(venomfin());
		quest.setSkreeg(skreeg());
		quest.setPuscilla(puscilla());
		quest.setBlistermaw(blistermaw());
		
		return quest;
	}

	public Boolean vraxthul() throws IOException {
		Document doc = Jsoup.connect("https://www.wowhead.com/quest=48465/vraxthul").get();
		Boolean html = doc.html().contains("EU Realms") ? true : false;
		return html;
	}

	public Boolean venomfin() throws IOException {
		Document doc = Jsoup.connect("https://www.wowhead.com/quest=48725/venomtail-skyfin").get();
		Boolean html = doc.html().contains("EU Realms") ? true : false;
		return html;
	}

	public Boolean skreeg() throws IOException {
		Document doc = Jsoup.connect("https://www.wowhead.com/quest=48740/skreeg-the-devourer").get();
		Boolean html = doc.html().contains("EU Realms") ? true : false;
		return html;
	}

	public Boolean puscilla() throws IOException {
		Document doc = Jsoup.connect("https://www.wowhead.com/quest=48467/puscilla").get();
		Boolean html = doc.html().contains("EU Realms") ? true : false;
		return html;
	}

	public Boolean blistermaw() throws IOException {
		Document doc = Jsoup.connect("https://www.wowhead.com/quest=47561/blistermaw").get();
		Boolean html = doc.html().contains("EU Realms") ? true : false;
		return html;
	}
}
