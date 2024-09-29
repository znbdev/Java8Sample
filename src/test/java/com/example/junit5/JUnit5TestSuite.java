package com.example.junit5;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;

@SelectPackages("com.example.junit5")
@IncludePackages("com.example.junit5.packageC")
@ExcludeTags("PROD")
public class JUnit5TestSuite {

}
