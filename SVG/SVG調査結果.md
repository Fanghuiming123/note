SVGの場合、動的にcontentを指定できなくて、Hover（マウス範囲に移動の動作）のstyleに、fillを指定すればOKです。  

SVGに、styleとして、classまた行内styleを指定できる。  

以下の例が参考できる。

```css
body {
  background-color: gray;
}
svg {
  height: 50vh;
  fill: white;
}
.html5:hover .body,
.html5 .right-fill {
	fill: #FFF;
}
.html5 .left-5,
.html5 .right-5 {
	fill: grey;
}
.html5:hover .body {
	fill: #E34F26;
}
.html5:hover .right-fill {
	fill: #EF652A;
}
.html5:hover .left-5 {
	fill: #EBEBEB;
}
.html5:hover .right-5 {
	fill: #FFF;
}
```

```html
<svg class="html5" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
  <title>HTML5 Logo Badge</title>
  <path class="body" d="M71,460 L30,0 481,0 440,460 255,512"/>
  <path class="right-fill" d="M256,472 L405,431 440,37 256,37"/>
  <path class="left-5" d="M256,208 L181,208 176,150 256,150 256,94 255,94 114,94 115,109 129,265 256,265zM256,355 L255,355 192,338 188,293 158,293 132,293 139,382 255,414 256,414z"/>
  <path class="right-5" d="M255,208 L255,265 325,265 318,338 255,355 255,414 371,382 372,372 385,223 387,208 371,208zM255,94 L255,129 255,150 255,150 392,150 392,150 392,150 393,138 396,109 397,94z"/>
</svg>
```