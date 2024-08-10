package com.sam.notetaker.repository

import com.sam.notetaker.model.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : JpaRepository<Note, Long>
