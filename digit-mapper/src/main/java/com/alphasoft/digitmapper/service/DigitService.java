package com.alphasoft.digitmapper.service;

import com.alphasoft.digitmapper.model.Mapping;
import java.util.List;

public interface DigitService {

  List<Mapping> getDigitMappings(List<Integer> digit, String category);

}
