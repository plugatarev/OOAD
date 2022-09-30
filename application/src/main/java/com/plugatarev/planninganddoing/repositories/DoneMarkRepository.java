package com.plugatarev.planninganddoing.repositories;

import com.plugatarev.planninganddoing.models.DoneMark;
import org.springframework.data.repository.CrudRepository;

public interface MarkRepository extends CrudRepository<DoneMark, Long> {
}
