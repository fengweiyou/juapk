jQuery Confirm是一个用于显示confirm确认提示消息的jquery插件，该插件在使用的时候不需要添加改变原有代码逻辑，只需要在待确认的节点上调用conform，如$(element).confirm()，另外该插件不需要回调方法。

http://www.rainleaves.com/html/1525.html

相比传统的confirm方法，该插件使用上方便许多。而且在用户体验上更为友好。

查看实际效果

猛烈单击我吧

 jQuery Confirm插件原理

简而言之，就是通过插件记录下该节点上绑定的单击事件，然后取消原事件绑定。当用户单击时，显示提示内容，如果用户选择确认操作，则触发节点原绑定事件，用户取消，提示内容消失。

用法和文档

$(element).confirm(options)
OPTIONS
参数	类型	是否可选	描述	默认值
msg	String	可选	提示内容	‘Are you sure?’
stopAfter	string	可选	停止事件冒泡	‘never’
wrapper	String	可选	外层包裹	‘<span></span>’
eventType	String	可选	响应时间类型	‘click’
dialogShow	String	可选	对话框小时效果	‘show’
dialogSpeed	String	可选	对话框显示速度	‘fast’
timeout	Integer	可选	延时	0
OPTIONS.BUTTONS
ok	String	可选	确认按钮	‘Yes’
cancel	String	可选	取消按钮	‘No’
wrapper	String	可选	按钮的外层包装	‘<a href=”#”></a>’
separator	String	可选	按钮之间的分隔符	‘/’
cls	String	可选	按钮的样式	undefined
demo1

// The action.
$('a').click(function() {
  alert('click');
  return false;
});

// The most simple use.
$('a').confirm();
Are you sure?Yes/No
demo2

// The action.
$('input[type=button]').click(function() {
  $(this).remove();
});

$('input[type=button]').confirm({
  msg:'Do you really want to delete this button?',
  timeout:3000
});

demo3

// The action.
$('span').mouseover(function() {
  $(this).html('Here is the offer');
});

$('span').confirm({
  msg:'See my interesting offer?',
  stopAfter:'ok',
  eventType:'mouseover',
  timeout:3000,
  buttons: {
    ok:'Sure',
    cancel:'No thanks',
    separator:'  '
  }
});
鼠标移上来吧。
demo4

$('a').confirm({
  timeout:3000,
  dialogShow:'fadeIn',
  dialogSpeed:'slow',
  buttons: {
    wrapper:'<button></button>',
    separator:'  '
  }
});



-----------------------------------demo.html-----------------------------------------

<html>
<head>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="jquery.confirm.js"></script>
<script>
$(document).ready(function() {
    // First example
    $('a.class1').click(function() {
        alert('click');
        return false;
    });
 
    // The most simple use.
    $('a.class1').confirm();

    // Second example
    $('input[type=button]').click(function() {
        $(this).remove();
    });
     
    $('input[type=button]').confirm({
        msg:'Do you really want to delete this button?',
        timeout:3000
    });
    
    // Third example
    $('span').mouseover(function() {
        $(this).html('Here is the offer');
    });
     
    $('span').confirm({
        msg:'See my interesting offer?',
        stopAfter:'ok',
        eventType:'mouseover',
        timeout:3000,
        buttons: {
            ok:'Sure',
            cancel:'No thanks',
            separator:'  '
        }
    });

    // Fourth example
    $('a.class2').confirm({
        timeout:3000,
        dialogShow:'fadeIn',
        dialogSpeed:'slow',
        buttons: {
            wrapper:'<button></button>',
            separator:'  '
        }  
    });
});


</script>
<title>Confirm Example</title>
</head>
<body>
<h3>First Example</h3>
<a class="class1" href="#">Click me</a>
<h3>Second Example</h3>
<input type="button" value="Click Here to delete me" />
<h3>Third Example</h3>
<span>Confirm on mouse over</span>
<h3>Fourth Example</h3>
<a class="class2" href="http://google.com">Click me to go to google.com</a>
</body>
</html>


----------------------------------------------------------------------------
