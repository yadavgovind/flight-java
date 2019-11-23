//package com.flight.reservation.flightreservation.dto;
//
//import java.util.List;
//
//import javax.transaction.Transaction;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//
//import com.flight.reservation.flightreservation.model.UserDetails;
//
//public class FlightRegistrationDAOImpl implements FlightReservationDAO {
//
//	@Override
//	public UserDetails findUser(String email) {
//		System.out.println("calling find User function invoked");
////		Session session = SessionUtil.getSession();
//		org.hibernate.Transaction transaction = session.beginTransaction();
//		// rom Account a where a.accountId = :accountId
//		// ;
//		String hql = "from userdetails p where p.email = :emailId";// +email
//		List<UserDetails> userdetails = session.createQuery(hql).setString("emailId", email).list();
//		System.out.println("qry:" + hql);
////		org.hibernate.query.Query query=session.createQuery(qry);
////		List<UserDetails> userdetails=query.list();
//		System.out.println("userdetails:" + userdetails);
//		for (UserDetails userDetails2 : userdetails) {
//			System.out.println("Username:" + userDetails2.getUsername());
//			System.out.println("Email:" + userDetails2.getEmail());
//		}
//
//		transaction.commit();
//		session.close();
//
//		return null;
//	}
//
//	@Override
//	public void saveDetails(UserDetails userDetails) {
//		Session session = SessionUtil.getSession();
//		org.hibernate.Transaction transaction = session.beginTransaction();
//		session.save(userDetails);
//		transaction.commit();
//		session.close();
//		System.out.println("inserted successfully");
//
//	}
//
//}
