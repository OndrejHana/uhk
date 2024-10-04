-- pyr n x | n == 1 = x + 1
--         | otherwise = pyr (n-1) (x*x)
--

-- pyr n   | n == 0 = 1
--         | otherwise = (n*n)+pyr (n-1)

pyr n   | n == 1 = 1
        | otherwise = ((n+(n-1))^2) + pyr (n-1)
