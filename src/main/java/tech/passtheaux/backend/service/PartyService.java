package tech.passtheaux.backend.service;

import okhttp3.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.passtheaux.backend.dao.entity.Party;
import tech.passtheaux.backend.dao.repository.PartyRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartyService {

    private final PartyRepository partyRepository;
    private final OkHttpClient okHttpClient;

    public PartyService(final PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
        this.okHttpClient = new OkHttpClient();
    }

    @Transactional
    public Party createParty(final String partyId, final String spotifyAuthCode) {
        String playlistId = "";
        String spotifyRefreshToken = "";
        String spotifyAcessToken = "";

        return createParty(partyId, playlistId, spotifyRefreshToken, spotifyAcessToken);
    }

    @Transactional
    public Party createParty(final String partyId, final String playlistId, final String spotifyRefreshToken, final String spotifyAcessToken) {
        final Party party = new Party();
        party.setPartyId(partyId);
        party.setPlaylistId(playlistId);
        party.setSpotifyRefreshToken(spotifyRefreshToken);
        party.setSpotifyAcessToken(spotifyAcessToken);
        party.setStartDate(LocalDateTime.now());
        return this.partyRepository.save(party);
    }

    @Transactional
    public Optional<Party> refreshToken(final String partyId) {
        Optional<Party> party = this.partyRepository.findPartyByPartyId(partyId);
        if (party.isPresent()) {
            RequestBody formBody = new FormBody.Builder()
                    .add("", "")
                    .build();

            Request request = new Request.Builder()
                    .url("")
                    .post(formBody)
                    .build();

            try (Response response = okHttpClient.newCall(request).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                String responseBody = response.body().string();
                


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return party;
    }

    @Transactional(readOnly = true)
    public List<Party> getAllParties(final int count) {
        return this.partyRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Party> getParty(final int id) {
        return this.partyRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Party> getPartyByPartyId(final String partyId) {
        return this.partyRepository.findPartyByPartyId(partyId);
    }

//    @Transactional(readOnly = true)
//    public Boolean partyExsistPartyByPartyId(final String partyId) {
//        return this.partyRepository.findPartyByPartyIdExists(partyId);
//    }
}
