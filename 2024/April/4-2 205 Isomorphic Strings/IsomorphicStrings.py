class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        sTOt = {}

        for sChar, tChar in zip(s, t):
            if not sChar in sTOt:
                if not tChar in sTOt.values():
                    sTOt[sChar] = tChar
                else:
                    return False
            elif sTOt[sChar] != tChar:
                return False
        
        return True