package com.main.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.MainDao;
import com.main.entities.Notes;
import com.main.entities.User;

import jakarta.transaction.Transactional;

@Service
public class MainService {

	@Autowired
	private MainDao dao;

	public String adduser(User user) {

		String msg = dao.addUser(user);

		if (Objects.isNull(msg)) {
			msg = "due to some error";
		}
		return msg;
	}

	public String upUser(User user, int id) {

		String msg = dao.upUser(user, id);

		if (Objects.isNull(msg)) {
			msg = "due to some error";
		}
		return msg;
	}

	public String deleteUser(int id) {

		String msg = dao.deleteUser(id);

		if (Objects.isNull(msg)) {
			msg = "due to some error";
		}
		return msg;
	}

	public List<User> getAllUser() {

		return dao.getAllUser();

	}

	public User getByIdUser(int id) {

		return dao.getByIdUser(id);

	}

	// ------------------

	public String addNotes(Notes notes) {

		String msg = dao.addNotes(notes);

		if (Objects.isNull(msg)) {
			msg = "due to some error";
		}
		return msg;

	}

	public List<Notes> getAllNotes() {
		return dao.getAllNotes();

	}

	public User login(User user) {

		return dao.login(user);

	}

	@Transactional
	public List<Notes> getNotesByUserId(int userId) {
		return dao.findNotesByUserId(userId);
	}

	public Notes getByidNotes(int id) {

		return dao.getByidNotes(id);

	}

	public String updatenotes(Notes notes, int id) {

		String msg = dao.updatenotes(notes, id);

		if (Objects.isNull(msg)) {
			msg = "due to some error";
		}
		return msg;
	}

	public String deleteNotes(int id) {

		String msg = dao.deleteNotes(id);

		if (Objects.isNull(msg)) {
			msg = "due to some error.....";
		}
		return msg;
	}

}
