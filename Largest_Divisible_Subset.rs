struct Solution;
impl Solution {
    pub fn largest_divisible_subset(mut nums: Vec<i32>) -> Vec<i32> {
        if nums.is_empty() {
            return Vec::new();
        }

        nums.sort_unstable();
        let n = nums.len();
        let mut dp: Vec<i32> = vec![1; n];
        let mut prev: Vec<i32> = vec![-1; n];

        let mut max_length = 0;
        let mut index: usize = 0;
        for i in 1..n {
            for j in 0..i {
                if nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i] {
                    dp[i] = dp[j] + 1;
                    prev[i] = j as i32;
                }
            }
            if dp[i] > max_length {
                max_length = dp[i];
                index = i;
            }
        }
        // println!("{:?}", dp);
        // println!("{:?}", prev);
        let mut res = Vec::new();
        while index != usize::MAX {
            res.push(nums[index]);
            index = prev[index] as usize;
        }
        return res;
    }
}

fn main() {
    let test_cases = [
        Vec::from([]),
        Vec::from([1, 2, 3]),
        Vec::from([1, 2, 4, 8]),
        Vec::from([2, 3, 9, 12, 18, 36, 81]),
        Vec::from([5, 10, 150, 20, 450]),
    ];
    for test_case in test_cases {
        let res = Solution::largest_divisible_subset(test_case);
        println!("{:?}", res);
        // assert_eq!(test_case.1, res)
    }
}
