package com.zaychikov.tests;

import org.junit.jupiter.api.Test;

public class AnnotationStepTest {

    private final String Url = "https://github.com";
    private final String Repository = "Prog163/tests_with_allure";

    @Test
    public void issueSearchTestInGithubWithAnnotationSteps() {

        StepsForAnnotationStepTest steps = new StepsForAnnotationStepTest();
        steps.openWebsiteUrl(Url);
        steps.searchRepository(Repository);
        steps.openRepository(Repository);
        steps.checkColumnNameIssue();
    }
}
