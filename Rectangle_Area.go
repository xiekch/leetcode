package main

func computeArea(aLeft int, aBottom int, aRight int, aTop int,
	bLeft int, bBottom int, bRight int, bTop int) int {
	aArea := (aRight - aLeft) * (aTop - aBottom)
	bArea := (bRight - bLeft) * (bTop - bBottom)

	left := max(aLeft, bLeft)
	right := min(aRight, bRight)
	top := min(aTop, bTop)
	bottom := max(aBottom, bBottom)
	if right <= left || top <= bottom {
		return aArea + bArea
	}
	return aArea + bArea - max((right-left)*(top-bottom), 0)
}

func max(a, b int) int {
	if a >= b {
		return a
	} else {
		return b
	}
}

func min(a, b int) int {
	if a >= b {
		return b
	} else {
		return a
	}
}
