package com.yoonbumtae.grepp.dao;

import com.yoonbumtae.grepp.web.dto.Song;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class SongDAO {

    private final JdbcTemplate jdbcTemplate;

    public List<Song> findAll() {
        String sql = "select a.id, a.album_title, a.locale, " +
                "s.id as song_id, s.length, s.title, s.track " +
                "from album a, song s " +
                "where a.id = s.album_id";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Song song = Song.builder()
                    .albumId(rs.getLong("id"))
                    .albumTitle(rs.getString("album_title"))
                    .locale(Arrays.asList(rs.getString("locale").split(",")))
                    .songId(rs.getLong("song_id"))
                    .title(rs.getString("title"))
                    .length(rs.getLong("length"))
                    .track(rs.getInt("track"))
                    .build();

            return song;
        });
    }

    public List<Song> findByAlbumTitleAndLocale(String keyword, String locale) {
        String sql = "select a.id, a.album_title, a.locale, " +
                "s.id as song_id, s.length, s.title, s.track " +
                "from album a, song s " +
                "where a.id = s.album_id " +
                "and a.album_title like ? " +
                "and a.locale like ?";

        String wrappedKeyword = "%" + keyword + "%";
        String wrappedLocale = "%" + locale + "%";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Song song = Song.builder()
                    .albumId(rs.getLong("id"))
                    .albumTitle(rs.getString("album_title"))
                    .locale(Arrays.asList(rs.getString("locale").split(",")))
                    .songId(rs.getLong("song_id"))
                    .title(rs.getString("title"))
                    .length(rs.getLong("length"))
                    .track(rs.getInt("track"))
                    .build();

            return song;
        }, wrappedKeyword, wrappedLocale);
    }

    public List<Song> findBySongTitleAndLocale(String keyword, String locale) {
        String sql = "select a.id, a.album_title, a.locale, " +
                "s.id as song_id, s.length, s.title, s.track " +
                "from album a, song s " +
                "where a.id = s.album_id " +
                "and s.title like ? " +
                "and a.locale like ?";

        String wrappedKeyword = "%" + keyword + "%";
        String wrappedLocale = "%" + locale + "%";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Song song = Song.builder()
                    .albumId(rs.getLong("id"))
                    .albumTitle(rs.getString("album_title"))
                    .locale(Arrays.asList(rs.getString("locale").split(",")))
                    .songId(rs.getLong("song_id"))
                    .title(rs.getString("title"))
                    .length(rs.getLong("length"))
                    .track(rs.getInt("track"))
                    .build();

            return song;
        }, wrappedKeyword, wrappedLocale);
    }

    public Long getAlbumTotalCount() {
        String sql = "select count(*) from album";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            return rs.getLong(1);
        });
    }

    public List<Song> findAllByPaging(String locale, Integer offset, Integer count) {
        String sql = "select a.id, a.album_title, a.locale, " +
                "s.id as song_id, s.length, s.title, s.track " +
                "from album a, song s " +
                "where a.id = s.album_id " +
                "and a.locale like ? " +
                "limit ?, ? ";

        String wrappedLocale = "%" + locale + "%";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Song song = Song.builder()
                    .albumId(rs.getLong("id"))
                    .albumTitle(rs.getString("album_title"))
                    .locale(Arrays.asList(rs.getString("locale").split(",")))
                    .songId(rs.getLong("song_id"))
                    .title(rs.getString("title"))
                    .length(rs.getLong("length"))
                    .track(rs.getInt("track"))
                    .build();

            return song;
        }, wrappedLocale, offset, count);
    }



}
