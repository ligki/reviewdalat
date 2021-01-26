package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.model.responsetype.NewsDetail;
import com.ligki.reviewdalat.model.responsetype.LatestNews;

import java.util.List;

public interface NewsShareService {
    List<LatestNews> getLatestNews(String page);

    NewsDetail getNewsDetail(String newsId);
}
