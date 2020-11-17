<%--
  Created by IntelliJ IDEA.
  User: mi
  Date: 08.11.2020
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Точка</title>
    <script src="Validation.js"></script>
    <script src="Coordinates.js"></script>
    <style>
        .header{
            display: block;
            background-color: aliceblue;
            text-align: center;
            color: #f302ff;
        }
        .dot{
            background-color: rgb(132,221,201);
        }
        .dot, .x, .y, .r, .submit{
            text-align: center;
            margin: 20px 30px;
            padding: 10px;
        }
        .dot input[type="checkbox"], .dot input[type="text"]{
            text-indent: 10%;
        }
        .dot input[type="checkbox"]:hover, .dot input[type="text"]:hover{
            text-indent: 10%;
            border-style: solid;
        }
        #inner-submit:active{
            background-color: #25e1ae;
        }
        .dot input[type="checkbox"]:checked + label, .dot input[type="checkbox"]:hover + label{
            font-weight: bold;
            color:#ffffff;
        }
        .dot input[type="text"]:hover + label, .dot input[type="text"]:focus + label{
            font-weight:bold;
        }
        header{
            font-family: monospace;
            color:black;
            font-size: 15px;
        }
        .x{
            background-color: #df77a8;
        }
        .x_check{
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }
        .y{
            background-color: #88df77;
        }
        .r{
            background-color: #df9b77;
        }
        table,th,td{
            border: 1px solid black;
            margin: auto;
            text-align: center;
            table-layout: fixed;
        }
        td,th{
            width: 170px;
            text-wrap: normal;
            word-wrap: break-word;
        }
    </style>
</head>
<body onload="draw()">
<header>
    <div class="header">
        <p>
            ФИО: Сабуров Владислав Алексеевич<br>
            ГРУППА: P3210<br>
            ВАРИАНТ: 10783
        </p>
    </div>
</header>
<div class="dot">
    <canvas id="int_elem" width="222" height="215">
        <img src="web.png" alt="Картинка с областью" width="420" height="380" >
    </canvas>
    <form name="data" action="controller" method="post" onsubmit="return validateData()">
        <div class="x">
            <p>
                Выберите координату x<br>
            </p>
            <div class="x_check">
                <div class="x_option">
                    <input type="checkbox" id="-2" name="x" value="-2">
                    <label for="-2">-2</label><br>
                </div>
                <div class="x_option">
                    <input type="checkbox" id="-1.5" name="x" value="-1.5">
                    <label for="-1.5">-1.5</label><br>
                </div>
                <div class="x_option">
                    <input type="checkbox" id="-1" name="x" value="-1">
                    <label for="-1">-1</label><br>
                </div>
                <div class="x_option">
                    <input type="checkbox" id="-0.5" name="x" value="-0.5">
                    <label for="-0.5">-0.5</label><br>
                </div>
                <div class="x_option">
                    <input type="checkbox" id="0" name="x" value="0">
                    <label for="0">0</label><br>
                </div>
                <div class="x_option">
                    <input type="checkbox" id="0.5" name="x" value="0.5">
                    <label for="0.5">0.5</label><br>
                </div>
                <div class="x_option">
                    <input type="checkbox" id="1" name="x" value="1">
                    <label for="1">1</label><br>
                </div>
                <div class="x_option">
                    <input type="checkbox" id="1.5" name="x" value="1.5">
                    <label for="1.5">1.5</label><br>
                </div>
                <div class="x_option">
                    <input type="checkbox" id="2" name="x" value="2">
                    <label for="2">2</label><br>
                </div>
            </div>
        </div>
        <div class="y">
            <p>
                Введите координату y в интервале от -3 до 5
            </p>
            <input type="text" id="y" name="y" maxlength="15">
            <label for="y">y</label><br>
        </div>
        <div class="r">
            <p id="Radius">
                Выберите радиус R
            </p>
            <input type="hidden" name="r" id="rad">
            <input type="button" value="1" onclick="setR(value)">
            <input type="button" value="1.5" onclick="setR(value)">
            <input type="button" value="2" onclick="setR(value)">
            <input type="button" value="2.5" onclick="setR(value)">
            <input type="button" value="3" onclick="setR(value)">
        </div>
        <input type="hidden" name="f" value=true>
        <div class="submit">
            <input type="submit" id="inner-submit">
        </div>
    </form>
</div>
<div id="table">
<jsp:useBean id="table" class="Model.Table" scope="session"/>
${table.table}
</div>
</body>
</html>