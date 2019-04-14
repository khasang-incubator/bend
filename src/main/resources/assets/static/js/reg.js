<!-- Скрипт, привязывающий событие click, открывающее модальное окно, к элементам, имеющим класс .btn -->
$(document).ready(function(){
    //alert('1');
    $(".menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    //при нажатию на любую кнопку, имеющую класс .btn
    $(".btn").click(function() {
        //открыть модальное окно с id="myModal"
        $("#myModal").modal('show');
        $("#emaillogin").focus();
    });
    $(function(){
        $("#myTab a").click(function(e){
            e.preventDefault();
            $(this).tab('show');
        });
        $(".login-modal").click(function(){
            //alert("jjj");
            $("#emaillogin").focus();
            console.log("login-modal");
        });
    });
});