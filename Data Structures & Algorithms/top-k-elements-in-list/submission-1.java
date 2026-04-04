class Solution {
    /*
    문제 이해
        nums 정수 배열에서 빈도 순으로 top k까지의 숫자들을 반환하라
    */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>(); // 빈도 배열

        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            arr.add(new int [] {entry.getValue(), entry.getKey()});
        }
        arr.sort((a, b) -> b[0] - a[0]);

        int [] res = new int [k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }

        return res;
    }
}
