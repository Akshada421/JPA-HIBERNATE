package com.lti.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.entity.Order;
import com.lti.entity.Product;

public class ManyToMany_main {

	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em=emf.createEntityManager();
		
		
		Product p1 =new Product();
		p1.setPid(11);
		p1.setPname("prod-1");
		
		Product p2 =new Product();
		p2.setPid(12);
		p2.setPname("prod-2");
		
		Order o1=new Order();
		o1.setOid(100);
		o1.setOname("Order-1");
		
		Order o2=new Order();
		o2.setOid(101);
		o2.setOname("Order-2");
		
		//p1 product belongs to two orders
		List<Order>olist1=new ArrayList<>();
		olist1.add(o1);
		olist1.add(o2);
		p1.setOrder_list(olist1);
		
		List<Order>olist2=new ArrayList<>();
		olist2.add(o2);
		p2.setOrder_list(olist2);
		
		List<Product>plist1=new ArrayList<>();
		plist1.add(p1);
		o1.setProdlist(plist1);
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();
		
		
		//order can access the product
		System.out.println("order can access the product details");
		Order order=em.find(Order.class,100);
		List<Product>plist=order.getProdlist();
		for(Product p:plist) {
			System.out.println("product name :"+p.getPname());
		}
		
		System.out.println("Product can access the order details ");;
		Product prod=em.find(Product.class, 12);
		List<Order>olist=prod.getOrder_list();
		for(Order o: olist) {
			System.out.println("Order name:"+o.getOname());
		}
		
		

	}

}
