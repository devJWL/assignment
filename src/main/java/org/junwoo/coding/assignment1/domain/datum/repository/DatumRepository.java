package org.junwoo.coding.assignment1.domain.datum.repository;

import org.junwoo.coding.assignment1.domain.datum.entity.Datum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatumRepository extends JpaRepository<Datum, Long> {

}
