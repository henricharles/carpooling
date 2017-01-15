<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>
<link rel="stylesheet" href="Customize.css"/>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
      <div class="container1" >
    <form  id="form" method="POST" action="SignupController">
       <div class="form2">
    <input type="text" class="form-control" placeholder="Full Name" name="name"></input><br>
    Gender<br> <input type="radio" name="gender" value="male" > Male
  <input type="radio" name="gender" value="female"> Female
  <fieldset >
    <legend> Adress</legend>
    <input  type="text"  class="form-control" placeholder="State" name="state"></input><br>
    <input type="text" class="form-control" placeholder="City" name="city" ></input><br>
    <input type="text" class="form-control" placeholder="Street" name="street"></input><br>
    <input  type="text"  class="form-control" placeholder="Zip Code" name="zipcode"></input><br>
    
      </fieldset>
    <input type="date"  id="bdate"  class="form-control"   name="birth"></input><br>
    
    
    <input type="email"  class="form-control" placeholder="Email " name="email"></input><br>
    <input type="password"  name="password" class="form-control" placeholder="Password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"></input><br>
    <!--<input id="submit" type="submit" class="btn" value="Sign Up"> </input>-->
    <input type = "submit" class = "btn btn-primary" value="SIGN UP"/>
</div>
 
</form> >
    <div >
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>