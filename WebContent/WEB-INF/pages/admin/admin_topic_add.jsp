<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="page">
	<div class="pageContent">
        <form method="post" action="" class="pageForm required-validate" onsubmit="">
        	<div class="pageFormContent" layoutH="58">
				<div class="unit">
                    <label>代码值：</label>
                    <input id="codeName" class="required" name="code.codeValue" type="text"  maxlength="32" value="" />
                </div>
                <div class="unit">
                    <label>代码说明：</label>
                    <input id="remark" class="required" name="code.remark" type="text"  maxlength="50" value="" />
                </div>
            </div>
            <div class="formBar">
                <ul>
                    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
                    <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
                </ul>
        	</div>
       </form>
	</div>
</div>