package com.saha.amit.spring_Basic.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

interface SortingAlgorithm {
    void sort();
}

/**
 * PRIMARY: If multiple beans are available, use this one by default.
 */
@Component
@Primary
class QuickSort implements SortingAlgorithm {
    @Override
    public void sort() {
        System.out.println("Sorting using QuickSort (Primary)...");
    }
}

/**
 * QUALIFIER: Specifically named for injection.
 */
@Component
@Qualifier("bubbleSort")
class BubbleSort implements SortingAlgorithm {
    @Override
    public void sort() {
        System.out.println("Sorting using BubbleSort (Qualifier)...");
    }
}
