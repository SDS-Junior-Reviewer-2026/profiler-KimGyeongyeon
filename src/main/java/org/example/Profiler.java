package org.example;

import org.example.sortlib.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Profiler {
    private ArrayList<Integer> data;
    private Sort sort;
    private HashMap<String, Integer> lastResult = new HashMap<>();

    private void initResult() {
        lastResult = new HashMap<>();
    }

    void setData(ArrayList<Integer> data) {
        this.data = data;
        initResult();
    }

    void setLib(Sort sort) {
        this.sort = sort;
        initResult();
    }

    private boolean isReadyToRun() {
        return data != null && sort != null;
    }

    void runLib() {
        if (!isReadyToRun()) {
            System.out.println("setData, setLib을 완료했는지 확인하세요");
            return;
        }
        int swapCnt = this.sort.sort(this.data);
        lastResult.put(this.sort.getName(), swapCnt);
    }

    private boolean isReadyToShow() {
        return !lastResult.isEmpty();
    }

    void showResult() {
        if (!isReadyToShow()) {
            System.out.println("runLib을 완료했는지 확인하세요");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String name : lastResult.keySet()) {
            int swap = lastResult.get(name);
            sb.append("------------------------------\n💫 ");
            sb.append(name);
            sb.append(" 테스트 💫\n");
            sb.append("정렬결과 : [");
            sb.append(String.join(",", this.data.stream().map(String::valueOf).collect(Collectors.toList())));
            sb.append("]\n");
            sb.append("swap횟수 : " + swap + "회");
            System.out.println(sb);
        }
    }
}
