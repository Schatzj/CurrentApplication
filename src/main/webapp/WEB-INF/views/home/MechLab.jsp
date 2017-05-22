<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  
<script src="./webjars/jquery/3.1.1-1/jquery.min.js"
	type="text/javascript"></script>
<script src="./webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="./js/main/appMain.js" type="text/javascript"></script>
    <meta charset="utf-8">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet"
	href="./webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">

    <title>Battle Tech</title>
    
    <style>		
		body{
			height:100%;
			width:100%;
			position:absolute;
		}
		
		.mechs{
			margin-top:55px;
			float: left;
			height:60%;
			width: 15%;
/* 			background-color:green; */
		}
		
		.mechArea{
			margin-top:55px;
			float: left;
			height:60%;
			width: 70%;
			list-style-type: none;
 			/*background-color:red; */
		}
		
		.equipment{
			margin-top:55px;
			float: right;
			height:60%;
			width: 15%;
/*  			background-color:green;  */
		}
		
		.gunComparison1{
			padding-top: 10px;
/* 			position: fixed;  */
/* 			bottom: 80px; */
/* 			float: right; */
/* 			position: relative; */
			float: down;
			height:20%;
/* 			top:60%; */
			width: 100%;
/*  			background-color:blue;  */
		}
		
		.gunComparison2{
/* 			position: relative; */
			height:20%;
			float: down;
/* 			top:80%; */
			width: 100%;
/* 			position: fixed;  */
/* 			bottom: 0; */
/* 			height:9%; */
/* 			width: 100%; */
/* 			background-color:red; */
		}
		
		.myList{
			list-style-type: none;
		}
		
		.myContent{
  			height:80%;
 			overflow:auto;
    		background:#fff;
		}
		
		table {
    		font-family: arial, sans-serif;
    		border-collapse: collapse;
    		width: 100%;
		}

		td, th {
    		border: 1px solid #dddddd;
    		text-align: left;
    		padding: 8px;
		}

		tr:nth-child(even) {
    		background-color: #dddddd;
		}

    </style>
  </head>

  <body>
<div class="container-fluid"> 
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
     					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
       						<span class="sr-only">Toggle navigation</span>
        					<span class="icon-bar"></span>
        					<span class="icon-bar"></span>
        					<span class="icon-bar"></span>
     					 </button>
    				</div>  

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav nav-pills">
						<li role="presentation"><a href="./index">Home</a></li>
						<li role="presentation" class="active"><a href="./MechLab">Mechlab</a></li>
						<li role="presentation"><a href="./MechPage">mech 1</a></li>
						<li role="presentation"><a href="./Major.html">mech 2</a></li>
						<li role="presentation"><a href="./Random.html">mech 3</a></li>
						<li role="presentation"><a href="./Browse.html">mech 4</a></li>
						<li role="presentation"><a href="./MyPage.html">mech 5</a></li>
					</ul>
				</div>
			</div>
		</nav>	
	</div>

	<div class="mechs">
		<div class="myContent">
			<ul class="myList">
				<c:forEach items="${Mechs}" var="mech">
					<li>${mech.mech_name}</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="mechArea" ondrop="drop(event)" ondragover="allowDrop(event)">
		mech area
