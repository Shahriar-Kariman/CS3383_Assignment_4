# CS3383 - Assignment 4

**Author:** Shahriar Kariman

**Due:** Nov 18th

## Question 1 - N-th Catalan Number

$$
\begin{split}
  n = 0 \rightarrow (a) \rightarrow C(0) = 1
  \\
  n = 1 \rightarrow (a)(b), (ab) \rightarrow C(1) = 2
  \\
  n = 2 \rightarrow (a)(b)(c), (ab)(c), (a)(bc), (abc) \rightarrow C(2) = 4
\end{split}
$$

If I have an expression of length $n$ and I start from the $1_{st}$ character and keep expanding the size of the problem then i will keep reusing the calcualted values.

```py
def catalan(n):
  catalans = [0]*(n+1) # making an array of size n with all elements equal to 1
  catalans[0] = 1
  for i in range(1,n+1):
    for j in range(1,i+1):
      catalans[j] = catalans[j-1]*catalns[i-j]
  return catalans[j]
```
