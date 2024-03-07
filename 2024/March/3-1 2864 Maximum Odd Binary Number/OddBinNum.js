const maximumOddBinaryNumber = function (s) {
    var result = "";
    var p0 = result.length - 2;
    var p1 = 1;
    var first1 = true;

    for(var i = 0; i < s.length; i++) {
        console.log(i + " " + s[i]);
        if(s[i] == "1") {
            if(first1) {
                first1 = false;
            }
            else {
                result = "1" + result;
            }
        }
        else {
            result = result + "0";
        }
    }

    return result + "1";
}

console.log(maximumOddBinaryNumber("0101"));