// Bai 1
function bai1() {
    var lengthRectangle = parseFloat(document.getElementById("lengthRectangle").value);
    var widthRectangle = parseFloat(document.getElementById("widthRectangle").value);

    if (lengthRectangle > 0 && widthRectangle > 0) {
        var areaRectangle = lengthRectangle * widthRectangle; //Tính diện tích hình chữ nhật
        var perimeterRectangle = (lengthRectangle + widthRectangle) * 2; //Tính chu vi hình chữ nhật
        document.getElementById("excer1").innerHTML = "Diện tích là: " + areaRectangle.toFixed(2) + " .Chu vi là: " + perimeterRectangle.toFixed(2); //In ra màn hình
        document.getElementById("excer1").style.color = "black";
    } else {
        document.getElementById("excer1").innerHTML = "*Số không hợp lệ!"
        document.getElementById("excer1").style.color = "red";
    }
}
// Bai 2
function bai2() {
    var radius = parseFloat(document.getElementById("radius").value);
    if (radius > 0) {
        var areaCircle = radius**2 * 3.14; //Tính diện tích hình tròn
        var perimeterCircle = radius * 2 * 3.14; //Tính chu vi hình tròn
        document.getElementById("excer2").innerHTML = "Diện tích là: " + areaCircle.toFixed(2) + " .Chu vi là: " + perimeterCircle.toFixed(2); //In ra màn hình
        document.getElementById("excer1").style.color = "black";
    } else {
        document.getElementById("excer2").innerHTML = "*Số không hợp lệ!"
        document.getElementById("excer2").style.color = "red";
    }
}
//Bai 3
function bai3() {
    var length1 = parseFloat(document.getElementById("length1").value);
    var length2 = parseFloat(document.getElementById("length2").value);
    var length3 = parseFloat(document.getElementById("length3").value);
    if (length1 > 0 && length2 > 0 && length3 > 0) {
        var perimeterTriangle = length1.toFixed(2) + length2.toFixed(2) + length3.toFixed(2); //Tính chu vi hình tam giác
        alert(perimeterTriangle);
        var p = perimeterTriangle/2; //Nửa chu vi tam giác
        var x = p*(p - length1)*(p - length2)*(p - length3);
        var areaTriangle = Math.sqrt(x); //Tính diện tích hình tam giác
        console.log(areaTriangle);
        document.getElementById("excer3").innerHTML = "Diện tích là: " + areaTriangle.toFixed(2) + " .Chu vi là: " + perimeterTriangle;
    } else {
        document.getElementById("excer3").innerHTML = "*không là ba cạnh của một tam giác!";
        document.getElementById("excer3").style.color = "red";
    }

}