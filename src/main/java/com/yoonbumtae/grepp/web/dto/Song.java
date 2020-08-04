package com.yoonbumtae.grepp.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class Song {

    private Long albumId;
    private String albumTitle;
    private List<String> locale;
    private Long songId;
    private Long length;
    private String title;
    private Integer track;

    @Builder
    public Song(Long albumId, String albumTitle, List<String> locale,
                Long songId, Long length, String title, Integer track) {
        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.locale = locale;
        this.songId = songId;
        this.length = length;
        this.title = title;
        this.track = track;
    }
}
