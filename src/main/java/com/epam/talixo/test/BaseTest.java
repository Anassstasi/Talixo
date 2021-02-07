package com.epam.talixo.test;

import com.epam.talixo.test.rules.CustomTestRule;
import org.junit.Rule;

public class BaseTest {

    @Rule
    public CustomTestRule customTestRule = new CustomTestRule();
}