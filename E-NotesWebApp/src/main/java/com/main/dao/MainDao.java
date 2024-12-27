package com.main.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.entities.Notes;
import com.main.entities.User;

@Repository
public class MainDao {

	@Autowired
	private SessionFactory sf;

	public String addUser(User user) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {

			session.persist(user);
			tx.commit();
			return "Data Inserted Successfully..";
		} catch (Exception e) {
			e.getMessage();

			tx.rollback();
			return "due to some error";
		}

	}

	public String upUser(User user, int id) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {

			User bhu = session.get(User.class, id);

			bhu.setName(user.getName());
			bhu.setEmail(user.getEmail());
			bhu.setPassword(user.getPassword());
			bhu.setAge(user.getAge());
			tx.commit();
			return "Data Updated Successfully.....";

		} catch (Exception e) {

			tx.rollback();
			return "due to some error";

		}

	}

	public String deleteUser(int id) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {

			User bhu = session.get(User.class, id);

			session.remove(bhu);
			tx.commit();
			return "Data Updated Successfully.....";

		} catch (Exception e) {
			tx.rollback();
			return "due to some error";
			// TODO: handle exception
		}

	}

	public List<User> getAllUser() {

		Session session = sf.openSession();
		String hqlQuery = "from User";

		Query<User> query = session.createQuery(hqlQuery, User.class);

		List<User> list = query.list();
		return list;

	}

	public User getByIdUser(int id) {

		Session session = sf.openSession();

		User bhu = session.get(User.class, id);

		return bhu;
	}

	// ---------------------------

	public String addNotes(Notes notes) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {

//			System.out.println(notes.getUser());
			notes.setCreatedDate(new Date());
			notes.setUpdatedDate(new Date());
			session.persist(notes);

			tx.commit();
			return "Data Inserted Successfully..";
		} catch (Exception e) {
			e.getMessage();

			tx.rollback();
			return "due to some error";
		}

	}

	public List<Notes> getAllNotes() {
		Session session = sf.openSession();

		String hqlQuery = "from Notes";

		Query<Notes> query = session.createQuery(hqlQuery, Notes.class);

		List<Notes> list = query.list();

		return list;

	}

	public void getNotesByid(int id) {

	}

	public User login(User user) {

		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		Session session = null;
		Transaction tx = null;
		User us = null;
		String hqlQuery = "from User where email=:email and password=:password";
		try {
			session = sf.openSession();
			tx = session.beginTransaction();

			Query<User> query = session.createQuery(hqlQuery, User.class);
			query.setParameter("email", user.getEmail());
			query.setParameter("password", user.getPassword());
			us = query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return us;
	}

	// get userid
	public List<Notes> findNotesByUserId(int id) {
		Session session = sf.openSession();
		String hql = "FROM Notes n WHERE n.user.id = :id";
		Query<Notes> query = session.createQuery(hql, Notes.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	public Notes getByidNotes(int id) {

		Session session = sf.openSession();

		Notes notes = session.get(Notes.class, id);

		return notes;

	}

	public String updatenotes(Notes notes, int id) {

		String msg = null;
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {

			Notes not = session.get(Notes.class, id);
//			not.setCreatedDate(new Date());
			not.setUpdatedDate(new Date());
			not.setTitle(notes.getTitle());
			not.setContent(notes.getContent());
			session.persist(not);
			tx.commit();
			msg = "Data Updated Successfully";

		} catch (Exception e) {
			tx.rollback();

			e.getMessage();
			msg = "due to some errro";
		}
		return msg;

	}

	public String deleteNotes(int nid) {

		String msg = null;
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {

			Notes bhu = session.get(Notes.class, nid);
			session.remove(bhu);
			tx.commit();
			msg = "Data Deleted Successfully....";

		} catch (Exception e) {

			e.getMessage();
			System.out.println(e);
			System.out.println(e.getMessage());
			tx.rollback();
			msg = "due to some error";

		}

		return msg;

	}

}
