<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SBI ATM</title>
<style>
    
    body{
        display: flex;
        justify-content: center;
    }
    #main{
        height: 650px;
        width: 50%;
        border: 2px solid black;
        background: repeating-linear-gradient(to right top, rgb(2, 188, 77),rgb(53, 211, 243),rgb(153, 240, 47) );
    }
    #head{
        padding: 5%;
        display: flex;
        border-bottom: 1.5px solid black;
    }
    #head img{
        height: 100px;
        width: 100px;
        border-radius: 50%;
        border: 1px solid black;
    }
    #head h2{
        margin: 6% 0 0 15%;
        font-size: 35px;
        color: blue;
        text-decoration: underline;
    }
    #form{
        display: flex;
    }
    #content{
        width: 200px;
        padding-left: 15%;
    }
    #input input{
        font-size: 17px;
        padding-left: 4%;
        height: 25px;
        width: 270px;
        margin: 3% 0 0 -2%;
        background: repeating-linear-gradient(to right top,rgb(53, 211, 243), rgb(130, 232, 6),rgb(53, 211, 243) );
    }
    #input .gnd{
        height: 15px;
        width: 15px;
        margin:4% 10% 2% 1%;
    }
    #input #pht{
        padding: 0;
        background: rgb(53, 211, 243);
    }
    #input #btn{
        height: 50px;
        width: 150px;
        padding: 1%;
        font-size: 20px;
        border-radius: 20px;
        margin: 15% 0 0 -15%;
        background: greenyellow;
    }
     #input .btn{
        height: 45px;
        width: 145px;
        padding: 1%;
        font-size: 20px;
        border-radius: 20px;
        margin: 5% 0 0 -15%;
        background: rgb(220, 77, 236);
    }
</style>
</head>
<body>
    <div id="main">
        <div id="head">
            <img src="logo/sbiLogo1.jpg" alt="">
            <h2>Register Here</h2>
        </div>
        <div id="form">
            <div id="content">
                <h3>Name:</h3>
                <h3>Email:</h3>
                <h3>Password:</h3>
                <h3>Contact:</h3>
                <h3>Gender:</h3>
                <h3>Deposit Fee:</h3>
                <h3>Profile:</h3>
            </div>
            <div id="input">
                <form action="registerData" method="post" enctype="multipart/form-data">
                    <input type="text" name="nm" required><br>
                    <input type="email" name="em" required><br>
                    <input type="password" name="pwd" required><br>
                    <input type="number" name="phn" required><br>
                    Male<input class="gnd" type="radio" name="gnd" value="Male">
                    Female<input class="gnd" type="radio" name="gnd" value="Female">
                    <input type="number" name="dpo"><br>
                    <input type="file" accept="image/jpeg, image/png, image/jpg" name="pht" id="pht"><br>
                    <input id="btn" type="submit" value="Register">
                </form>  
                <a href="login.jsp" ><button class="btn">Login</button></a>               
            </div>
        </div>
       
    </div>
 

 
</body>
</html>

