package com.example.junit5.suites;

import com.example.junit5.TempDirTests;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses(TempDirTests.class)
public class TempDirectoryTestSuite {

}
