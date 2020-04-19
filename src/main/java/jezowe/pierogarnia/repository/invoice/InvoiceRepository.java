package jezowe.pierogarnia.repository.invoice;

import jezowe.pierogarnia.model.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceDetails, Long> {
}
