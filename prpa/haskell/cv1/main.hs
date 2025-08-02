main = putStrLn "Nazdar!"

tritagle a b c  | a + b > c = True
                | a + c > b = True
                | b + c > a = True
                | otherwise = False
