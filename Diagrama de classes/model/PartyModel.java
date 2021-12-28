package com.findsquad.api.FindSquad_API.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "party")
public class PartyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_create_id", nullable = false)
    private Long userCreateId;

    @Column(name = "game_id", nullable = false)
    private Long gameId;

    @Column(nullable = false)
    private String description;

    @Column(name = "qtd_players", nullable = false)
    private Long playersQtd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserCreateId() {
        return userCreateId;
    }

    public void setUserCreateId(Long userCreateId) {
        this.userCreateId = userCreateId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPlayersQtd() {
        return playersQtd;
    }

    public void setPlayersQtd(Long playersQtd) {
        this.playersQtd = playersQtd;
    }
}
