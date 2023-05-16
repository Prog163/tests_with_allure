package com.zaychikov.tests;

import org.junit.jupiter.api.Test;

public class AnnotationStepTest {

    private final String Url = "https://github.com";
    private final String Directory = "Prog163/tests_with_allure";

    @Test
    public void issueSearchTestInGithubWithAnnotationSteps() {

        StepsForAnnotationStepTest steps = new StepsForAnnotationStepTest();
        steps.openWebsiteUrl(Url);
        steps.searchRepository(Directory);
        steps.openRepository(Directory);
        steps.checkColumnNameIssue();
    }
}
