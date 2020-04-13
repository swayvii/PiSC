package com.a1.housing.assignment1.util;

import com.a1.housing.assignment1.model.Listing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HouselistUtil {
    public static List<Listing> filterList(Integer zipcode, Date startDate, Date endDate, List<Listing> houseList) {
        List<Listing> filteredList = new ArrayList<>();

        if(zipcode != null){
           filteredList = filterByZipCode(zipcode, houseList);
        }
        if(startDate !=null){
            filteredList = filterHouseListByStartDate(startDate,houseList);
        }
        if(endDate!=null){
            filteredList = filterHouseListByEndDate(endDate, houseList);
        }

        return filteredList;
    }

    public static List<Listing> filterHouseListByStartDate(Date startDate, List<Listing> houseList) {
        List<Listing> filteredList = new ArrayList<>();

        for (int i = 0; i < houseList.size(); i++) {

            Date houseDate = houseList.get(i).getDate();
            if ((houseDate.compareTo(startDate) > 0) || houseDate.compareTo(startDate) == 0) {

                filteredList.add(houseList.get(i));

            }

        }
        return filteredList;
    }

    public static List<Listing> filterHouseListByEndDate(Date endDate, List<Listing> houseList) {
        List<Listing> filteredList = new ArrayList<>();

        for (int i = 0; i < houseList.size(); i++) {

            Date houseDate = houseList.get(i).getDate();
            if ((houseDate.compareTo(endDate) < 0) || houseDate.compareTo(endDate) == 0) {

                filteredList.add(houseList.get(i));
            }

        }
        return filteredList;
    }

    public static List<Listing> filterByZipCode(Integer zipcode, List<Listing> houseList) {
        List<Listing> filteredList = new ArrayList<>();

        for (int i = 0; i < houseList.size(); i++) {

            Date houseDate = houseList.get(i).getDate();

            if (houseList.get(i).getZip().equals(zipcode)) {
                filteredList.add(houseList.get(i));
            }


        }
        return filteredList;

    }
}
