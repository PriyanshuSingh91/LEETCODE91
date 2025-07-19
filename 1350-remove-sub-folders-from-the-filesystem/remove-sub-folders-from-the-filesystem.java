import java.util.*;

public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        result.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String prev = result.get(result.size() - 1);
            // Only add if not a subfolder of `prev`
            if (!folder[i].startsWith(prev + "/")) {
                result.add(folder[i]);
            }
        }
        return result;
    }
}
