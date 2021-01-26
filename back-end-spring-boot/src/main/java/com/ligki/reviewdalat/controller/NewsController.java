package com.ligki.reviewdalat.controller;

import com.ligki.reviewdalat.service.NewsShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController extends BaseController {

    @Autowired
    NewsShareService newsShareService;

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestNews(@RequestParam(value = "page", defaultValue = "1") String page) {
        return handleResponse(newsShareService.getLatestNews(page));
    }

    @GetMapping("/detail/{newsId}")
    public ResponseEntity<?> getNewsDetail(@PathVariable("newsId") String newsId) {
        return handleResponse(newsShareService.getNewsDetail(newsId));
    }
}
