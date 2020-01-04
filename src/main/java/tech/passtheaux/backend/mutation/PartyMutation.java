package tech.passtheaux.backend.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.passtheaux.backend.dao.entity.Party;
import tech.passtheaux.backend.service.PartyService;

import java.util.Optional;

@Component
public class PartyMutation implements GraphQLMutationResolver {

    @Autowired
    private PartyService partyService;

    public Party createParty(final String partyId, final String playlistId, final String spotifyRefreshToken, final String spotifyAcessToken)  {
        return this.partyService.createParty(partyId, playlistId, spotifyRefreshToken, spotifyAcessToken);
    }

    public Party createBasicParty(final String partyId, final String spotifyAuthCode)  {
        return this.partyService.createParty(partyId, spotifyAuthCode);
    }

    public Optional<Party> refreshToken(final String partyId) {
        return this.partyService.refreshToken(partyId);
    }

}
