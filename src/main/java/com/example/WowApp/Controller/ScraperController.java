package com.example.WowApp.Controller;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WowApp.Model.WorldQuest;

@Controller
public class ScraperController {

	@GetMapping("/")
	public String getWQ(Model model) throws IOException {
		WorldQuest quest = new WorldQuest();
		
		quest.setVraxthul(vraxthul());
		quest.setVenomfin(venomfin());
		quest.setSkreeg(skreeg());
		quest.setPuscilla(puscilla());
		quest.setBlistermaw(blistermaw());
		
		model.addAttribute("quest",quest);
		return "index";
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
