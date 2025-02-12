package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entities.Notes;
import com.main.entities.User;
import com.main.services.MainService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class MainController {

	@Autowired
	private MainService servi;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("adduser")
	public ResponseEntity<String> adduser(@RequestBody User user) {
		System.out.println(user);
		String msg = servi.adduser(user);

		return ResponseEntity.ok(msg);

	}

	@PutMapping("upuser/{id}")
	public ResponseEntity<String> upUser(@RequestBody User user, @PathVariable int id) {

		String msg = servi.upUser(user, id);
System.out.print();
		return ResponseEntity.ok(msg);

	}

	@DeleteMapping("deleteuser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {

		String msg = servi.deleteUser(id);

		return ResponseEntity.ok(msg);
	}

	@GetMapping("getAlluser")
	public ResponseEntity<List<User>> getAllUser() {

		List<User> list = servi.getAllUser();

		return ResponseEntity.ok(list);

	}

//	@GetMapping("getAllUser")
//	public List<User> getAllUser() {
//		return servi.getAllUser();
//	}

	@GetMapping("getuser/{id}")
	public ResponseEntity<User> getByIdUser(@PathVariable int id) {

		User user = servi.getByIdUser(id);

		return ResponseEntity.ok(user);

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("addNotes")
	public ResponseEntity<String> addNotes(@RequestBody Notes notes) {
		System.out.println(notes);
		String msg = servi.addNotes(notes);

		return ResponseEntity.ok(msg);

	}

	@GetMapping("getAllnotes")
	public ResponseEntity<List<Notes>> getAllNotes() {
		List<Notes> list = servi.getAllNotes();
		return ResponseEntity.ok(list);

	}

	@PostMapping("login")
	public ResponseEntity<User> login(@RequestBody User user) {

		User us = servi.login(user);

		return ResponseEntity.ok(us);
	}

	@GetMapping("getNotes/{id}")
	public ResponseEntity<List<Notes>> getNotesByUserId(@PathVariable int id) {
		List<Notes> notes = servi.getNotesByUserId(id);
		return ResponseEntity.ok(notes);
	}

	@GetMapping("getnotes/{nid}")
	public ResponseEntity<Notes> getByidNotes(@PathVariable int nid) {

		Notes notes = servi.getByidNotes(nid);

		return ResponseEntity.ok(notes);
	}

	@PutMapping("upNotes/{id}")
	public ResponseEntity<String> updatenotes(@RequestBody Notes notes, @PathVariable int id) {

		String msg = servi.updatenotes(notes, id);

		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("deleteNotes/{id}")
	public ResponseEntity<String> deleteNotes(@PathVariable int id) {
   System.out.println(id);
		String msg = servi.deleteNotes(id);

		return ResponseEntity.ok(msg);

	}

}
