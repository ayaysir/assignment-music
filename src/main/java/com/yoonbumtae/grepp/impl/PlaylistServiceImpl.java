package com.yoonbumtae.grepp.impl;

import com.yoonbumtae.grepp.dao.PlaylistDAO;
import com.yoonbumtae.grepp.service.PlaylistService;
import com.yoonbumtae.grepp.web.dto.PlaylistRaw;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistDAO playlistDAO;

    @Override
    public Integer createPlaylist(Long userId, String title) {
        return playlistDAO.createPlaylist(userId, title);
    }

    @Override
    public Integer deletePlaylist(Long userId, Long playlistId) {
        return playlistDAO.deletePlaylist(userId, playlistId);
    }

    @Override
    public Integer putPlaylistBySong(Long userId, Long playlistId, Long songId) {
        return playlistDAO.putPlaylistBySong(userId, playlistId, songId);
    }

    @Override
    public Integer putPlaylistByAlbum(Long userId, Long playlistId, Long albumId) {
        return playlistDAO.putPlaylistByAlbum(userId, playlistId, albumId);
    }

    @Override
    public List<PlaylistRaw> findListByUserId(Long userId) {
        return playlistDAO.findListByUserId(userId);
    }
}
