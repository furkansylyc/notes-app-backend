package com.furkansoyleyici.easynoteapi.repository;

import com.furkansoyleyici.easynoteapi.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Integer> {

    List<Notes> findAllByOrderByPriorityDesc();

    List<Notes> findAllByOrderByPriorityAsc();

    List<Notes> findByIsFavoriteTrue();

    List<Notes> findByTitleContainingIgnoreCase(String keyword);

}