<!-- 		<table> -->
<!-- 			<tr> -->
<!-- 				<td>test</td> -->
<!-- 				<td> anotherThing</td> -->
<!-- 				<td> and a finale one </td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td> a few more </td> -->
<!-- 				<td> one last one </td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
	</div>
	<div class="equipment">
		<div class="myContent">
			<ul class="myList" id="equipmentList">
				<c:forEach items="${Ballistics}" var="ballistic">
					<li draggable="true" ondragstart="drag(event)" id="${ballistic}">${ballistic}</li>
				</c:forEach>
			</ul> 
		</div>
	</div>
	
	<a href="mechlab/update/1000/equipment1/C-AC20/equipment2/C-AC10">update</a>
		Distance: <input type="number" value="1000" id="distance"> <input type="submit" value="update" id="submitDistance" onClick=callme()>
	<div class="gunComparison1" ondrop="equipment1drop(event)" ondragover="allowDrop(event)" id="gunComp1">
		gun comparison
	</div>
	<div class="gunComparison2">
		gun comparison 2
	</div>
    
    <script type="text/javascript">
    var equipment1 = "";
    var equipment2 = "";
    //dynamically creating the table will probably work the best
    //so we will just need to insure we clear the old table first. So maybe give it an id to help with that. 
    //the mods will be selected from a drop down list. But this means we will need to know the type of the gun to generate the list. 
    //how do we learn that. I guess a REST call which returns a string determining the type. 
    //the list boxes will have an onselect or something which will store the mod value in a variable mod1, mod2 mod3 etc. 0
    
    function callme(){
		var distance = document.getElementById("distance").value;
    	if(equipment1 == "" || equipment1 == "null"){
    		equipment1 = "null";
    	}
    	if(equipment2 == "" || equipment2 == "null"){
    		equipment2 = "null";
    	}
    	var url = "mechlab/update/" + distance + "/equipment1/" + equipment1 + "/equipment2/" + equipment2;
    	$.post(url, function(data, status){ 
    		gunOneDisplay(data);
    	});
    }
    
    function gunOneDisplay(data){
		var response = data;
		var temp = response.toString();
		temp = temp.substring(1, temp.length);
		var array = temp.split("[");
		gunName = array[1].slice(0, array[1].indexOf("]"));
		
		console.log("gunName: " + gunName);
		var tableHeaders = array[2].split(",");
		console.log("table headers " + tableHeaders + "type of is: " + typeof(tableHeaders) + tableHeaders[0]);
		var values = array[3].split(",");
		console.log("values: " + values);
		var mods = array[4].split(",");
		console.log("mods " + mods);   
		
		var type = determineType(gunName);
		
		gunOneTable = document.createElement("TABLE");
		gunOneHeader = document.createElement("TR");
		gunOneName = document.createElement("TH");
		gunOneName.innerText = gunName;
		gunOneHeader.appendChild(gunOneName);
		gunOneTable.appendChild(gunOneHeader);
		document.getElementById("gunComp1").appendChild(gunOneTable);
		gunOneTable.appendChild(document.createElement("TR"));
		
		for(var i = 0; i<tableHeaders.length; i++){
			var element = document.createElement("TD");
			element.innerText = tableHeaders[i];
			gunOneTable.appendChild(element);			
		}
		gunOneTable.appendChild(document.createElement("TR"));
		
		for(var i = 0; i<values.length; i++){
			var element = document.createElement("TD");
			element.innerText = values[i];
			gunOneTable.appendChild(element);			
		}
		gunOneTable.appendChild(document.createElement("TR"));
		
		//damnit the id's are not unique. Every listbox has elements that have the same id. 
		//but maybe we don't need id. when they select one we can have the item make the call you know like an onClick. And probably send the current selection
		//I think we dp that in portal so we can delete the ids. 
		if(type == "ballistic"){
			for(var i = 0; i<mods.length; i++){
				if(i == (mods.length -4)){
					var selectBox = document.createElement("SELECT");
					var opt1 = document.createElement("OPTION");
// 					opt1.id="mod1";
					opt1.value="Stock";
					opt1.innerText = "Stock";
					var opt2 = document.createElement("OPTION");
// 					opt2.id="mod2";
					opt2.value="Long";
					opt2.innerText = "Long";
					var opt3 = document.createElement("OPTION");
// 					opt3.id="mod3";
					opt3.value="Short"
					opt3.innerText = "Short";
					selectBox.appendChild(opt1);
					selectBox.appendChild(opt2);
					selectBox.appendChild(opt3);
					var cell = document.createElement("TD");
					cell.appendChild(selectBox);
					gunOneTable.appendChild(cell);
				}else if(i >= (mods.length -4)){
					var selectBox = document.createElement("SELECT");
					var opt1 = document.createElement("OPTION");
// 					opt1.id="mod1";
					opt1.value="Stock";
					opt1.innerText = "Stock";
					var opt2 = document.createElement("OPTION");
// 					opt2.id="mod2";
					opt2.value="Heavy";
					opt2.innerText = "Heavy";
					var opt3 = document.createElement("OPTION");
// 					opt3.id="mod3";
					opt3.value="Light"
					opt3.innerText = "Light";
					selectBox.appendChild(opt1);
					selectBox.appendChild(opt2);
					selectBox.appendChild(opt3);
					var cell = document.createElement("TD");
					cell.appendChild(selectBox);
					gunOneTable.appendChild(cell);
				}else{
					var element = document.createElement("TD");
					element.innerText = mods[i];
					gunOneTable.appendChild(element);
				}
			}		
		}
    }
    
    function determineType(name){
    	//make a restful call to determine gun type. 
    	//returning fake data for now to continue development
    	return "ballistic";
    }
    
    function drag(ev) {
        ev.dataTransfer.setData("text", ev.target.id);
    }
    function equipment1drop(ev) {
        ev.preventDefault();
        var data = ev.dataTransfer.getData("text");
        equipment1 = document.getElementById(data).id;
//         console.log(equipment1);
//         ev.target.appendChild(document.getElementById(data));
    }
    
    function allowDrop(ev) {
        ev.preventDefault();
    }
    </script>
  </body>
</html>