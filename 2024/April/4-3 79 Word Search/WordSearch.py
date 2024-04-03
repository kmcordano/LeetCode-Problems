from typing import List

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        current = 0
        visited = [[0 for x in range(len(board))] for y in range(len(board[0]))]

        def search(i: int, j: int, word: str) -> bool:
            nonlocal current, visited, board

            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
                return False
            if board[i][i] != word[0]:
                return False
            if visited[i][j] == current:
                return False    
            if len(word) == 1:
                return True
            
            visited[i][j] = current
            nextWord = word[1:]

            res = search(i-1, j, nextWord) or search(i, j-1, nextWord) or search(i+1, j, nextWord) or search(i, j+1, nextWord)
            if res is False:
                visited[i][j] = current - 1
            
            return res

        for i in range(len(board)):
            for j in range(len(board[0])):
                current += 1
                if search(i, j, word):
                    return True
        
        return False