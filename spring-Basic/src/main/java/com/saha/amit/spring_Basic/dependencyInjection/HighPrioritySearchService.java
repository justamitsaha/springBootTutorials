package com.saha.amit.spring_Basic.dependencyInjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HighPrioritySearchService {
    private final SortingAlgorithm sortingAlgorithm;

    // Specifically asking for BubbleSort using @Qualifier
    public HighPrioritySearchService(@Qualifier("bubbleSort") SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public void executeSearch() {
        sortingAlgorithm.sort();
    }
}
