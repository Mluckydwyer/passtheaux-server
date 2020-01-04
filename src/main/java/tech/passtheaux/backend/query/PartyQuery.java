package tech.passtheaux.backend.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.passtheaux.backend.dao.entity.Party;
import tech.passtheaux.backend.service.PartyService;

import java.util.List;
import java.util.Optional;

@Component
public class PartyQuery implements GraphQLQueryResolver {

    @Autowired
    private PartyService partyService;

    public List<Party> getParties(final int count) {
        return this.partyService.getAllParties(count);
    }

    public Optional<Party> getParty(final int id) {
        return this.partyService.getParty(id);
    }

    public Optional<Party> getPartyById(final String partyId) {
        return this.partyService.getPartyByPartyId(partyId);
    }
}
