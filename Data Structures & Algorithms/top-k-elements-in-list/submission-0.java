class Solution {
    public int[] topKFrequentSorting(int[] nums, int k) {
        // 1. 빈도수 계산
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. (숫자, 빈도수) 쌍을 리스트로 반환
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freqMap.entrySet());

        // 3. 빈도수 기준으로 내림차순 정렬
        entries.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // 4. 상위 k개의 숫자 추출
        int [] result = new int [k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }
        return result;
    }

    public int[] topKFrequentMinHeap(int[] nums, int k) {
        // 1. 빈도수 계산
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. Min Heap 생성 (빈도수 기준)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));

        // 3. Heap에 요소 추가 (크기 K 유지)
        for (int num : freqMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // 가장 빈도수 낮은 거 제거
            }
        }

        // 4. 상위 K개의 숫자 추출
        int [] result = new int [k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 1. 빈도수 계산
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. Bucket 생성 (인덱스 = 빈도수)
        List<Integer> [] bucket = new List[nums.length + 1];
        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        // 3. 빈도수 높은 것부터 K개 추출
        int [] result = new int [k];
        int idx = 0;

        for (int freq = bucket.length - 1; freq >= 0 && idx < k; freq--) {
            if (bucket[freq] != null) {
                for (int num : bucket[freq]) {
                    result[idx++] = num;
                    if (idx == k) break;
                }
            }
        }

        return result;
    }

}
