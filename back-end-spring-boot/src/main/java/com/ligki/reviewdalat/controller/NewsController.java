package com.ligki.reviewdalat.controller;

import com.ligki.reviewdalat.service.NewsShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController extends BaseController {

    @Autowired
    NewsShareService newsShareService;

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestNews() {
        return handleResponse(newsShareService.getLatestNews());
    }

    @GetMapping("/detail/{newsId}")
    public ResponseEntity<?> getNewsDetail(@PathVariable("newsId") String newsId) {
        return handleResponse(newsShareService.getNewsDetail(newsId));
    }
}
