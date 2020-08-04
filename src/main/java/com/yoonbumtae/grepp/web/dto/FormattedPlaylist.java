package com.yoonbumtae.grepp.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
public class FormattedPlaylist {

    private Long id;
    private Long userId;
    private String title;
    private String albumTitle;
    private String songTitle;

    @Builder
    public FormattedPlaylist(Long id, Long userId, String title, String albumTitle, String songTitle) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.albumTitle = albumTitle;
        this.songTitle = songTitle;
    }
}
