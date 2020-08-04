package com.yoonbumtae.grepp.service;

import com.yoonbumtae.grepp.web.dto.Song;

import java.util.List;
import java.util.Map;

public interface AlbumService {
    List<Song> findAll();
    Map<String, List<Song>> findByAlbumTitleAndLocale(String keyword, String locale);
    Long getAlbumTotalCount();
    List<Song> findAllByPaging(String locale, Integer offset, Integer count);
}
