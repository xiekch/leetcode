/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * unsafe fn guess(num: i32) -> i32 {}
 */
struct Solution;
impl Solution {
    unsafe fn guessNumber(n: i32) -> i32 {
        let mut low = 1;
        let mut high = n;
        while low <= high {
            let mid = ((low as i64 + high as i64) / 2) as i32;
            let guess_res = guess(mid);
            // println!("{}", mid);
            if guess_res < 0 {
                high = mid - 1;
            } else if guess_res > 0 {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}

static mut picked: i32 = 0;
unsafe fn guess(num: i32) -> i32 {
    if num > picked {
        return -1;
    }
    if num < picked {
        return 1;
    }

    return 0;
}

fn main() {
    let test_cases = [(2126753390, 1702766719)];
    for test_case in test_cases {
        unsafe {
            picked = test_case.1;
            let res = Solution::guessNumber(test_case.0);
            println!("{}", res);
            assert_eq!(test_case.1, res)
        }
    }
}
