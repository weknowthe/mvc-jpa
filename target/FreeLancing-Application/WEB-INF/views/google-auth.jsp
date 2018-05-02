<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<head><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script src="script.js"></script>
<script>
  function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
      $(".g-signin2").css("display","block");
 $(".data").css("display","none");
    });
   }
   function onSignIn(googleUser) {
  var profile = googleUser.getBasicProfile();
  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
  console.log('Name: ' + profile.getName());
  console.log('Image URL: ' + profile.getImageUrl());
  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
 $(".g-signin2").css("display","none");
 $(".data").css("display","block");
 $("#pic").attr('src',profile.getImageUrl());
 $("#email").text(profile.getEmail());
}
</script>


<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="387694001362-gbtso0tj1caarrf9kc1p5dpg9uq9gbtd.apps.googleusercontent.com">
<style>
.g-signin2{
margin-left:50px;
margin-top:50px;
}
.data{
display:none;
}
</style>
</head>
<body>
<h1>Google SignIn</h1>
<div class="g-signin2" data-onsuccess="onSignIn"></div>
<div class ="data">
<p>Profile Details </p>
<img id ="pic" class="img-circle" width="100" height=""/>
<p>Email Address</p>
<p id="email" class="alert alert-danger"></p>
<button onclick="signOut()" class="btn btn-danger"> Sign Out</button>
</div>

<!--a href="#" onclick="signOut();">Sign out</a-->
</body>
</html>