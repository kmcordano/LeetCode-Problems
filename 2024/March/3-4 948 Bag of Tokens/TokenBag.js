const bagOfTokensScore = function(tokens, power) {
    var score = 0;
    var maxScore = 0;
    tokens.sort((a,b) => (a - b));

    if(tokens.length === 0 || power < tokens[0]) {
        return 0;
    }

    tokens.sort();
    var upPointer = 0;
    var downPointer = tokens.length - 1;
    var moveMade = false;
    
    do {
        moveMade = false;
        while(up < tokens.length && tokens[up] != -1 && power >= tokens[up]) {
            moveMade = true;
            power -= tokens[up];
            tokens[up] = -1;
            score++;
            up++;

            if(score > maxScore) {
                maxScore = score;
            }
        }

        if(down >= 0 && tokens[down] != -1 && score > 0) {
            moveMade = true;
            power += tokens[down];
            tokens[down] = -1;
            score--;
            down--;
        }
    }
    while(moveMade);

    return maxScore;
};