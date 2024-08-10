package com.sam.notetaker.controller

import com.sam.notetaker.model.Note
import com.sam.notetaker.service.NoteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/notes")
class NoteController(private val noteService: NoteService) {

    @GetMapping
    fun getAllNotes(): List<Note> = noteService.getAllNotes()

    @GetMapping("/{id}")
    fun getNoteById(@PathVariable id: Long): ResponseEntity<Note> {
        val note = noteService.getNoteById(id)
        return if (note != null) {
            ResponseEntity.ok(note)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createNote(@RequestBody note: Note): ResponseEntity<Note> {
        val createdNote = noteService.createNote(note)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNote)
    }

    @PutMapping("/{id}")
    fun updateNote(
            @PathVariable id: Long,
            @RequestBody updatedNote: Note
    ): ResponseEntity<Note> {
        val note = noteService.updateNote(id, updatedNote)
        return if (note != null) {
            ResponseEntity.ok(note)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteNote(@PathVariable id: Long): ResponseEntity<Void> {
        return if (noteService.getNoteById(id) != null) {
            noteService.deleteNote(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
