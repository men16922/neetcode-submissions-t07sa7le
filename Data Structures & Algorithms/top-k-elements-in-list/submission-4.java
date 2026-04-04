class Solution {
    /*
    문제 이해
        nums 정수 배열에서 빈도 순으로 top k까지의 숫자들을 반환한다
    풀이
        1. 각 숫자의 빈도를 HashMap으로 계싼 (숫자 -> 빈도)
        2. (빈도, 숫자) 형태의 배열을 리스트에 담아 빈도 기준 내림차순 정렬
        3. 앞에서부터 k개의 숫자를 결과로 반환
    */
    public int[] topKFrequentSort(int[] nums, int k) {
        // 숫자별 등장 횟수를 저장할 맵 (key: 숫자, value: 빈도)
        HashMap<Integer, Integer> count = new HashMap<>();
        
        // 1) 빈도 계산: nums를 한 번 순회하며 각 숫자의 카운트를 증가
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // 2) (빈도, 숫자) 쌍을 보관할 리스트
        List<int []> arr = new ArrayList<>();

        // 정렬 기준이 '빈도'이므로 비교가 편하도록 (freq, num) 순서로 저장
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int [] {entry.getValue(), entry.getKey()});
        }

        // 빈도 기준 내림차순 정렬
        arr.sort((a, b) -> Integer.compare(b[0], a[0]));

        // 상위 k개 숫자만 결과 배열에 담기
        int [] res = new int [k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 1) 숫자별 빈도 집계: num -> count
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // 2) (빈도, 숫자)를 담는 최소 힙 구성
        PriorityQueue<int []> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // 3) HashMap 엔트리를 순회하여 힙에 넣고, 사이즈가 k를 넘으면 poll()로 최소 빈도 제거
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int []{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 4) Heap에서 k를 꺼내 결과 배열 구성
        int [] res = new int [k];
        for (int i = 0; i < k; i++){
            res[i] = heap.poll()[1];
        }
        return res;
    }
}
