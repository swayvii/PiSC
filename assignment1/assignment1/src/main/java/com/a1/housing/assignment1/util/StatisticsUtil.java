package com.a1.housing.assignment1.util;

import com.a1.housing.assignment1.model.Listing;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StatisticsUtil {
    public static double getStatistic(String statistic, String field, List<Listing> houseList) {
        if (statistic.equalsIgnoreCase("min")) {
            if (field.equalsIgnoreCase(("price"))) {
                Collections.sort(houseList, new HousePriceComparator());

                return houseList.get(0).getPrice();

            } else if (field.equalsIgnoreCase(("squareFootage"))) {
                Collections.sort(houseList, new HouseSqFtComparator());

                return houseList.get(0).getSqFt();
            }

        } else if (statistic.equalsIgnoreCase("max")) {
            if (field.equalsIgnoreCase(("price"))) {
                Collections.sort(houseList, new HousePriceComparator());
                Collections.reverse(houseList);

                return houseList.get(0).getPrice();

            } else if (field.equalsIgnoreCase(("squareFootage"))) {
                Collections.sort(houseList, new HouseSqFtComparator());
                Collections.reverse(houseList);

                return houseList.get(0).getSqFt();
            }

        }  else if (statistic.equalsIgnoreCase("avg")) {
            if (field.equalsIgnoreCase(("price"))) {
                int num = houseList.size();
                Listing list;
                double sum = 0;
                double avg = 0;
                for (int i = 0; i < houseList.size(); i++) {
                    list = houseList.get(i);
                    sum += list.getPrice();
                }
                avg = sum / houseList.size();
                return avg;
            } else if (field.equalsIgnoreCase(("squareFootage"))) {
                int num = houseList.size();
                Listing list;
                double sum = 0.0;
                double avg = 0.0;
                for (int i = 0; i < houseList.size(); i++) {
                    list = houseList.get(i);
                    sum += list.getSqFt();
                }
                avg = sum / houseList.size();
                return avg;
            }
        }else if (statistic.equalsIgnoreCase("sum")) {
            if (field.equalsIgnoreCase(("price"))) {
                int num = houseList.size();
                Listing list;
                double sum = 0;

                for (int i = 0; i < houseList.size(); i++) {
                    list = houseList.get(i);
                    sum += list.getPrice();
                }

                return sum;
            } else if (field.equalsIgnoreCase(("squareFootage"))) {
                int num = houseList.size();
                Listing list;
                double sum = 0.0;

                for (int i = 0; i < houseList.size(); i++) {
                    list = houseList.get(i);
                    sum += list.getSqFt();
                }

                return sum;
            }
        } else if (statistic.equalsIgnoreCase("range")) {

            if (field.equalsIgnoreCase(("price"))) {
                Collections.sort(houseList, new HousePriceComparator());

                double min = houseList.get(0).getPrice();

                Collections.sort(houseList, new HousePriceComparator());
                Collections.reverse(houseList);

                double max = houseList.get(0).getPrice();

                double range = max - min;
                return range;

            } else if (field.equalsIgnoreCase(("squareFootage"))) {
                Collections.sort(houseList, new HousePriceComparator());

                double min = houseList.get(0).getPrice();

                Collections.sort(houseList, new HousePriceComparator());
                Collections.reverse(houseList);

                double max = houseList.get(0).getPrice();

                double range = max - min;
                return range;
            }
        }

        return 0;
    }

}