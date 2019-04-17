$(document).ready(function () {


    // var service = 'http://localhost:8080/barsuk';
    //
    // var RestGetAll = function () {
    //     $.ajax({
    //         type: 'GET',
    //         url: service + '/all',
    //         dataType: 'json',
    //         accept: 'json',
    //         contentType: 'application/json;utf-8',
    //         async: false,
    //         success: function (result) {
    //             $('#response').html(JSON.stringify(result))
    //         },
    //         error: function (jqXHR, testStatus, errorThrown) {
    //             $('#response').html(JSON.stringify(jqXHR))
    //         }
    //     });
    // };
    //


    $("#disciplines-widjet .showmore").click(function (e) {
        //alert("showmore");
        if ($("#disciplines-widjet .checkbox-biglist").hasClass("hide")) {
            $("#disciplines-widjet .checkbox-biglist").removeClass("hide")
        } else {
            $("#disciplines-widjet .checkbox-biglist").addClass("hide");
        }
    });

    $(".disciplines-list .fa-trash").click(function (e) {
        var s = this.id.substr(17);
        $("#disciplines-biglist-" + s + " " + "input").prop('checked', false);
        $(".disciplines-list-" + s).detach();

        //alert("checked2");
        //$('.myCheckbox').is(':checked');
    });

    $(".checkbox-biglist input").click(function (e) {
        var s = $(this).parent().attr("id").substr(20);
        var discName = $(this).html();
        alert(s + discName);

        if ($(this).is(':checked')) {
            $(".disciplines-list").add(" <span class=\"disciplines-list-" + s + "\"><strong>" + discName + "</strong> " +
                "<span style=\"font-size:16px;\" id=\"disciplines-list-" + s + "\" " +
                "class=\"pull-right hidden-xs showopacity fa fa fa-trash table-click-item disciplines-list-2\"></span></span>");
        } else {
            $(".disciplines-list-" + s).detach();
        }


    });

});