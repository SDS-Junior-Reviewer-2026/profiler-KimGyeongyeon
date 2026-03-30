package org.example;

import org.example.sortlib.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Profiler {
    private ArrayList<Integer> inputData;
    private ArrayList<Integer> resultData;
    private Sort sort;
    private HashMap<String, Integer> lastResult = new HashMap<>();

    private void initResult() {
        resultData = null;
        lastResult = new HashMap<>();
    }

    void setData(ArrayList<Integer> data) {
        this.inputData = data;
        initResult();
    }

    void setLib(Sort sort) {
        this.sort = sort;
        initResult();
    }

    private boolean isReadyToRun() {
        return inputData != null && sort != null;
    }

    void runLib() {
        if (!isReadyToRun()) {
            System.out.println("setData, setLib을 완료했는지 확인하세요");
            return;
        }
        resultData = new ArrayList<>(inputData);
        int swapCnt = this.sort.sort(this.resultData);
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
            sb.append("입력데이터 : [");
            sb.append(String.join(",", this.inputData.stream().map(String::valueOf).collect(Collectors.toList())));
            sb.append("]\n");
            sb.append("정렬결과 : [");
            sb.append(String.join(",", this.resultData.stream().map(String::valueOf).collect(Collectors.toList())));
            sb.append("]\n");
            sb.append("swap횟수 : " + swap + "회");
            System.out.println(sb);
        }
    }
}
