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

## Question 3 - Maximum Sum of any Contiguous Subarray

If a subarray already has a negative sum then there is no point of researching that sub array further. If I have start and end of the subarray stored somewhere and keep iterating through the loop updating the maximum value and start and end.

```py
def maximumSubArraySum(A):
  max = current_sum = start = end = 0
  good_subarrays = []
  for i in range(len(A)):
    current_sum += A[i]
    if current_sum<0 and end>=start:
      good_subarrays.append({'start':start, 'end': end, 'sum': max})
      max, current_sum = 0
      start = end = i+1
    elif max<current_sum:
      end = i
      max = current_sum
  # After storing all of the subarrays with a positive vlaue that cant improve anymore
  # by adding new elements
  max = 0
  for i in range(len(good_subarrays)):
    sub_arr = good_subarrays[i]
    if sub_arr['sum'] > max:
      start = sub_arr['start']
      end = sub_arr['end']
  return A[start:end+1]
```

Well after all of that I realize the question wasn't asking for the subarray just the sum but since I spent so much time writing that I am not going to remove it.

But here is the shorter version:

```py
def maximumSubArraySum(A):
  max = current_sum = 0
  for i in range(len(A)):
    current_sum += A[i]
    if current_sum<0:
      current_sum = 0
    elif max<current_sum:
      max = current_sum
  return max
```

So evidently we are looping through the entire array once so the time complexity if $\Theta(n)$.

**Note:** I agree this algorithm may not look like a dynamic programing algorithm but just because an algorithm does not have a big table doesn't mean it isn't a dynamic programing algorithm. In this case since I am storing the previous max and reusing it to get to the correct solution it technically qualifies as a dynamic programing algorithm.

## Question 4 - Number Solitaire

## Question 5 - Longest Decreaseing Subsequence

## Question 6
