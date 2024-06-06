package main

import (
	"sort"
)

func main() {

}

func isNStraightHand(hand []int, groupSize int) bool {
	if len(hand)%groupSize != 0 {
		return false
	}

	fillGroup := func(index int) bool {
		var target int = hand[index]
		var count int = 0

		for ; index < len(hand); index++ {
			if hand[index] == target {
				hand[index] = -1

				target++
				count++

				if count >= groupSize {
					return true
				}
			}
		}

		return false
	}

	sort.Slice(hand, func(i int, j int) bool {
		return hand[i] < hand[j]
	})

	for i, val := range hand {
		if val >= 0 {
			if !fillGroup(i) {
				return false
			}
		}
	}

	return true
}
