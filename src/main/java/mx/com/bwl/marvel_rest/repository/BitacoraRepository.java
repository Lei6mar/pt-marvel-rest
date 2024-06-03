package mx.com.bwl.marvel_rest.repository;

import mx.com.bwl.marvel_rest.entity.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraRepository extends JpaRepository<Bitacora, Long> {
}
