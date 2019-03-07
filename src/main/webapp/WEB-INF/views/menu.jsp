<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script>
    var service = 'http://localhost:8080/barsuk';

    var RestGetAll = function () {
        $.ajax({
            type: 'GET',
            url: service + '/all',
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

    var RestPost = function (name, description, year) {
        var JSONObject = {
            'name': name,
            'description': description,
            'year': year
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

    var RestPut = function (id, name, description, year) {
        var JSONObject = {
            'id': id,
            'name': name,
            'description': description,
            'year': year
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
<h1>Barsuk info</h1>

<table class="table">
    <tr>
        <th>Request type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>Get all badgers <code><strong>GET</strong></code></td>
        <td>/barsuk/all</td>
        <td>
            <button type="button" onclick="RestGetAll()">try</button>
        </td>
    </tr>
    <tr>
        <td>Get badger by id <code><strong>GET</strong></code></td>
        <td>/barsuk/get/id</td>
        <td>
            id: <input id="badgerIdForGet" value=""/>
            <button type="button" onclick="RestGet($('#badgerIdForGet').val())">try</button>
        </td>
    </tr>
    <tr>
        <td>Delete badger by id <code><strong>Delete</strong></code></td>
        <td>/barsuk/delete/id</td>
        <td>
            id: <input id="badgerIdForDelete" value=""/>
            <button type="button" onclick="RestDelete($('#badgerIdForDelete').val())">try</button>
        </td>
    </tr>
    <tr>
        <td>Add badger<code><strong>Post</strong></code></td>
        <td>/barsuk/add</td>
        <td>
            name: <input id="nameForAdd" value=""/>
            <br>
            description: <input id="descriptionForAdd" value=""/>
            <br>
            year: <input id="yearForAdd" value=""/>
            <br>
            <button type="button" onclick="RestPost($('#nameForAdd').val(), $('#descriptionForAdd').val(), $('#yearForAdd').val())">try</button>
        </td>
    </tr>
    <tr>
        <td>Update badger<code><strong>Put</strong></code></td>
        <td>/barsuk/update</td>
        <td>
            id: <input id="idForUpdate" value=""/>
            <br>
            name: <input id="nameForUpdate" value=""/>
            <br>
            description: <input id="descriptionForUpdate" value=""/>
            <br>
            year: <input id="yearForUpdate" value=""/>
            <br>
            <button type="button" onclick="RestPut($('#idForUpdate').val(), $('#nameForUpdate').val(), $('#descriptionForUpdate').val(), $('#yearForUpdate').val())">try</button>
        </td>
    </tr>

</table>

<div class="panel panel-default">
    <div class="page-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"> </div>
</div>
</body>
</html>
