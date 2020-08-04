package com.yoonbumtae.grepp.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class SimpleSong {

    private Long length;
    private String title;
    private Integer track;

    @Builder
    public SimpleSong(Long length, String title, Integer track) {
        this.length = length;
        this.title = title;
        this.track = track;
    }
}
