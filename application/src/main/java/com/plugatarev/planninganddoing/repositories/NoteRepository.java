package com.plugatarev.planninganddoing.repositories;

import com.plugatarev.planninganddoing.models.NoteDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface NoteRepository<T extends NoteDTO> extends CrudRepository<T, Long> {}
