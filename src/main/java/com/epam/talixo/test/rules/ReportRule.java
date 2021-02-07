package com.epam.talixo.test.rules;

import com.epam.talixo.test.report.ExtentManager;
import org.junit.rules.ExternalResource;

public class ReportRule extends ExternalResource {

    private String testClassName;

    public ReportRule(String testClassName) {
        this.testClassName = testClassName;
    }

    private String getTestClassName() {
        return testClassName;
    }

    @Override
    protected void before() {
        ExtentManager.createParentTestInstance(getTestClassName());
    }

}