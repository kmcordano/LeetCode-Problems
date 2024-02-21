var rangeBitwiseAnd = function(left, right) {
    while(right > left) {
        right = right & (right - 1);
    }
    while(left != right) {
        left = left & (left - 1);
    }

    return left;
};