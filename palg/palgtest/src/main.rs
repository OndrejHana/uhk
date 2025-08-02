


fn main() {

    let n = 16;
    let mut matice: Vec<Vec<u8>> = vec![vec![0; n]; n];

    for i in 0..matice.len() {
        for j in 0..matice[0].len() {
            if i > j && matice.len() - j > i {
                matice[i][j] = 1;
            }
            if i < j && matice.len() - j < i {
                matice[i][j] = 2;
            }
            if i < j && matice.len() - j < i {
                matice[i][j] = 3;
            }
            if i > j && matice.len() - j < i {
                matice[i][j] = 4;
            }
        }
    }



    println!("Hello, world!, {:?}", matice);
}
