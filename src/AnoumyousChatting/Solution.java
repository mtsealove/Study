package AnoumyousChatting;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] cases = {
                "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"
        };
        String[] result = solution.solution(cases);
        for (String r : result) {
            System.out.println(r);
        }
    }

    public String[] solution(String[] record) {

        ArrayList<String[]> uids = new ArrayList<>();
        for (String r : record) {
            String[] sp = r.split(" ");
            String action = sp[0];
            String uid = sp[1];
            String nickname = "";
            if (sp.length == 3) {
                nickname = sp[2];
            } else {
                for (String[] i : uids) {
                    if (i.length == 3 && i[0].equals(uid)) {
                        nickname = i[1];
                    }
                }
            }
            String[] item = {uid, nickname, action};
            uids.add(item);
            if (action.equals("Change") || action.equals("Enter")) {
                for (String[] uidObj : uids) {
                    if (uidObj[0].equals(uid)) {
                        uidObj[1] = nickname;
                    }
                }
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (String[] item : uids) {
            if (item[2].equals("Enter")) {
                result.add(item[1] + "님이 들어왔습니다.");
            } else if (item[2].equals("Leave")) {
                result.add(item[1] + "님이 나갔습니다.");
            }
        }
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
