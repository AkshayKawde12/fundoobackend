package com.bridgelabz.fundoo.notes.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoo.notes.dto.NotesDto;

import com.bridgelabz.fundoo.notes.model.Note;
import com.bridgelabz.fundoo.notes.service.NoteService;
import com.bridgelabz.fundoo.response.Response;
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/notes")
public class NotesController {
	
	@Autowired
	private NoteService noteService;
	
	@PostMapping("/create")
	public ResponseEntity<Response> createNote(@RequestBody NotesDto notesDto) {
		Response responseStatus = noteService.onCrete(notesDto);
		return new ResponseEntity<Response>(responseStatus, HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<Response> updateNote(@RequestBody NotesDto notesDto, String userId,@RequestParam Long noteId) {
		Response responseStatus = noteService.update(notesDto, noteId);
		return new ResponseEntity<Response>(responseStatus, HttpStatus.OK);
	}
		
	@PutMapping("/permanetdelete")
	public ResponseEntity<Response>permanentdeletNote(@RequestParam long noteId)
	{
		Response responseStatus=noteService.permanentdelete(noteId);
		return new ResponseEntity<Response>(responseStatus,HttpStatus.OK);
	}
	@PutMapping("/trash/untrash")
	public ResponseEntity<Response> trash(@RequestParam long noteId) {
		Response responseStatus = noteService.trash(noteId);
		return new ResponseEntity<Response>(responseStatus, HttpStatus.OK);
	}

	@PutMapping("/pin/unpin")
	public ResponseEntity<Response> pin(@RequestParam long noteId) {
		Response responseStatus = noteService.pin(noteId);
		return new ResponseEntity<Response>(responseStatus, HttpStatus.OK);
	}
	
	@PutMapping("/archive/unarchive")
	public ResponseEntity<Response> archive(@RequestParam long noteId) {
		Response responseStatus = noteService.archive(noteId);
		return new ResponseEntity<Response>(responseStatus, HttpStatus.OK);
	}
	@GetMapping("/getAllNotes")
	public List<Note> getAllNotes() {
		List<Note>listNotes=noteService.getAllNotes();
		return listNotes;
	}
	
	@GetMapping("/getAllArchive")
	public List<NotesDto> getPinnedNotes() {
		List<NotesDto>listNotes=noteService.getAllArchive();
		return listNotes;
	}
	@GetMapping("/getAllTrash")
	public List<NotesDto> getAllTrash()
	{
		List<NotesDto>listNotes=noteService.getAllTrash();
		return listNotes;
	}
	
	@GetMapping("/getAllPinedNotes")
	public List<NotesDto> getAllPinedNotes()
	{
		List<NotesDto>listNotes=noteService.getAllPinedNotes();
		return listNotes;
	}
	@PutMapping("/color")
	public ResponseEntity<Response>noteColor(@RequestParam long noteId, String color )
	{
		Response responseStatus =noteService.setColor(noteId,color);
		return new ResponseEntity<Response>(responseStatus, HttpStatus.OK);
	}
	
	
}

