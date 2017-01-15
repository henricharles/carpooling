<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
   
  
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    
  </head>
  <body id="body">
  <!--- header-->
  <nav id="nav1"class="navbar navbar-default navbar-inverse " style="boarder-radius:0px" >  
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div id="nav1"class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
        
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      </ul>
      <form class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-left">
        <li><a href="#" id="profileup">Update Profile Information</a></li>
        <ul class="nav navbar-nav navbar-left">
        <li><a href="home1.jsp">Home</a></li>
        <li><a href="weather.jsp">Weather Service</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Select Ride <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#" id="asking">Asking For a Ride</a></li>
            <li><a href="#" id="offering">Offering Ride</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
      </ul>
    </div><!-- /.navbar-collapse     javascript:void(0)-->
  </div><!-- /.container-fluid -->
</nav>
  <!-- end header-->
  <!-- start slide-->
  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="happy.jpg" alt="img1">
      <div class="carousel-caption">
        <h3> Enjoy</h3>
       
      </div>
    </div>
     <div class="item ">
      <img src="relax.jpg" alt="img1">
      <div class="carousel-caption">
        <h3> Relax</h3>
      
      </div>
    </div>
  <div class="item ">
      <img src="bean.jpg" alt="img1">
      <div class="carousel-caption">
        <h3> Have Fun </h3>
     
      </div>
    </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<div id="posdiv1"></div>
<div id="posdiv" class="form-group"></div>
<div id="updatediv" class="form-group"></div>
  <!-- end slide-->

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
     
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script  src="postlist.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>