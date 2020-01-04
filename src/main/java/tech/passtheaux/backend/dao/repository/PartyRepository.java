package tech.passtheaux.backend.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.passtheaux.backend.dao.entity.Party;

import java.util.Optional;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
    Optional<Party> findPartyByPartyId(String partyId);
//    Boolean findPartyByPartyIdExists(String partyId);
}
