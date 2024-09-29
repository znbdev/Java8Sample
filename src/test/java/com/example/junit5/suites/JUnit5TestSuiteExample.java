package com.example.junit5.suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages({"com.example.junit5.packageA"
				,"com.example.junit5.packageB"})
@Suite
@SuiteDisplayName("A demo Test Suite")
public class JUnit5TestSuiteExample {

}
