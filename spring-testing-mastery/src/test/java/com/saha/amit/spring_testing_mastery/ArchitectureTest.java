package com.saha.amit.spring_testing_mastery;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

/**
 * ARCHITECTURE TEST: ArchUnit.
 * Best Practice: Use to enforce coding standards and layered architecture rules
 * automatically during the build process.
 */
@AnalyzeClasses(packages = "com.saha.amit.spring_testing_mastery", importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchitectureTest {

    /**
     * Rule: Controllers should NOT access Repositories directly.
     * (They should go through a Service layer - though we skipped it for this demo, 
     * this test would fail if we enabled it, proving the point!)
     */
    @ArchTest
    static final ArchRule controllers_should_not_access_repositories = 
        noClasses().that().resideInAPackage("..controller..")
        .should().accessClassesThat().resideInAPackage("..repository..");
}
