class Solution:
    def minimumLength(self, s: str) -> int:
        pre = 0
        suf = len(s) - 1

        if s[pre] != s[suf]:
            return len(s)

        curChar = s[pre]
        while pre < suf:
            while pre < suf and s[pre] == curChar:
                pre += 1
            
            if pre == suf:
                return 0
            
            while pre < suf and s[suf] == curChar:
                suf -= 1

            if s[pre] == s[suf]:
                curChar = s[pre]
            else:
                return suf - pre + 1

        return suf - pre + 1
        