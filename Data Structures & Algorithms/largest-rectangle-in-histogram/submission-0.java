class Solution {
    public int largestRectangleArea(int[] heights) {
        // 스택에는 "인덱스"를 저장
        // 그리고 항상 heights[stack]이 오름차순(증가)를 유지하도록 관리
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        // 마지막까지 남아 있는 막대를 처리하기 위해
        // i == heights.length 일 때 높이 0인 막대를 하나 추가한 것처럼 처리
        for (int i = 0; i <= heights.length; i++) {
            // 현재 높이 (마지막은 0으로 강제)
            int currHeight = (i == heights.length) ? 0 : heights[i];

            /*
                현재 높이가 스택 top보다 작아지는 순간:
                -> stack top 막대는 더 이상 오른쪽으로 확장 불가
                -> 지금이 그 막대를 "최소 높이"로 하는 최대 직사각형을 계산할 타이밍
            */
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                // 직사각형의 "높이"가 되는 막대
                int height = heights[stack.pop()];
                /*
                    width 계산 핵심
                    오른쪽 경계:
                        현재 인덱스 i (height보다 작은 첫 번째 위치)
                    왼쪽 경계:
                        stack.peek() (height보다 작은 왼쪽 첫 번째 위치)
                        -> stack이 비어 있으면 왼쪽 끝까지 확장 가능

                    따라서 실제 확장 가능한 범위는:
                        (왼쪽 작은 값 + 1) ~ (오른쪽 작은 값  - 1)
                    width:
                        stack 비었으면 -> 0 ~ i-1 -> i
                        아니면 -> i - stack.peek() - 1
                */
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                // 현재 막대를 높이로 하는 최대 직사각형 넒이 계산
                int area = height * width;
                // 최대값 갱신
                maxArea = Math.max(maxArea, area);

            }
            // 현재 막대 인덱스를 스택에 넣음
            // 이후 막대들과 비교 기준이 됨
            stack.push(i);
        }
        return maxArea;
    }
}
