<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Battle Tech</title>

<link rel="stylesheet"
	href="./webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/wapa-bootstrap-theme.css">

<style>
.MyMargin {
	margin-top: 55px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav nav-pills">
					<li role="presentation" class="active"><a href="./Index.html">Home</a></li>
					<li role="presentation"><a href="./MechLab">Mechlab</a></li>
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

	 <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-8 MyMargin">
<!--           <h2>Equiped Guns</h2> -->
          <p>I am not sure if we need this page or not. </p>
          <button type="button" class="btn btn-success">Inventory</button><br/><br/>
          <button type="button" class="btn btn-success">Deploy Mech</button><br/><br/>
          <p>We could maybe display information about the pilot here. </p>
        </div>
        <div class="col-md-4 MyMargin">
        </div>
      </div>
    </div> <!-- /container -->
</body>
</html>