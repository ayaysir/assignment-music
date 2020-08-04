package com.yoonbumtae.grepp.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
public class PlaylistRaw {
    private Long id;
    private Long userId;
    private String title;

    // list-songs
    private Long songId;

    @Builder
    public PlaylistRaw(Long id, Long userId, String title, Long songId) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.songId = songId;
    }
}
