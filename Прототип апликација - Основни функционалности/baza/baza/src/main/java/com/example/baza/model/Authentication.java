package com.example.baza.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "authentication", schema = "project")
public class Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id", nullable = false)
    private Integer id;

    @Column(name = "timestamp_log", nullable = false)
    private Instant timestampLog;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_chovek", nullable = false)
    private Chovek2 chovek;

    public Chovek2 getChovek() {
        return chovek;
    }

    public void setChovek(Chovek2 chovek) {
        this.chovek = chovek;
    }

    public Instant getTimestampLog() {
        return timestampLog;
    }

    public void setTimestampLog(Instant timestampLog) {
        this.timestampLog = timestampLog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}