package com.alphasoft.digitmapper.service;

import com.alphasoft.digitmapper.model.Digit;
import com.alphasoft.digitmapper.model.Mapping;
import com.alphasoft.digitmapper.repository.DigitRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DigitServiceImpl implements DigitService{

  private final DigitRepository digitRepository;

  @Override
  public List<Mapping> getDigitMappings(List<Integer> digits, String category) {
    return digits.stream().map(digit -> getSingleDigitMapping(digit, category)).toList();
  }

  private Mapping getSingleDigitMapping(Integer digit, String category) {
    Mapping mappedDigit = new Mapping();
    mappedDigit.setDivisor(digit);
    mappedDigit.setMappings(getMappingList(category, getListOfDivisors(digit)));
    return mappedDigit;
  }

  private List<String> getMappingList(String category, List<Integer> listOfDivisors) {
    return listOfDivisors.stream().map(divisor -> {
      Digit byDivisor = digitRepository.findByDivisorAndCategory(divisor, category).orElseThrow(
          () -> new RuntimeException("Cannot find mapping for given data"));
      return byDivisor.getMappedDivisor();
    }).toList();
  }

  private List<Integer> getListOfDivisors(int digit) {
    List<Integer> divisorList = new ArrayList<>();
    divisorList.add(1);
    for(int i=2;i<21 && i<(digit+1);i++) {
      if(digit % i == 0) {
        divisorList.add(i);
      }
    }
    return divisorList;
  }
}
