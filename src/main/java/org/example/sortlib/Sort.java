package org.example.sortlib;

import java.util.ArrayList;

public interface Sort {
    String getName();
    int sort(ArrayList<Integer> nums); // return : swap 횟수
}
