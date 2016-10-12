<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.care.health.model.Users"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <script src="https://www.gstatic.com/firebasejs/3.3.2/firebase.js"></script>
    <script>
  // Initialize Firebase
         var config = {
    apiKey: "AIzaSyCxuAdbWJiMcvynFJ97j3en2mgV9uDAb1o",
    authDomain: "makky-ef9a8.firebaseapp.com",
    databaseURL: "https://makky-ef9a8.firebaseio.com",
    storageBucket: "makky-ef9a8.appspot.com",
    messagingSenderId: "8636025813"
  };
  firebase.initializeApp(config);
  var bigOne = document.getElementById('bigOne');
  var dbRef = firebase.database().ref().child('text');
  dbRef.on('value', snap => bigOne.innerText = snap.val());

    </script>
</head>
<body>
zxczxc
    <h1 id="bigOne"></h1>
   
   

</body>
</html>