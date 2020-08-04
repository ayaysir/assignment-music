package com.yoonbumtae.grepp.service;

import com.yoonbumtae.grepp.web.dto.Album;
import com.yoonbumtae.grepp.web.dto.Song;

import java.util.List;
import java.util.Map;

public interface AlbumService {
    Long getAlbumTotalCount();

    List<Album> findAll();
    Map<String, List<Album>> findByAlbumTitleAndLocale(String keyword, String locale);
    List<Album> findAllByPaging(String locale, Integer offset, Integer count);

}
