package org.example;

import org.example.sortlib.BubbleSort;
import org.example.sortlib.SelectionSort;
import org.example.sortlib.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Profiler p = new Profiler();
        // Main에 Sort 생성책임 부여
        List<Sort> sortList = Arrays.asList(
                new BubbleSort(),
                new SelectionSort()
        );
        // 시작
        for (Sort sort: sortList){
            p.setData(new ArrayList<>(Arrays.asList(5,1,2,3,4)));
            p.setLib(sort);
            p.runLib();
            p.showResult();
        }
    }
}