/*
LeetCode company workers use key-cards to unlock office doors. Each time a worker uses their key-card, the security system saves the worker's name and the time when it was used. The system emits an alert if any worker uses the key-card three or more times in a one-hour period.

You are given a list of strings keyName and keyTime where [keyName[i], keyTime[i]] corresponds to a person's name and the time when their key-card was used in a single day.

Access times are given in the 24-hour time format "HH:MM", such as "23:51" and "09:49".

Return a list of unique worker names who received an alert for frequent keycard use. Sort the names in ascending order alphabetically.

Notice that "10:00" - "11:00" is considered to be within a one-hour period, while "22:51" - "23:52" is not considered to be within a one-hour period.
*/
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<Integer>> map=new HashMap<>();
        for(int i=0;i<keyName.length; i++){
            List<Integer> list=map.getOrDefault(keyName[i], new ArrayList<>());
            list.add(toMin(keyTime[i]));
            map.put(keyName[i], list);
        }
        List<String> ans=new ArrayList<>();
        for(String t: map.keySet()){
            List<Integer> list=map.get(t);
            Collections.sort(list);
            for(int i=2; i<list.size(); i++){
                if(list.get(i)-list.get(i-2)<=60){
                     ans.add(t);
                     break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
    int toMin(String time){
        String[] split = time.split(":");
        int HH = Integer.parseInt(split[0]);
        int MM = Integer.parseInt(split[1]);
        int HHToMin = HH * 60;
        int totalTimeInMin = HHToMin + MM;
        return totalTimeInMin;
    }
}
