package com.yoonbumtae.grepp.service;

import com.yoonbumtae.grepp.web.dto.PlaylistRaw;

import java.util.List;

public interface PlaylistService {

    Integer createPlaylist(Long userId, String title);
    Integer deletePlaylist(Long userId, Long playlistId);
    Integer putPlaylistBySong(Long userId, Long playlistId, Long songId);
    Integer putPlaylistByAlbum(Long userId, Long playlistId, Long albumId);
    List<PlaylistRaw> findListByUserId(Long userId);
}
