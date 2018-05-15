package org.sid.contacts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.contacts.dao.ContactRepository;
import org.sid.contacts.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner{

	@Autowired
	private ContactRepository contactRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("Fazazi", "Mohammed", df.parse("07/08/1991"), "Fazazi@outlook.com", "0698763741", "simo.png"));
		contactRepository.save(new Contact("Fazazi", "Mehdi", df.parse("09/04/1997"), "Mehdi@outlook.com", "0698763741", "simo.png"));
		
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getPrenom());
		});
		
	}
}
