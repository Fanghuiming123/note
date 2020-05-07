## １、縦横の動的にデータの書き込み
**できる**  
ガイドにある、テストしてない
## ２、表示パターンの設定
**できる**  
クラスの作成が必要  
## ３、コラムの幅サイズの設定
**できる**  
クラスの作成が必要  
*  POIに、コラムの幅サイズがシートのautoSizeColumn(コラムのインデクス)メソッドによって設定する必要。    
*  各コラムに対する設定する形です。最後のコラムの確定方法は考え必要です。  
*  サンプルにはタイトルのリストのサイズによる確定方法です。  
## ４、処理のスピード
まだ確認してない、データ量が少ない場合、問題ないと思う。  
*スピードの疑問があるようである。*  
（想定データ量があれば、テストできる）

## ５、Mavenの設定
- pom.xml

```xml  
		<dependency>
		    <groupId>org.apache.poi</groupId>
		    <artifactId>poi</artifactId>
		    <version>4.1.0</version>
		</dependency>
		<dependency>
			<groupId>org.bbreak.excella</groupId>
		    <artifactId>excella-core</artifactId>
		    <version>2.0</version>
		</dependency>
		<dependency>
			<groupId>org.bbreak.excella</groupId>
		    <artifactId>excella-reports</artifactId>
			<version>2.0</version>
		</dependency>
		<dependency>
			<groupId>org.bbreak.excella</groupId>
		    <artifactId>excella-trans</artifactId>
		    <version>2.0</version>
		</dependency>
    </dependencies> 
    
    <repositories>
	    <repository>
		  <id>excella.bbreak.org</id>
	      <name>bBreak Systems Excella</name>
	      <url>http://excella-core.github.io/maven2/</url>    
	    </repository>
  	</repositories>

```


## ６、表示のカスタマイズのサンプル
サンプルのリンク [http://makky12.hatenablog.com/entry/2019/02/23/180726](http://makky12.hatenablog.com/entry/2019/02/23/180726)
```java
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.bbreak.excella.core.SheetData;
import org.bbreak.excella.core.SheetParser;
import org.bbreak.excella.core.exception.ParseException;
import org.bbreak.excella.reports.listener.ReportProcessListener;
import org.bbreak.excella.reports.model.ReportBook;
import org.bbreak.excella.reports.model.ReportSheet;
public class SheetFormatSetterimplements ReportProcessListener {
    public SheetFormatSetter() {
    }
    @Override
    public void postParse(Sheet sheet, SheetParser sheetParser, SheetData sheetData) throws ParseException {
        
        // WorkbookはsheetのgetWorkBook()メソッドから取得。
        Workbook wb = sheet.getWorkBook();
        CellStyle style = wb.createCellStyle();
        // 表示形式、フォントの設定
        DataFormat format = wb.createDataFormat();
        style.setDataFormat(format.getFormat("#,##0.###");       
       
        Font font = wb.createFont();
        font.setFontName("ＭＳ 明朝");
        font.setFontHeightInPoints((short)10);
        style.setFont(font);
        // 縦横位置＆上枠線の設定
        style.setAlignment(Cellstyle.ALIGN_RIGHT);
        style.setVerticalAlignment(Cellstyle.VERTICAL_CENTER); 
        style.setBorderTop(CellStyle.BORDER_THICK);
       
        // 対象セル(A1)を取得し、スタイルを設定
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        cell.setCellStyle(style);
    
        return;
    }
}
```
