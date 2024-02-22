const findJudge = function(n, trust) {
    var trustsSomeone = new Array(n).fill(false);
    var trustCount = new Array(n).fill(0);

    for(var [i, j] of trust) {
        trustsSomeone[i - 1] = true;
        trustCount[j - 1] = trustCount[j - 1] + 1;
    }

    for(var i = 0; i < n; i++) {
        if(!trustsSomeone[i] && trustCount[i] === n-1) {
            return i + 1;
        }
    }

    return -1;
}

const input = [[1,3],[2,3]];
console.log(findJudge(3, input));