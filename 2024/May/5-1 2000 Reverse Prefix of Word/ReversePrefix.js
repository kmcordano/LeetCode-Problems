/**
 * @param {string} word
 * @param {character} ch
 * @return {string}
 */
var reversePrefix = function(word, ch) {
    let index = 0;
    let result = word;
    for(index = 0; index < word.length; index++) {
        if(word[index] != ch) {
            continue;
        }

        result = '';
        for(let i = index; i >= 0; i--) {
            result += word[i];
        }
        for(index = index + 1; index < word.length; index++) {
            result += word[index];
        }
        break;
    }
    return result;
};