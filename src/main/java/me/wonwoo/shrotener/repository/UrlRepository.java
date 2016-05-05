package me.wonwoo.shrotener.repository;

import me.wonwoo.shrotener.domain.Url;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by wonwoo on 2016. 5. 5..
 */
public interface UrlRepository extends ElasticsearchRepository<Url, String> {
}
