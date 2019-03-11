<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Point</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>

<script>
    var service = 'http://localhost:8080/point'

    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/get/all',
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestPost = function (name, coordX, coordY, description) {
        var JSONObject = {
            'name': name,
            'coordX': coordX,
            'coordY': coordY,
            'description': description
        };

        $.ajax({
            type: 'POST',
            url: service + '/add',
            contentType: 'application/json;utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            accept: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestPut = function (id, name, coordX, coordY, description) {
        var JSONObject = {
            'id': id,
            'name': name,
            'coordX': coordX,
            'coordY': coordY,
            'description': description
        };

        $.ajax({
            type: 'PUT',
            url: service + '/update',
            contentType: 'application/json;utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            accept: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };

    var RestDelete = function (id) {
        $.ajax({
            type: 'DELETE',
            url: service + '/delete/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };
</script>
<body>
<h1>Point info</h1>
<table class="table">
    <tr>
        <th>Request type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>Get all points <code><strong>GET</strong></code></td>
        <td>/point/get/all</td>
        <td>
            <button type="button" onclick="RestGetAll()">try</button>
        </td>
    </tr>
    <tr>
        <td>Get point by id <code><strong>GET</strong></code></td>
        <td>/point/get/id</td>
        <td>
            id: <input id="pointIdForGet" value=""/>
            <button type="button" onclick="RestGet($('#pointIdForGet').val())">try</button>
        </td>
    </tr>
    <tr>
        <td>Delete point by id <code><strong>DELETE</strong></code></td>
        <td>/point/delete/id</td>
        <td>
            id: <input id="pointIdForDelete" value=""/>
            <button type="button" onclick="RestDelete($('#pointIdForDelete').val())">try</button>
        </td>
    </tr>
    <tr>
        <td>Add point<code><strong>POST</strong></code></td>
        <td>/point/add</td>
        <td>
            name: <input id="nameForAdd" value=""/>
            <br>
            coordX: <input id="coordXForAdd" value=""/>
            <br>
            coordY: <input id="coordYForAdd" value=""/>
            <br>
            description: <input id="descriptionForAdd" value=""/>
            <button class="try" type="button"
                    onclick="RestPost($('#nameForAdd').val(), $('#coordXForAdd').val(), $('#coordYForAdd').val(), $('#descriptionForAdd').val())">
                try
            </button>
        </td>
    </tr>
    <tr>
        <td>Update point<code><strong>PUT</strong></code></td>
        <td>/point/update</td>
        <td>
            id: <input id="idForUpdate" value=""/>
            <br>
            name: <input id="nameForUpdate" value=""/>
            <br>
            coordX: <input id="coordXForUpdate" value=""/>
            <br>
            coordY: <input id="coordYForUpdate" value=""/>
            <br>
            description: <input id="descriptionForUpdate" value=""/>

            <button type="button"
                    onclick="RestPut($('#idForUpdate').val(), $('#nameForUpdate').val(), $('#coordXForUpdate').val(), $('#coordYForUpdate').val(), $('#descriptionForUpdate').val())">
                try
            </button>
        </td>
    </tr>
</table>
<div class="panel panel-default">
    <div class="page-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"></div>
</div>
</body>
</html>
