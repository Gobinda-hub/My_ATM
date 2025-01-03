<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SBI ATM</title>
<style>
    *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    body{
        height: 100vh;
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #main{
        height: 350px;
        width: 550px;
        display: flex;
        border: 2px solid black;
        padding: 5px;
        background:repeating-linear-gradient(to right top,rgb(53, 211, 243), 
        rgb(153, 240, 47) );
    }
    img{
        height: 110px;
        width: 110px;
        border: 1px solid black;
        margin: 12% 0 0 15%;
    }
    #content{
        margin: 7% 0 0 8%;
        text-align: center;
    }
    h2{
        font-size: 30px;
        color: blue;
    }
    #form{
      height: 150px;
      width: 100%;
      display: flex;
      margin: 10% 0 0 -6%;
    }
    #formContent{
      width: 100px;
      font-size: 17px;
    }
    #input{
      width: 100%;
    }
    #input #in{
      height: 40px;
      width: 110%;
      margin:-3% 0 5% 1%;
      border-radius: 15px;
      padding-left: 15px;
      font-size: 17px;
      background:repeating-linear-gradient(to right top,rgb(53, 211, 243), 
        rgb(153, 240, 47) );
    }
    #input #btn{
   	  border-radius: 15px;
      font-size: 20px;
      width: 120px;
      margin-left: -60%;
      padding: 1%;
      background-color: rgb(248, 26, 237);
    }
      #input .btn{
   	  border-radius: 15px;
      font-size: 20px;
      width: 120px;
      margin: 5% 0 0 -60%;
      padding: 1%;
      background-color: greenyellow;
    }
</style>
</head>
<body>
	
    <div id="main">
        <div id="logo">
            <img src="logo/sbiLogo1.jpg" alt="">
        </div>
        <div id="content">
            <h2>Welcome To Online SBI</h2><br><br>
            <div id="form">
              <div id="formContent">
                  <h3>Email:</h3><br>
                  <h3>Password:</h3>
              </div>
              <div id="input">
                  <form action="loginData" method="post">
                      <input type="email" name="em" id="in" required><br>
                      <input type="password" name="pwd" id="in" required><br><br>
                      <input id="btn" type="submit" value="Log In">
                  </form>   
                  <a href="register.jsp"><button class="btn">Register</button></a>            
              </div>
          </div>
        </div>
    </div>
    
</body>
</html>

