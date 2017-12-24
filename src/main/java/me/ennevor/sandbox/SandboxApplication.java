package me.ennevor.sandbox;

import me.ennevor.sandbox.entity.Entry;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SandboxApplication {
	public static List<Entry> entryList = new ArrayList<>();
	public static void main(String[] args) {

		SpringApplication.run(SandboxApplication.class, args);

		DataFactory df = new DataFactory();

		for(int i = 0; i < 100000; i++){
			Entry entry = new Entry();
			entry.setFirstName(df.getFirstName());
			entry.setLastName(df.getLastName());
			entry.setCountry("USA");
			entry.setAddress(df.getAddress());
			entry.setCity(df.getCity());
			entry.setState(df.getRandomWord(2).toUpperCase());
			entry.setZip(String.valueOf(df.getNumberBetween(10000, 99999)));
			entry.setPhone("(" + df.getNumberText(3) + ") " + df.getNumberText(3) + " - " + df.getNumberText(4));
			SandboxApplication.entryList.add(entry);
			System.out.println(entry.toString());
		}

	}
}
