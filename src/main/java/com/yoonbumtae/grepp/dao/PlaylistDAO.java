package com.yoonbumtae.grepp.dao;

import com.yoonbumtae.grepp.web.dto.FormattedPlaylist;
import com.yoonbumtae.grepp.web.dto.PlaylistRaw;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PlaylistDAO {

    private final JdbcTemplate jdbcTemplate;

    public List<PlaylistRaw> findAll() {
        String sql = "select * from playlist";

        return jdbcTemplate.query(sql, (rs, rowNum) -> PlaylistRaw.builder()
                .id(rs.getLong("id"))
                .userId(rs.getLong("user_id"))
                .title(rs.getString("title"))
                .songId(rs.getLong("song_id"))
                .build());
    }

    public Integer createPlaylist(Long userId, String listTitle) {
        String sql = "insert into playlist (user_id, title) values (?, ?)";

        return jdbcTemplate.update(sql, userId, listTitle);
    }

    public Integer deletePlaylist(Long userId, Long playlistId) {
        String sql = "delete from playlist where user_id = ? and id = ?";

        return jdbcTemplate.update(sql, userId, playlistId);
    }

    public Integer putPlaylistBySong(Long userId, Long playlistId, Long songId) {
        String sql = "insert into playlist_songs(playlist_id, song_id) values (?, ?)";

        return jdbcTemplate.update(sql, playlistId, songId);
    }

    public Integer putPlaylistByAlbum(Long userId, long playlistId, Long albumId) {
        String sql = "insert into playlist_songs(playlist_id, song_id) " +
                "select ?, id from song where album_id = ?";

        return jdbcTemplate.update(sql, playlistId, albumId);
    }

    public List<PlaylistRaw> findListByUserId(Long userId) {
        String sql = "select * from playlist where user_id = ?";

        return jdbcTemplate.query(sql, new Object[] {userId}, (rs, rowNum) -> PlaylistRaw.builder()
                .id(rs.getLong("id"))
                .userId(rs.getLong("user_id"))
                .title(rs.getString("title"))
                .build());
    }


}
