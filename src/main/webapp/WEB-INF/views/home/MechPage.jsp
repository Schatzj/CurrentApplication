<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link rel="stylesheet"
	href="./webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/wapa-bootstrap-theme.css">

    <title>Battle Tech</title>

    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">
    
    <style>
    	.distance-input{
    		size: 5;
    		text-align: right;
    		width: 50px;
    	}
    	
    	.MyMargin{
			margin-top:35px;
		}
    </style>
  </head>

  <body>
<!--     Main jumbotron for a primary marketing message or call to action -->
<!--     <div class="jumbotron"> -->
<!--       <div class="container"> -->
<!--         <h1 class="display-3">Hello, world!</h1> -->
<!--         <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p> -->
<!--         <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p> -->
<!--       </div> -->
<!--     </div> -->
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
						<li role="presentation"><a href="./MechLab">Mechlab</a></li>
						<li role="presentation"class="active"><a href="./MechPage">mech 1</a></li>
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
          <h2>Equiped Guns</h2>
          <p>Here we will depect the equipt guns catogorized by placement (torse, left and right arm)
          <br/>
          <br/>
          Range: <input type="text" value="1000" class="distance-input"></input> meters <br/>
          <br/> Gun Name
          <br/> gun information for specified range, and mods &emsp; <button>shoot</button> &emsp; number of shots remaining: 1
          <br/>
          <br/> Gun Name
          <br/> gun information for specified range, and mods &emsp; <button>shoot</button> &emsp; number of shots remaining: 1
          <br/>
          <br/> Gun Name 
          <br/> gun information for specified range, and mods &emsp; <button>shoot</button> &emsp; number of shots remaining: 1
          <br/>
          <br/> Gun Name 
          <br/> gun information for specified range, and mods &emsp; <button>shoot</button> &emsp; number of shots remaining: 1
          <br/>
          <br/> Gun Name 
          <br/> gun information for specified range, and mods &emsp; <button>shoot</button> &emsp; number of shots remaining: 1
          <br/>
          <br/> Gun Name 
          <br/> gun information for specified range, and mods &emsp; <button>shoot</button> &emsp; number of shots remaining: 1
          <br/>
          <br/> Gun Name 
          <br/> gun information for specified range, and mods &emsp; <button>shoot</button> &emsp; number of shots remaining: 1
          <br/>
          <br/> Gun Name 
          <br/> gun information for specified range, and mods &emsp; <button>shoot</button>  &emsp; number of shots remaining: 1</p> 
        </div>
        <div class="col-md-4 MyMargin">
          <h2>Mech Health</h2>
          <p> Possibly have an image here depicting the health of the mech <br/>
          Otherwise have something like: <br/>
          Torso: 100% &emsp; front armour: 35 &emsp; back armour 30<br/><br/>
          Right arm: 100% &emsp; front armour: 35 &emsp; back armour 30<br/><br/>
          Left arm: 100% &emsp; front armour: 35 &emsp; back armour 30 <br/><br/>
          Right leg: 100% &emsp; front armour: 35 &emsp; back armour 30 <br/><br/>
          Left leg: 100% &emsp; front armour: 35 &emsp; back armour 30</p>
        </div>
      </div>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>