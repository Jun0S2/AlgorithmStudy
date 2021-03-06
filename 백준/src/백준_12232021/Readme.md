# [자료구조 알고리즘] 중앙값 구하기

백준 1655는 중앙값 구하기 문제이다. 처음 이 문제를 접했을 때, minHeap으로 풀어야겠다고 생각했으나 혹시나하는 마음에 arraylist를 사용해보았지만 어김없이 시간초과가 나왔다.

다시 minHeap으로 바꾸어 풀으려했지만 생각처럼 나오지 않아 검색한 결과, minHeap과 maxHeap 둘 다 사용하여 푸는 문제였다. 자료구조 알고리즘으로 꽤 많이 쓰이는 것 같고, 그닥 어렵지 않은 알고리즘이라 정리를 해두려고 한다.

## 알고리즘
여러 블로그를 검색하다 https://www.crocus.co.kr/625 님의 블로그가 가장 알기 쉽게 설명되어 있었다.
maxHeap에는 중앙값 보다 작은 값들을 , minHeap에는 중앙값 보다 큰 값들을 정리하다보면 중앙값은 maxHeap의 top이 된다.

> ## 1. 최대힙의 크기는 최소힙의 크기와 같거나 하나 크다
> ## 2. 최대힙의 top(중앙값보다 작은 수들 중 최대원소)은 최소힙의 top(중앙값 보다 큰 수들 중 최소원소)보다 작거나 크다
> ## 3. 위 1번과 2번 과정을 통해 생성된 큐의 최대힙의 top이 바로 중앙 값이 된다


위 알고리즘으로 [1,2,3,4,5]의 중앙 값을 구하는 과정은 아래와 같다.

![자료구조 알고리즘 - 중간값구하기](https://user-images.githubusercontent.com/36508552/147251215-82e32d0f-6ee9-429c-9f1d-a3b3ed20bdba.png)


## 정리

![1](https://user-images.githubusercontent.com/36508552/147251133-083e54ae-7a95-41ca-a762-371fbf96d5b9.png)



<hr>
for my reference only: https://app.diagrams.net/#G1CLSY4BAzEiwUwhbjIDNDgxYwblZToXR4