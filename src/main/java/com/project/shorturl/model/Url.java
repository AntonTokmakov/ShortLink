package com.project.shorturl.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "urls", indexes = @Index(name = "idx_short_url", columnList = "short_url"))
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @URL
    @Column(nullable = false, unique = true)
    private String longUrl;
    @NotNull
    @Column(nullable = false, unique = true)
    private String shortUrl;
    @Column(nullable = false)
    private LocalDateTime dateTime;

    public Url(String longUrl, String shortUrl) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }
}
