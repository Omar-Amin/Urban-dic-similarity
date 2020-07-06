# Similarity between different Urban Dictionary posts
How? The idea is that you take cosine similarity[1] between two strings. The two strings are converted into two vectors, which we can use to calculate the cosine similarity.

API's used:
- https://rapidapi.com/community/api/urban-dictionary (Urban Dictionary)

Libraries used:
- http://kong.github.io/unirest-java/ (Easier API requests)

[1]: http://blog.christianperone.com/2013/09/machine-learning-cosine-similarity-for-vector-space-models-part-iii/ (cosine similarity).
