<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
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
			height:75%;
			width: 15%;
/* 			background-color:green; */
		}
		
		.mechArea{
			margin-top:55px;
			float: left;
			height:75%;
			width: 70%;
			list-style-type: none;
 			/*background-color:red; */
		}
		
		.equipment{
			margin-top:55px;
			float: right;
			height:80%;
			width: 15%;
/*  			background-color:green;  */
		}
		
		.gunComparison{
			position: fixed; 
			bottom: 0;
/* 			float: right; */
			height:18%;
			width: 100%;
/* 			background-color:blue; */
		}
		
		.myList{
			list-style-type: none;
		}
		
		.myContent{
  			height:80%;
 			overflow:auto;
    		background:#fff;
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
	<div class="gunComparison">
		gun comparison
	</div>
    
    <script type="text/javascript">
    function drag(ev) {
        ev.dataTransfer.setData("text", ev.target.id);
    }
    function drop(ev) {
        ev.preventDefault();
        var data = ev.dataTransfer.getData("text");
        ev.target.appendChild(document.getElementById(data));
    }
    
    function allowDrop(ev) {
        ev.preventDefault();
    }
    </script>
  </body>
</html>