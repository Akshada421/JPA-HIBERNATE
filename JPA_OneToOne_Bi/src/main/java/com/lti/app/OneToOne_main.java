package com.lti.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.entity.Citizen;
import com.lti.entity.Passport;

public class OneToOne_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Citizen c1= new Citizen();
		c1.setCid(3003);
		c1.setCname("Akshada");
		
		
		Passport p1=new Passport();
		p1.setPno(8976);
		p1.setPtype("International");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em=emf.createEntityManager();
		
		p1.setCitizen(c1);
		
		c1.setPassport(p1);
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(c1);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Citizen citizen=em.find(Citizen.class, 3003);
		System.out.println("Citizen Passport No: "+citizen.getPassport().getPno());
		
		Passport passport=em.find(Passport.class, 8976);
		System.out.println("citizen name: "+passport.getCitizen().getCname());
	}

}
