import java.util.*;
class Solution {
    public int[] solution(String s) {
        // 중복 원소 가능, 순서 있음 -> 순서 다르면 다른 튜플
        // 튜플과 원소는 다르다. 원소는 전체이고, 튜플은 그 안의 나올 수 있는 조합
        // 원소 길이대로 오름차순 정렬
        // 새로 생겨난 숫자부터 뒤에 추가하기. 원소 중복 있을 수 있다. 튜플에는 중복되는 원소가 없다.
        List<List<Integer>> list = new ArrayList<>();
        s = s.substring(2, s.length()-2);
        String[] strs = s.split("\\},\\{");
        for(String str : strs) {
            List<Integer> temp = new ArrayList<>();
            for(String num : str.split(",")) {
                temp.add(Integer.parseInt(num));
            }
            list.add(temp);
        }
        list.sort((o1, o2) -> o1.size() - o2.size());
        // list.sort(Comparator.comparingInt(List::size));
        Set<Integer> set = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        for(List<Integer> nums : list) {
            for(int n : nums) {
                if(!set.contains(n)) {
                    set.add(n);
                    answer.add(n);
                }
            }
        }
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
} 