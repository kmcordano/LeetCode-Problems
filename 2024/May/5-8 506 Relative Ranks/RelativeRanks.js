/**
 * @param {number[]} score
 * @return {string[]}
 */
var findRelativeRanks = function(score) {
    let indexes = new Map();
    let answer = new Array(score.length);

    for(let i = 0; i < score.length; i++) {
        indexes.set(score[i], i);
    }

    score.sort((a, b) => b - a);
    let place = 1;
    for(let s of score) {
        let str = '';
        switch(place) {
            case 1:
                str = 'Gold Medal';
                break;
            case 2:
                str = 'Silver Medal';
                break;
            case 3:
                str = 'Bronze Medal';
                break;
            default:
                str = String(place);
                break;
        }

        answer[indexes.get(s)] = str;
        place++;
    }

    return answer;
};