package tr.com.obss.counrty.test;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tr.com.obss.counrty.domain.Capital;

public class MainClass {

	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("capitalPU");
		EntityManager entityManager =
				emf.createEntityManager();
		entityManager.getTransaction().begin();
		try {
			BufferedReader rd = new BufferedReader(new FileReader("c:/aaa.txt"));

			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				String arr[] = line.split("\t");
				
				String country = arr[0];
				String capital = arr[1];
				String ltStr = arr[2].trim().substring(0,arr[2].length()-2);
				String lnStr = arr[3].trim().substring(0,arr[3].length()-1);
				System.out.println(ltStr +":"+lnStr+":");
				int x = 1;
				int y = 1;
				if(arr[2].contains("S"))
					x = -1;
				if(arr[3].contains("W"))
					y=-1;
				double latitude = Double.parseDouble(ltStr)*x;
				double longitude = Double.parseDouble(lnStr)*y;
				
				Capital capit = new Capital(country, capital, latitude, longitude);
				//System.out.println(capit);
				entityManager.persist(capit);
			}
			entityManager.getTransaction().commit();
			rd.close();
			System.out.println("Oldu be yaaaa.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
