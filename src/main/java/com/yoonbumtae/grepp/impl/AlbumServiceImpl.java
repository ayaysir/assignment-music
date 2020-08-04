package com.yoonbumtae.grepp.impl;

import com.yoonbumtae.grepp.dao.SongDAO;
import com.yoonbumtae.grepp.service.AlbumService;
import com.yoonbumtae.grepp.web.dto.Album;
import com.yoonbumtae.grepp.web.dto.SimpleSong;
import com.yoonbumtae.grepp.web.dto.Song;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@RequiredArgsConstructor
@Service
public class AlbumServiceImpl implements AlbumService {

    private final SongDAO songDAO;

    @Override
    public Long getAlbumTotalCount() {
        return songDAO.getAlbumTotalCount();
    }

    private List<Album> albumCollector(List<Song> songs) {
        Map<Long, List<Song>> map = songs.stream().collect(groupingBy(Song::getAlbumId));

        return map.keySet().stream().map(x -> {
            Map<String, Object> innerMap = new HashMap<>();
            Song song = map.get(x).get(0);
            return Album.builder()
                    .id(x)
                    .albumTitle(song.getAlbumTitle())
                    .locale(song.getLocale())
                    .songs(map.get(x).stream().map(y -> {
                        return SimpleSong.builder()
                                .length(y.getLength())
                                .title(y.getTitle())
                                .track(y.getTrack())
                                .build();
                    }).collect(Collectors.toList()))
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public List<Album> findAll() {
        return albumCollector(songDAO.findAll());
    }

    @Override
    public Map<String, List<Album>> findByAlbumTitleAndLocale(String keyword, String locale) {
        List<Album> albums = albumCollector(songDAO.findByAlbumTitleAndLocale(keyword, locale));
        List<Album> songs = albumCollector(songDAO.findBySongTitleAndLocale(keyword, locale));

        Map<String, List<Album>> map = new HashMap<>();
        map.put("albums", albums);
        map.put("songs", songs);

        return map;
    }

    @Override
    public List<Album> findAllByPaging(String locale, Integer offset, Integer count) {
        return albumCollector(songDAO.findAllByPaging(locale, offset, count));
    }
}
