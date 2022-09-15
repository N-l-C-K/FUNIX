$(document).ready(function () {

    var i = 1;     //Biến đếm số thứ tự
    var name;      //Tên
    var maths;     //Điểm môn Toán
    var physics;   //Điểm môn Lý
    var chemistry; //Điểm môn Hóa
    var avg;       //Điểm trung bình cộng

    //Nhập dữ liệu từ người dùng
    $("#input").click(function(e) {
        e.preventDefault();
        name = $("#name").val();
        maths = $("#maths").val();
        physics = $("#physics").val();
        chemistry = $("#chemistry").val();
        // alert(typeof name);
        //Thêm dữ liệu user nhập vào table

        //Bắt người dùng nhập vào hết mới in vào table
        if (name == "") {
            alert("Name must be filled out");
            return false;
        } else if (maths == "") {
            alert("maths must be filled out");
            return false;
        } else if (physics == "") {
            alert("physics must be filled out");
            return false;
        } else if (chemistry == "") {
            alert("chemistry must be filled out");
            return false;
        } else {
            //Thêm dữ liệu user nhập vào table nếu tất cả điều kiện trên đều false
            $("table tbody").append(function (){
                return "<tr><td>" + i++ + "</td><td>" + name + "</td><td>" + maths + "</td><td>" + physics + "</td><td>" + chemistry + "</td><td>?</td></tr>";
            });     
        }

        $("form")[0].reset();   //Reset form khi nhấn button 'Nhập'

    });

    //Tính số điểm trung bình
    $("#average").click(function() {
        $("table tbody").children().each(function() {
            var maths = parseFloat($(this).children().eq(2).html());
            var physics = parseFloat($(this).children().eq(3).html());
            var chemistry = parseFloat($(this).children().eq(4).html());
            avg = (maths + physics + chemistry)/3;
            $(this).children().eq(5).html(avg.toFixed(1));
        });
    });

    // $("average").click(function() {
    //     var rows = $("table tbody").children(); // children of table is tr        
    //     // loop for each row in table tbody
    //     rows.each(function() {
    //         var cols = $(this).children(); // children of tr is td
    //         // loop for each col in tr
    //         var i = 0, sum = 0;
    //         cols.each(function() {
    //             if(i>=2 && i<=4) { // col: toan, ly, hoa
    //                 sum += Number($(this).html());
    //             }
    //             if(i == 5) { // col: trung binh
    //                 $(this).html((sum/3).toFixed(1));
    //             }
    //             i++;
    //         });
    //     });
    // });

    //Xác định học sinh giỏi
    $("#excellentStudents").click(function() {
        $("table tbody").children().each(function() {
            avg = parseFloat($(this).children().eq(5).html());
            if (avg >= 8) {
                $(this).addClass("red");
            }
        });
    });

    //Xác định học sinh khá    
    $("#goodStudents").click(function() {
        $("table tbody").children().each(function() {
            avg = parseFloat($(this).children().eq(5).html());
            if (6.5 <= avg && avg < 8) {
                $(this).addClass("green");
            }
        });
    });

    //Xóa học sinh mới thêm
    $("#remove").click(function() {
        $("table tbody tr:last-child").remove();
    });

});