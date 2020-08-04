package com.yoonbumtae.grepp.impl;

import com.yoonbumtae.grepp.dao.SongDAO;
import com.yoonbumtae.grepp.service.AlbumService;
import com.yoonbumtae.grepp.web.dto.Album;
import com.yoonbumtae.grepp.web.dto.Song;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AlbumServiceImpl implements AlbumService {

    private final SongDAO songDAO;

    @Override
    public List<Song> findAll() {
        return songDAO.findAll();
    }

    @Override
    public Map<String, List<Song>> findByAlbumTitleAndLocale(String keyword, String locale) {
        List<Song> albums = songDAO.findByAlbumTitleAndLocale(keyword, locale);
        List<Song> songs = songDAO.findBySongTitleAndLocale(keyword, locale);

        Map<String, List<Song>> map = new HashMap<>();
        map.put("albums", albums);
        map.put("songs", songs);

        return map;
    }

    @Override
    public Long getAlbumTotalCount() {
        return songDAO.getAlbumTotalCount();
    }

    @Override
    public List<Song> findAllByPaging(String locale, Integer offset, Integer count) {
        return songDAO.findAllByPaging(locale, offset, count);
    }
}
