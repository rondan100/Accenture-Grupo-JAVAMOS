package com.accenture.javamos.converter.configuration;

import com.accenture.javamos.converter.FlightDateConverter;
import com.accenture.javamos.converter.FlightSegmentConverter;
import com.accenture.javamos.entity.FlightSegment;
import com.amadeus.resources.FlightOfferSearch.SearchSegment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class FlightSegmentConverterConfiguration {

  @Bean
  public Converter<SearchSegment, FlightSegment> configFlightSegmentConverter(
    @Autowired FlightDateConverter dateConverter
  ) {
    return new FlightSegmentConverter(dateConverter);
  }
}
