package me.wonwoo.shrotener.repository;

import me.wonwoo.shrotener.domain.Sequence;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by wonwoo on 2016. 5. 5..
 */
public interface SequenceRepository extends ElasticsearchRepository<Sequence, String> {
}
