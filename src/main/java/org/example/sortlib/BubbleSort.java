package org.example.sortlib;

import java.util.ArrayList;

public class BubbleSort implements Sort {

    @Override
    public String getName() {
        return "BubbleSort";
    }

    @Override
    public int sort(ArrayList<Integer> nums) {
        int n = nums.size();
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // 🔥 뒤쪽은 이미 정렬됨
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums.get(j) > nums.get(j + 1)) {
                    // swap
                    int tmp = nums.get(j);
                    nums.set(j, nums.get(j + 1));
                    nums.set(j + 1, tmp);

                    swapCount++;
                    swapped = true;
                }
            }

            // 🔥 이미 정렬된 경우 조기 종료
            if (!swapped) break;
        }

        return swapCount;
    }
}