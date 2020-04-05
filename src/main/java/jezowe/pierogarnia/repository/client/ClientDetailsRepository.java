package jezowe.pierogarnia.repository.client;

import jezowe.pierogarnia.model.client.ClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientDetailsRepository extends JpaRepository<ClientDetails, Long> {
    Optional<ClientDetails> findById(Long id);

    ClientDetails findByFktCustomerId(Long fktCustomerId);

    ClientDetails findByExtraInfoClientName(String extraInfoClientName);

    boolean existsByFktCustomerId(Long fktCustomerId);

    boolean existsByExtraInfoClientName(String name);

    boolean existsById(Long id);
}
