package in.cg.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.cg.beans.Address;
import in.cg.beans.Person;

@Configuration
public class JavaConfigFile {
	
	@Bean("p1")
	public Person pObj1() {
		
		Person p = new Person();
		p.setpId(1);
		p.setpName("Madhav");
		p.setGender("M");
		
		Address ad = new Address();
		ad.setCity("Bapatla");
		ad.setPincode(522101);
		
		p.setAddress(ad);
		return p;
	}
	
	@Bean("p2")
	public Person pObj2() {
		
		Person p = new Person();
		p.setpId(2);
		p.setpName("Yagna");
		p.setGender("M");
		
		Address ad = new Address();
		ad.setCity("CPT");
		ad.setPincode(522616);
		
		p.setAddress(ad);
		return p;
	}
}
