package com.example.junit5;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;

@SelectPackages("com.example.junit5")
@IncludeTags("development")
public class DevelopmentTests 
{
}
