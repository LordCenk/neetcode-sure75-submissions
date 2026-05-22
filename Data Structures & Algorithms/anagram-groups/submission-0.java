class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for(int i = 0; i<strs.length; i++){
            if(visited[i]){
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;
            char[] first = strs[i].toCharArray();
            Arrays.sort(first);
            String sortedFirst = new String(first);
            for(int j = i+1; j<strs.length; j++){
                char[] second = strs[j].toCharArray();
                Arrays.sort(second);
                String sortedSecond = new String(second);
                if (sortedFirst.equals(sortedSecond)) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }
            result.add(group);
        }
        return result;
    }
}