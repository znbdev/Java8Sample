package com.example.junit5;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.howtodoinjava.junit5.examples.packageA")
@IncludeTags("production")
public class ProductionTests 
{
}