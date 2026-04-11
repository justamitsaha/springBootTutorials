package com.saha.amit.spring_Basic.di;

import org.springframework.stereotype.Component;

@Component
public class SearchService {
    private final SortingAlgorithm sortingAlgorithm;

    // By default, Spring will inject QuickSort because it is @Primary
    public SearchService(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public void executeSearch() {
        sortingAlgorithm.sort();
    }
}
