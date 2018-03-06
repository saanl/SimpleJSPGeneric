<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<style>
	.table { 
		width:100%; 
		padding: 20px; 
		margin: 0px; 
		font-family:Arial, Tahoma, Verdana, Sans-Serif,宋体; 
		border:1px solid #ADD8E6; 
		border-collapse:collapse; 
	} 
	.table td{
		border:1px solid #ADD8E6; 
		padding: 10px;
		width: 50px;
		height: 25px;
	}
	input{
		width: 200px;
		padding: 5px;
		height: 25px;
	}
	
	select{
		width: 100px;
		height: 35px;
		text-align: center;
	}
</style>
<body>
	
	<div style="width: 100%;margin: 0 auto;">

	
	<table class="table">
		<tbody>
			<tr>
				<td colspan="3" align="center">	<h3>请输入数据库表的各项属性</h3></td>
			</tr>
			<tr>
				<td colspan="3" align="center"><strong>注意事项：不要以下划线，@等字符开头，字母最好全部小写，表属性名称不要和Java关键字冲突，例如class,goto,void等；只能一次建一张表</strong></td>
			</tr>
			

			<tr>
				<td>数据库用户名：<input type="text" placeholder="你的数据库名称，必填" id="username"></td>
				<td>数据库密码：<input type="text" placeholder="你的数据库密码，必填" id="userpwd"></td>
				<td>数据库名称：<input type="text" placeholder="你新建的空数据库的名称，必填" id="dbname"></td>
			</tr>
			<tr>
				<td colspan="3" align="center">表名：<input type="text" placeholder="你的表名称，必填" id="tablename"></td>
			</tr>
			<tr>
				<td>主键：</td>
				<td>

					<input type="text" id="primary" value="id">	(默认为id,自增，自己填写需要修改jsp某个代码)

				</td>
				<td>
					<select id="primary_type">
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|
				长度：<input type="text" id="primary_length" placeholder="必填"></td>
			</tr>
			<tr>
				<td>表属性中文名称</td>
				<td>表属性英文名称</td>
				<td>类型与长度</td>
			</tr>

			<tr>
				<td>学生姓名		<strong>(这里填中文)</strong></td>
				<td>stuname/stu_name		<strong>(这里填英文)</strong></td>
				<td>varchar | 15 		<strong>(这里为你选择的属性以及长度，int为11，varchar在0-255内都可以)</strong></td>
			</tr>
			
			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>

			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>

			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>

			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>

			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>

			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>
			
			
			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>
			
			
			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>
			
			
			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>
			
			
			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>
			
			
			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>
			
			
			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>
			
			
			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>
			
			
			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>
			
			
			<tr>
				<td>属性名称(中文)：<input type="text" placeholder="例如学生姓名/姓名" name="attr_zn"></td>
				<td>属性名称(英文)：<input type="text" placeholder="例如stuname/name"  name="attr_en"></td>
				<td>
					类型：
					<select name="attr_type" >
						<option value="int" selected="selected">int</option>
						<option value="varchar" >varchar</option>
					</select>	|  

					长度：<input type="text" name="attr_length" placeholder="int类型必须是11">
				</td>
			</tr>
		</tbody>
	</table>
	<br>
		
		<input type="button" onclick="send()" value="提交" style="height: 50px;background: red;font-size: 25px;margin-left: 150px;">
</div>

	<script>

			function send() {
				var json={};
				var arr = ["username","userpwd","dbname","tablename","primary","primary_type","primary_length"];
				for(var i=0;i<arr.length;i++){
					var a = document.getElementById(arr[i]);
					if(a.value==""){
						//alert("还有其他项未填写");
						//console.log(a);
					}else{
						json[arr[i]] = a.value; 
						
					}
				}
				var arr1=["attr_zn","attr_en","attr_type","attr_length"];
				for(var i=0;i<arr1.length;i++){
					var b = document.getElementsByName(arr1[i]);
						var arr3 = [];
						for (var j=0;j<b.length;j++) {
								arr3.push(b[j].value);
						}
						json[arr1[i]] = arr3;
				}
				var s =JSON.stringify(json);
				//console.log(s);
				//console.log(json);

				window.location="main?json="+encodeURI(s);
			}
			
	</script>
</body>
</html>