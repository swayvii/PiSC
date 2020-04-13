package com.a1.housing.assignment1.controller;

import com.a1.housing.assignment1.model.Listing;
import com.a1.housing.assignment1.util.DateUtil;
import com.a1.housing.assignment1.util.HouselistUtil;
import com.a1.housing.assignment1.util.StatisticsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ListingsController {

    @Autowired
    List<Listing> listings;

    @GetMapping("/housing-statistics")
    public ResponseEntity statistic (@RequestParam(value = "statistic",required = true) String statistic, @RequestParam(value = "field",required = true) String field,
                                   @RequestParam(value = "startdate",required = false) String startDate,  @RequestParam(value = "enddate",required = false) String endDate,
                                   @RequestParam(value = "zipcode",required = false) Integer zipCode) {

        List<Listing> filteredHouseList = HouselistUtil.filterList(zipCode, DateUtil.parseDate(startDate), DateUtil.parseDate(endDate), listings);
        double houseList = StatisticsUtil.getStatistic(statistic, field, filteredHouseList);



        return new ResponseEntity(houseList, HttpStatus.OK);



    }
}
