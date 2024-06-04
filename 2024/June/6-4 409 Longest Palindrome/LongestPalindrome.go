package main

func main() {

}

func longestPalindrome(s string) int {
	var counts = make(map[rune]int)
	var oddCount = 0

	for _, c := range s {
		counts[c] = counts[c] + 1
		if counts[c]%2 == 0 {
			oddCount--
		} else {
			oddCount++
		}
	}

	if oddCount > 1 {
		return len(s) - oddCount + 1
	}
	return len(s)
}
