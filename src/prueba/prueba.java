package prueba;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db_items.*;
import utils.HibernateUtils;

public class prueba {

	private static Session session;
	/*
	public static void main(String[] args) {
		session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		byte[] CDRIVES = hexStringToByteArray("e04fd020ea3a6910a2d808002b30309d");
		//session.save(new Airlines(2,"a","a",CDRIVES,CDRIVES));
		
		readPlanes();
		//tx.commit();
		session.close();
		//readPlanes();
	}
	*/
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}

	@SuppressWarnings("unchecked")
	public static void readPlanes(){
		Query queryResult = session.createQuery("from Airlines");
		List<Airlines> allPlanes = queryResult.list();
		for (int i = 0; i < allPlanes.size(); i++) {
			Airlines airlines = allPlanes.get(i);
			System.out.println("Planes : " +  airlines.getId());
		}
	}
}
