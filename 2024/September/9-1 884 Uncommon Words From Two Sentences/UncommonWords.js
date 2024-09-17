/**
 * @param {string} s1
 * @param {string} s2
 * @return {string[]}
 */
var uncommonFromSentences = function(s1, s2) {
    const wordCount = {};
    s1.split(' ').forEach((word) => {
        wordCount[word] = (wordCount[word] || 0) + 1;
    });

    s2.split(' ').forEach((word) => {
        wordCount[word] = (wordCount[word] || 0) + 1;
    });

    return Object.entries(wordCount).filter(entry => entry[1] === 1).map(entry => entry[0]);
};