package com.yoonbumtae.grepp.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@ToString
@Getter
public class Album {

    private Long id;
    private String albumTitle;
    private List<String> locale;
    private List<Song> songs;

    @Builder
    public Album(Long id, String albumTitle, List<String> locale, List<Song> songs) {
        this.id = id;
        this.albumTitle = albumTitle;
        this.locale = locale;
        this.songs = songs;
    }
}
