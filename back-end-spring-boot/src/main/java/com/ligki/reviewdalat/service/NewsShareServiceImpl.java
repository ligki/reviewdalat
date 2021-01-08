package com.ligki.reviewdalat.service;

import com.ligki.reviewdalat.model.entity.NewsShare;
import com.ligki.reviewdalat.model.responsetype.LatestNews;
import com.ligki.reviewdalat.reposiroty.NewsShareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsShareServiceImpl extends BaseService implements NewsShareService{

    @Autowired
    NewsShareRepository newsShareRepository;

    @Override
    public List<LatestNews> getLatestNews() {
        return newsShareRepository.findTop10ByOrderByCreatedAsc()
                .stream()
                .map(newsShare -> dozerBeanMapper.map(newsShare, LatestNews.class))
                .collect(Collectors.toList());
    }
}
