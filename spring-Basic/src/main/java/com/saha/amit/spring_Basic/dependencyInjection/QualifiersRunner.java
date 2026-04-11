package com.saha.amit.spring_Basic.dependencyInjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * RUNNER: Dependency Injection & Resolution.
 */
@ComponentScan(basePackages = "com.saha.amit.spring_Basic.dependencyInjection")
public class QualifiersRunner {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QualifiersRunner.class, args);

        System.out.println("--------------------------------------------------");
        System.out.println("2. Resolution Strategy (@Primary vs @Qualifier)");
        System.out.println("Default (@Primary):");
        context.getBean(SearchService.class).executeSearch();

        System.out.println("Specific (@Qualifier):");
        context.getBean(HighPrioritySearchService.class).executeSearch();
        System.out.println("--------------------------------------------------");

    }

    @Component
    static class SearchService {
        private final SortingAlgorithm sortingAlgorithm;

        // By default, Spring will inject QuickSort because it is @Primary
        public SearchService(SortingAlgorithm sortingAlgorithm) {
            this.sortingAlgorithm = sortingAlgorithm;
        }

        public void executeSearch() {
            sortingAlgorithm.sort();
        }
    }

    interface SortingAlgorithm {
        void sort();
    }

    /**
     * PRIMARY: If multiple beans are available, use this one by default.
     */
    @Component
    @Primary
    static class QuickSort implements SortingAlgorithm {
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
    static class BubbleSort implements SortingAlgorithm {
        @Override
        public void sort() {
            System.out.println("Sorting using BubbleSort (Qualifier)...");
        }
    }

    @Component
    static class HighPrioritySearchService {
        private final SortingAlgorithm sortingAlgorithm;

        // Specifically asking for BubbleSort using @Qualifier
        public HighPrioritySearchService(@Qualifier("bubbleSort") SortingAlgorithm sortingAlgorithm) {
            this.sortingAlgorithm = sortingAlgorithm;
        }

        public void executeSearch() {
            sortingAlgorithm.sort();
        }
    }

}
