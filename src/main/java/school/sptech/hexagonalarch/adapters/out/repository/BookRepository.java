package school.sptech.hexagonalarch.adapters.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.hexagonalarch.adapters.out.repository.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
