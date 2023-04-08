use std::cmp::Ordering;
use std::collections::BinaryHeap;

// merge k sorted list
// https://leetcode.com/problems/super-ugly-number/solutions/277313/my-view-of-this-question-hope-it-can-help-you-understand/?orderBy=most_votes
struct Solution {}

#[derive(Debug, Eq, PartialEq)]
struct ListItem {
    cur: i64,
    prime: i64,
    index: u32,
}
impl Ord for ListItem {
    fn cmp(&self, other: &ListItem) -> Ordering {
        other.cur.cmp(&self.cur)
    }
}
impl PartialOrd for ListItem {
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        Some(self.cmp(other))
    }
}

impl Solution {
    pub fn nth_super_ugly_number(n: i32, primes: Vec<i32>) -> i32 {
        if n == 1 {
            return 1;
        }

        let mut heap: BinaryHeap<ListItem> = BinaryHeap::new();
        for i in primes {
            heap.push(ListItem {
                cur: i as i64,
                prime: i as i64,
                index: 0,
            })
        }

        let mut nums: Vec<i64> = Vec::new();
        let mut size: i32 = 0;

        while size < n - 1 {
            if let Option::Some(item) = heap.pop() {
                if Some(&item.cur) != nums.last() {
                    size += 1;
                    nums.push(item.cur);
                }
                // println!("{:?}", item);
                // println!("push {}", item.cur * nums[item.index as usize]);
                heap.push(ListItem {
                    cur: item.prime * nums[item.index as usize],
                    prime: item.prime,
                    index: item.index + 1,
                })
            } else {
                break;
            }
        }

        return nums[size as usize - 1] as i32;
    }
}

fn main() {
    let test_cases = [
        (12, vec![2, 7, 13, 19], 32),
        (1, vec![2, 7, 13, 19], 1),
        (120, vec![2, 7, 13, 19, 29], 4408),
        (5911, vec![2, 3, 5, 7], 2144153025),
    ];
    for test_case in test_cases {
        let res = Solution::nth_super_ugly_number(test_case.0, test_case.1);
        println!("{}", res);
        assert_eq!(test_case.2, res)
    }
}
