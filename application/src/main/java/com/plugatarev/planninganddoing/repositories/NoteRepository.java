package com.plugatarev.planninganddoing.repositories;

import com.plugatarev.planninganddoing.models.MarkDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MarkRepository<T extends MarkDTO> extends CrudRepository<T, Long> {}
