package tech.passtheaux.backend.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@Entity
public class Party implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "partyId", nullable = false)
    private String partyId;

    @Column(name = "playlistId", nullable = false)
    private String playlistId;

    @Column(name = "spotifyRefreshToken", nullable = false)
    private String spotifyRefreshToken;

    @Column(name = "spotifyAcessToken", nullable = false)
    private String spotifyAcessToken;

    @Column(name = "startDate", nullable = false)
    private LocalDateTime startDate;

    private transient String formattedStartDate;

    public String getFormattedStartDate() {
        return getStartDate().toString();
    }
}
