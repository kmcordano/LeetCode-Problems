/**
 * @param {string} s
 * @return {number}
 */
var minimumLength = function(s) {
    var pre = 0;
    var suf = s.length - 1;

    if(s[pre] != s[suf]) {
        return s.length;
    }

    curChar = s[pre];
    while(pre < suf) {
        while(pre < suf && s[pre] == curChar) {
            pre++;
        }

        if(pre == suf) {
            return 0;
        }

        while(pre < suf && s[suf] == curChar) {
            suf--;
        }

        if(s[pre] == s[suf]) {
            curChar = s[pre];
        }
        else {
            return suf - pre + 1;
        }
    }

    return suf - pre + 1;
};