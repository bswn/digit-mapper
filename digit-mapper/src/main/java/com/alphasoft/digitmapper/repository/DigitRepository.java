package com.alphasoft.digitmapper.repository;

import com.alphasoft.digitmapper.model.Digit;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DigitRepository extends JpaRepository<Digit, Integer> {

  Optional<Digit> findByDivisorAndCategory(Integer divisor, String category);
}
