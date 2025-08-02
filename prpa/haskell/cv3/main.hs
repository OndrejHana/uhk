sign x  | x > 0 = 1
        | x == 0 = 0
        | otherwise = -1


fekts x | x < 0 = error "kekw noob xd lol"
        | x == 0 = 1
        | otherwise = x * fekts (x-1)

nice = fekts 69


fekts1 0 = 1
fekts1 x = x * fekts (x-1)
