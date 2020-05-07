## １、縦横の動的にデータの書き込み
**できる**  
jx:gridにより実現（サンプル(.\source\template01.xlsx)に参考）
## ２、表示パターンの設定
**できる**  
データのタイプ（Javaの対応BigDecimal,Stringなど）により、表示のスタイルをテンプレートで定義できる。
## ３、コラムの幅サイズの設定
**できる**  
カスタマイズのコマンドクラスを用意すれば、実現できる。  
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
		    <groupId>org.jxls</groupId>
		    <artifactId>jxls</artifactId>
		    <version>2.8.1</version>
		</dependency>
	    <dependency>
		    <groupId>org.jxls</groupId>
		    <artifactId>jxls-poi</artifactId>
		    <version>2.8.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
		<dependency>
		    <groupId>org.apache.poi</groupId>
		    <artifactId>poi</artifactId>
		    <version>4.1.0</version>
		</dependency>
```

