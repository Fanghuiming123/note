# jQueryのAjaxを使って外部HTMLの一部を抜き出し挿入する

[参考内容](https://qiita.com/yumetodo/items/00b37234cb86e741f0fb)  

- javascriptに、window.openメソッドの代わりに、ajaxメソッドを使って、子画面が出ないように、親画面の一部分のみ更新できる。  
*レスポンスはHTMLである場合、parseHTMLによる変更する。*

```html 
index.html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="utf-8">
        <title>jQueryのAjaxを使って外部HTMLの一部を抜き出し挿入する</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
     	<script th:src="@{/js/load.js}"></script>
    </head>
    <body>
    <form id="newform">
        <h1>ここに外部 HTML ファイルを表示します</h1>
        <div id="page">dst</div>
        <div id="page2">dst</div>
        <input type="button" id="changebtn" value="変更" />
        </form>
    </body>
</html>
```

```html  
external.html

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>external-ありきたりとは</title>
</head>
<body>
    <div id="sub">
        <h2>外部ファイル</h2>
        <p>この文章は external.html に記載された外部 HTML の文章です</p>
    </div>
    <div id="sub2">
        <h2>外部ファイル</h2>
        <p>これはありきたりな文章です</p>
    </div>
</body>
</html>
```

```javascript
load.js

$(document).ready(function(){
	$('#changebtn').click(function(){
		    $.ajax('external', {
		        timeout : 1000, // 1000 ms
		        datatype:'html'
		    }).then(function(data){
		        var out_html = $($.parseHTML(data));//parse
		        $('#page').empty().append(out_html.filter('#sub')[0].innerHTML);//insert
		        $('#page2').empty().append(out_html.filter('#sub2')[0].innerHTML);//insert
		        //var sub_html = out_html.filter(function(index) {
		        //    return $(this).attr("id") === "sub";
		        //})[0].innerHTML;//extract
		        //var sub2_html = out_html.filter(function(index) {
		        //    return $(this).attr("id") === "sub2";
		        //})[0].innerHTML;//extract
		        //$('#page').empty().append(sub_html);//insert
		        //$('#page2').empty().append(sub2_html);//insert
		    },function(jqXHR, textStatus) {
		        if(textStatus!=="success") {
		            var txt = "<p>textStatus:"+ textStatus + "</p>" +
		                "<p>status:"+ jqXHR.status + "</p>" +
		                "<p>responseText : </p><div>" + jqXHR.responseText +
		                "</div>";
		            $('#page').html(txt);
		            $('#page2').html(txt);
		        }
		    });
		    // $('#page').load('external.html');
		
        });
});
//$(function() {
//    $.ajax('external', {
//        timeout : 1000, // 1000 ms
//        datatype:'html'
//    }).then(function(data){
//        var out_html = $($.parseHTML(data));//parse
//        $('#page').empty().append(out_html.filter('#sub')[0].innerHTML);//insert
//        $('#page2').empty().append(out_html.filter('#sub2')[0].innerHTML);//insert
//        //var sub_html = out_html.filter(function(index) {
//        //    return $(this).attr("id") === "sub";
//        //})[0].innerHTML;//extract
//        //var sub2_html = out_html.filter(function(index) {
//        //    return $(this).attr("id") === "sub2";
//        //})[0].innerHTML;//extract
//        //$('#page').empty().append(sub_html);//insert
//        //$('#page2').empty().append(sub2_html);//insert
//    },function(jqXHR, textStatus) {
//        if(textStatus!=="success") {
//            var txt = "<p>textStatus:"+ textStatus + "</p>" +
//                "<p>status:"+ jqXHR.status + "</p>" +
//                "<p>responseText : </p><div>" + jqXHR.responseText +
//                "</div>";
//            $('#page').html(txt);
//            $('#page2').html(txt);
//        }
//    });
//    // $('#page').load('external.html');
//});

```