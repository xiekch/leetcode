use std::collections::HashMap;

struct Solution;
impl Solution {
    pub fn find_the_difference(s: String, t: String) -> char {
        let mut char_count: HashMap<char, i32> = HashMap::new();
        for ch in s.chars() {
            let count = char_count.entry(ch).or_insert(0);
            *count += 1;
        }
        // println!("{:?}", char_count);

        for ch in t.chars() {
            if let Option::Some(&count) = char_count.get(&ch) {
                if count > 0 {
                    char_count.insert(ch, count - 1);
                } else {
                    return ch;
                }
            } else {
                return ch;
            }
        }
        return ' ';
    }
}

fn main() {
    let test_cases = [("abcd", "abcde", 'e'), ("", "y", 'y'), ("a", "aa", 'a')];
    for test_case in test_cases {
        let res =
            Solution::find_the_difference(String::from(test_case.0), String::from(test_case.1));
        println!("{}", res);
        assert_eq!(test_case.2, res)
    }
}
