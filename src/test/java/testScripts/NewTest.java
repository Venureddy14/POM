package testScripts;

import org.testng.annotations.Test;

import configfile.ExcelWriter;

public class NewTest {
  @Test
  public void f() {
	ExcelWriter.WriteToExcel(0, 0, 2, "value");
	ExcelWriter.WriteToExcel(0, 1, 2, "value");
	ExcelWriter.WriteToExcel(0, 2, 2, "value");
	ExcelWriter.WriteToExcel(0, 3, 2, "value");
  }
}
