
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bbreak.excella.reports.exporter.ExcelExporter;
import org.bbreak.excella.reports.model.ReportBook;
import org.bbreak.excella.reports.model.ReportSheet;
import org.bbreak.excella.reports.processor.ReportProcessor;
import org.bbreak.excella.reports.tag.SingleParamParser;


public class TestExcella {

    public static void main(String[] args) throws Exception {
    	
    	// テストデータの準備
    	List<Person> personList = new ArrayList<Person>();
    	personList.add(new Person("A","M",new BigDecimal(10)));
    	personList.add(new Person("B","F",new BigDecimal(20)));
    	personList.add(new Person("C","M",new BigDecimal(30)));
    	personList.add(new Person("D","M",new BigDecimal(40)));
    	personList.add(new Person("E","M",new BigDecimal(50)));
    	
    	List<List<Object>> dataList = new ArrayList<List<Object>>();
    	for (Person p:personList) {
    		List<Object> tmpList = new ArrayList<Object>();
    		tmpList.add(p.getName());
    		tmpList.add(p.getGender());
    		tmpList.add(p.getAge());
    		dataList.add(tmpList);
    	}

    	
    	ReportBook outputBook = new ReportBook("src/main/resources/templates/template02.xlsx", "./out", ExcelExporter.FORMAT_TYPE);

        ReportSheet outputSheet = new ReportSheet("report");

        int data = 1;
        outputSheet.addParam(SingleParamParser.DEFAULT_TAG, "DATA1", data);

        outputBook.addReportSheet(outputSheet);

        ReportProcessor reportProcessor = new ReportProcessor();
        try {
          reportProcessor.process(outputBook);
        } catch (Exception e) {
          e.printStackTrace();
        }

    }

}

