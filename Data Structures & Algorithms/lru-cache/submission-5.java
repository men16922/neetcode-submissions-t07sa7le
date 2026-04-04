class LRUCache {

    // 노드 구조: key, value + 이전/다음 포인터
    private static class Node {
        int key, value;
        Node prev, next;
        Node (int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private Map<Integer, Node> map;
    private Node head, tail; 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // 더미 head, tail 생성 (실제 데이터 아님)
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        // 사용되었으므로 맨 앞으로 이동
        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 기존 키 업데이트
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);
            return;
        }

        // 새 노드
        Node node = new Node(key, value);
        map.put(key, node);
        addToFront(node);

        // 용량 초과 -> LRU 삭제
        if (map.size() > capacity) {
            Node lru = tail.prev; // 가장 뒤에 있는 노드 = LRU
            removeNode(lru);
            map.remove(lru.key);
        }
    }

    private void addToFront(Node node) {
        // head <-> node <-> head.next 연결
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        // node.prev <-> node.next
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToFront(Node node) {
        // 기존 자리에서 제거 후 맨 앞으로 이동
        removeNode(node);
        addToFront(node);
    }
}
