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
        height: 300px;
        width: 500px;
        display: flex;
        border: 2px solid black;
        padding: 5px;
        background:repeating-linear-gradient(to right top,rgb(53, 211, 243), 
        rgb(153, 240, 47) );
    }
    img{
        height: 105px;
        width: 105px;
        border: 1px solid black;
        margin: 12% 0 0 15%;
    }
    #content{
        margin: 3% 0 0 3%;
        text-align: center;
        width: 100%;
    }
    h2{
      font-size: 25px;
      color: blue;
    }
    #nm{
    	text-transform: capitalize;
    	color: blue;
    	font-size: 22px;
    }
    form #pwd{
        height: 25px;
        width: 150px;
        border-radius: 10px;
        padding-left: 2%;
         background:repeating-linear-gradient(to right top,rgb(53, 211, 243), 
        rgb(153, 240, 47) );
    }
    form input{
        height: 25px;
        width: 65px;
        border-radius: 10px;
         background:repeating-linear-gradient(to right top,rgb(53, 211, 243), 
        rgb(153, 240, 47) );
    }
    #btn{
      margin: 3% 0 0 -30%;
    }
    #btn button{
      height: 50px;
      width: 150px;
      margin: 2%;
      font-size: 17.5px;
      border-radius: 10px;
      background:repeating-linear-gradient(to right top,rgb(53, 211, 243), 
        rgb(153, 240, 47) );
        color: blue;
    }
   
</style>
</head>
<body>

	<%
		String nm = (String)session.getAttribute("nm");
		String pht = (String)session.getAttribute("pht");
		String dpo = (String)session.getAttribute("dpo");
		
	%>

    <div id="main">
         <div id="logo">
    		<img src="images/<%= pht%>" height="150" width="150">
    	</div>
        
        <div id="content">
          <h2>Welcome To Online SBI</h2><br>
          <p id="nm">Hello <%= nm %></p><br>
          <p>Your Account Balance: <%= dpo %></p>
        
          <div id="btn">
            <a href="checkPwd.jsp"><button>Check A/C</button></a>
            <a href="deposit.jsp"><button>Deposit</button></a>
            <a href="withdrawPwd.jsp"><button>Withdraw</button></a>
            <a href="index.html"><button>Logout</button></a>                 
          </div>
        </div>
    </div>
    
</body>
</html>

