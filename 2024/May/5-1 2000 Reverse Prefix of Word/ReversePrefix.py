class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        index = 0
        result = word
        for index in range(len(word)):
            if word[index] != ch:
                continue
            
            result = ''
            for i in range(index, -1, -1):
                result += word[i]
            for index in range(index + 1, len(word), 1):
                result += word[index]
            break

        return result

