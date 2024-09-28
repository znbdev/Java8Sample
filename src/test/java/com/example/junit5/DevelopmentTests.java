package com.example.junit5;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;

@SelectPackages("com.howtodoinjava.junit5.examples")
@IncludeTags("development")
public class DevelopmentTests 
{
}
