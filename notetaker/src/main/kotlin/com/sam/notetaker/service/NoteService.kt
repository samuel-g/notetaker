package com.sam.notetaker.service

import com.sam.notetaker.model.Note
import com.sam.notetaker.repository.NoteRepository
import org.springframework.stereotype.Service

@Service
class NoteService(private val noteRepository: NoteRepository) {

    fun getAllNotes(): List<Note> = noteRepository.findAll()

    fun getNoteById(id: Long): Note? = noteRepository.findById(id).orElse(null)

    fun createNote(note: Note): Note = noteRepository.save(note)

    fun updateNote(id: Long, updatedNote: Note): Note? {
        return noteRepository.findById(id).map { existingNote ->
            val updated = existingNote.copy(
                    title = updatedNote.title,
                    content = updatedNote.content
            )
            noteRepository.save(updated)
        }.orElse(null)
    }

    fun deleteNote(id: Long) {
        noteRepository.deleteById(id)
    }
}
