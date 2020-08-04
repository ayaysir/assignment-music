package com.yoonbumtae.grepp.web;

import com.yoonbumtae.grepp.service.AlbumService;
import com.yoonbumtae.grepp.web.dto.Album;
import com.yoonbumtae.grepp.web.dto.Song;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class CommonController {

    private final AlbumService albumService;

    private final Integer PAGING_NUM = 10;
    private final String API_URL = "https://SERVER_URL/api";

    @GetMapping("/")
    public String common() {
        return "OK";
    }

    @GetMapping("/all")
    public List<Album> searchAll() {
        return albumService.findAll();
    }


    @GetMapping("/search")
    public Map<String, List<Album>> searchByTitleAndLocale(String title, String locale) {
        return albumService.findByAlbumTitleAndLocale(title, locale);
    }

    @GetMapping("/albums")
    public Map<String, Object> searchByLocaleAndPaging(String locale, Integer page) {
        Long totalCount = albumService.getAlbumTotalCount();
        Integer totalPages = Math.toIntExact(totalCount / 10);
        Map<String, Object> map = new HashMap<>();

        map.put("statusCode", 200);

        // 1이 아니면 first, prev는 무조건 나와야 함
        if(page != 1) {
            map.put("first", API_URL + "/albums?page=1");
            map.put("prev", API_URL + "/albums?page=" + (page - 1));
        }
        // 1이 아니고 마지막 페이지도 아닌 경우
        if(page != totalPages) {
            map.put("next", API_URL + "/albums?page=" + (page + 1));
            map.put("last", API_URL + "/albums?page=" + totalPages);
        } // 마지막 페이지인 경우: next, last 표시 안함

        map.put("albums", albumService.findAllByPaging(locale, page, PAGING_NUM));
        return map;

    }
}
