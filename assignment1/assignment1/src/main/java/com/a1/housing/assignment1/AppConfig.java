package com.a1.housing.assignment1;
import com.a1.housing.assignment1.model.Listing;
import com.a1.housing.assignment1.util.DateUtil;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Listing> listings(){
    List<Listing> listings = new ArrayList<>();
        Reader in = null;
        try {
            File file = ResourceUtils.getFile("classpath:real-estate-data.csv");

            in = new FileReader(file);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
            for (CSVRecord record : records) {

                listings.add(Listing.builder().latitude(Float.parseFloat(record.get("latitude")))
                .longitude(Float.parseFloat(record.get("longitude")))
                .price(Double.parseDouble(record.get("price")))
                .state(record.get("state"))
                .date(DateUtil.parseDate(record.get("sale_date")))
                .type(record.get("type"))
                .baths(Integer.parseInt(record.get("baths")))
                .beds(Integer.parseInt(record.get("beds")))
                .city(record.get("city"))
                .sqFt(Integer.parseInt(record.get("sq__ft")))
                .street(record.get("street"))
                .zip(Integer.parseInt(record.get("zip"))).build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listings;
    }



}
