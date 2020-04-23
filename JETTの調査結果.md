# JETTにセルのフォーマットを定義する方法

## jt:styleを利用する。

|  data-format   | 意味  |
|  :--:  | :--:  |
| '@'  | 文字列 |
| ''  | 標準 |

`isText` はbooleanの変数で、文字列か標準かコントロールできる。

``` html
<jt:style style="data-format: ${isText ? '@' : ''}">${num}</jt:style> 
```

※詳細は[JETTのサイト](http://jett.sourceforge.net/tags/style.html)に参考できる。
