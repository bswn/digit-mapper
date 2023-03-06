package com.alphasoft.digitmapper.controller;

import com.alphasoft.digitmapper.model.Mapping;
import com.alphasoft.digitmapper.service.DigitService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DigitController {

  private final DigitService digitService;

  @RequestMapping(method = RequestMethod.GET,
      value = "/digits/{category}",
  produces = "application/json")
  public ResponseEntity<List<Mapping>> mapper(@PathVariable String category, @RequestParam(name = "digits") List<Integer> digits) {
    return ResponseEntity.ok(digitService.getDigitMappings(digits, category));
  }

}
