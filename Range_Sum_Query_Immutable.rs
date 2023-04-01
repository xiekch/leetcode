struct NumArray {
    accumulates: Vec<i32>,
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl NumArray {
    fn new(nums: Vec<i32>) -> Self {
        let mut sum = 0;
        let mut accumulates: Vec<i32> = Vec::new();
        accumulates.push(0);
        for i in &nums {
            sum += i;
            accumulates.push(sum);
        }

        Self { accumulates }
    }

    fn sum_range(&self, left: i32, right: i32) -> i32 {
        return self.accumulates[(right + 1) as usize] - self.accumulates[left as usize];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * let obj = NumArray::new(nums);
 * let ret_1: i32 = obj.sum_range(left, right);
 */

fn main() {}
