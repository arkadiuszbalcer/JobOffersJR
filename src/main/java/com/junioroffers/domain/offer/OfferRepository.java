package com.junioroffers.domain.offer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends MongoRepository<Offer, String> {
    boolean existsByOfferUrl(String offerUrl);

    Optional<Offer> findById(String id);

    boolean existsById(String s);

    <S extends Offer> S save(S entity);

    List<Offer> findAllById(Iterable<String> strings);

    long count();

    void deleteById(String s);

    void delete(Offer entity);

    void deleteAllById(Iterable<? extends String> strings);

    void deleteAll(Iterable<? extends Offer> entities);

    void deleteAll();
}
