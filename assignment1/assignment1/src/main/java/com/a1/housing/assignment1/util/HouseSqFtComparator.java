package com.a1.housing.assignment1.util;

import com.a1.housing.assignment1.model.Listing;
import java.util.Comparator;

public class HouseSqFtComparator implements Comparator<Listing> {
    @Override
    public int compare(Listing listing1, Listing listing2) {
        return (int) (listing1.getSqFt() - listing2.getSqFt());

    }
}

