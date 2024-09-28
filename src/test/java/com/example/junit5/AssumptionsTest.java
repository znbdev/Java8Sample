package com.example.junit5;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class AssumptionsTest {

  @Test
  void testOnDev() {
    System.setProperty("ENV", "DEV");
    Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")), AssumptionsTest::message);
  }

  @Test
  void testOnProd() {
    System.setProperty("ENV", "PROD");
    Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")));
  }

  private static String message() {
    return "TEST Execution Failed :: ";
  }
}
