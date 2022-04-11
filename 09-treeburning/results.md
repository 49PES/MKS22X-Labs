Why did you choose the board size for your finalized table?

1) I chose 100 for the board size for my finalized table so that the board was large enough to approximate ideal behavior but also low enough that it could perform as many repetitions as it needed to

Why did you choose the number of repetitions size for your finalized table?

2) I chose 1000 repetitions over the interval of 55% to 65% density to maximize the precision. Since BurnTrees is O(# of trees burned), it seemed viable to do more repetitions around the half-way range, where there are fewer trees to burn.

What did your testing show about changing the board size?
3) Testing showed that as you increased the board size, the skew in the times at different densities widened tremendously. For instance, while testing a 10 x 10 board, the average times ranged roughly between 0 and 15, with little variation, but testing at a size of 1000 x 1000 yielded a range of average times from 0 to ~2500.

Knowing that there were differences based on boardsize, what was the relationship between the board size and the maximum burn time? How did you test this?
4)  The maximum burn time tends to be roughly a bit more than double the dimensions of the board. I tested this with different board sizes, with an average of 201.83 ticks for a 100 x 100 board trial and an average of 2585.76 ticks for a 1000 x 1000 board trial.


What density of trees yields the maximum burn time?
Roughly 60% density

# FIRST TRIAL #
- 100 repetitions
- 100 x 100 Board
- 5% density increment
- From 0.05 to 0.95

| Density        | Average Time   |        
| ------------- |:-------------:|
| 0.05 |	 1.25 |
| 0.1 |	 1.82 |
| 0.15 |	 2.79 |
| 0.2 |	 3.43 |
| 0.25 |	 4.8 |
| 0.3 |	 6.34 |
| 0.35 |	 9.63 |
| 0.4 |	 12.63 |
| 0.45 |	 17.7 |
| 0.5 |	 31.65 |
| 0.55 |	 66.2 |
| 0.6 |	 201.83 |
| 0.65 |	 171.68 |
| 0.7 |	 145.5 |
| 0.75 |	 131.34 |
| 0.80 |	 121.88 |
| 0.85 |	 115.7 |
| 0.90 |	 110.43 |
| 0.95 |	 106.02 |

# SECOND TRIAL #
- 100 x 100 Board
- 1% density increment
- 1000 repetitions
- From 55% density to 65% density

| Density        | Average Time   |        
| ------------- |:-------------:|
| 0.55 |	 160.52 |
| 0.56 |	 212.77 |
| 0.57 |	 333.03 |
| 0.58 |	 570.71 |
| 0.59 |	 1798.14 |
| 0.60 |	 2585.76 |
| 0.61 |	 1995.91 |
| 0.62 |	 1767.35 |
| 0.63 |	 1640.79 |
| 0.64 |	 1557.82 |
