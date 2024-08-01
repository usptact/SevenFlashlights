# Seven Flashlights

You are given a flashlight and 7 batteries. Exactly 4 batteries are good and exactly 4 batteries are totally dead. The flashlight needs two good batteries to work. If even one battery is dead, it won't work.

Problem: Find two working batteries with least number of tries.

# Solutions

There are several different solutions. It is fairly easy to find a solution of 8 tests. The best solution appears to lower it to 7 tests.

The naive solution comparing every battery with every one is 23 tests.

# Probabilistic Solution

Can probabilities work in our favor? What if we simply pick two batteries at random?

Questions:

1. What is the expected number of tests to find two good batteries?
2. How does the probability distribution looks like?
3. Given some success probability, say 95%, what is the number of tests to do?

# Credits

Inspired from [MindYourDecision](https://youtu.be/Zm1PUSfUMnE?si=uCQGOkzDNlVnZ2GG) Youtube video.
