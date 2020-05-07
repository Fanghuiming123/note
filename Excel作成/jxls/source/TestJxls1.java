
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jxls.area.Area;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;
import org.jxls.util.TransformerFactory;

public class TestJxls1 {

    public static void main(String[] args) throws Exception {
    	
    	// テストデータの準備
    	List<Person> personList = new ArrayList<Person>();
    	personList.add(new Person("A","M",new BigDecimal(10)));
    	personList.add(new Person("B","F",new BigDecimal(20)));
    	personList.add(new Person("C","M",new BigDecimal(30)));
    	
    	List<List<Object>> dataList = new ArrayList<List<Object>>();
    	for (Person p:personList) {
    		List<Object> tmpList = new ArrayList<Object>();
    		tmpList.add(p.getName());
    		tmpList.add(p.getGender());
    		tmpList.add(p.getAge());
    		dataList.add(tmpList);
    	}

    	// テンプレート
        //InputStream is = TestJxls.class.getClass().getResourceAsStream("/templates/template01.xlsx");
        FileInputStream is = new FileInputStream(new File("src/main/resources/templates/template01.xlsx"));
        Context context = new Context();
        context.putVar("headers", Arrays.asList("Name" , "Gender" , "Age"));
        context.putVar("dataList", dataList);
        OutputStream os = new FileOutputStream(new File("C:\\temp\\result.xlsx"));
        // Excelファイルの生成
//        XlsCommentAreaBuilder.addCommandMapping("autoColumnWidth", AutoColumnWidthCommand.class);
        JxlsHelper.getInstance().processTemplate(is, os, context);
        os.flush();
        os.close();
        is.close();
    }

}

