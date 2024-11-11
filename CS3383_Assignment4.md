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

## Question 2 - Smallest Subset Sum

So if I was to implement this recursively using brute force calcualtion I would do it like this:

```py

smallest_subset = [0]*n

def smallestSubsetSum(S, g):
  if g<0: # Failed
    return {"success": True, "subset": []}
  elif g==0: # success
    s = []
    for i in range(len(S)):
      if S[i]<0:
        s.append(S[i])
    return {"success": False, "subset": s}
  for i in range(len(S)):
    k = S[i]
    if k>0:
      S[i] = -k
      result = smallestSubsetSum(S, g-k)
      if result["success"]:
        if len(result["subset"])<len(smallest_subset):
          smallest_subset = result["subset"]
    S[i] = k
    return {"success": len(smallest_subset)>0 and len(smallest_subset)<n, "subset": smallest_subset}
```

Now if $S$ was in descending order I would essintially be doing a greedy search algorithm if I ran the smallestSubsetSum algorithm on a subset on the left and grow the subset each time.

```py
def dynamic_smallestSubSet(S, g):
  mergeSort(S)
  n = len(S)
  table = [[float('inf')]*(g+1) for _ in range(n)]
  table[0][0] = 0
  for i in range(1, n+1):
    for j in range(g+1):
      pass
```
